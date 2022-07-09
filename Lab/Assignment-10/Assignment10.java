import java.util.Scanner;
import java.util.LinkedList;
import java.util.Queue;
import java.io.*;

class MyObjectOutputStream extends ObjectOutputStream {

    MyObjectOutputStream() throws IOException {
        super();
    }

    MyObjectOutputStream(OutputStream o) throws IOException {
        super(o);
    }

    public void writeStreamHeader() throws IOException {
        return;
    }
}

class Student implements Serializable {
    int roll;
    String name;
    String subject;
    int sem;

    Student(int roll, String name, String subject, int sem) {
        this.name = name;
        this.roll = roll;
        this.subject = subject;
        this.sem = sem;
    }

    @Override
    public String toString() {
        return "Student {" +
                "Roll:" + roll +
                ", Name:" + name +
                ", Subject:" + subject +
                ", Semester:" + sem +
                '}';
    }
}

class StudentManager {
    File file;

    StudentManager() {
        this.file = new File("studentRecord.dat");
    }

    void addStudent() {
        Scanner in = new Scanner(System.in);
        int roll;
        String name;
        String subject;
        int sem;
        System.out.println("Enter Student Data");
        System.out.print("Enter roll: ");
        roll = Integer.parseInt(in.nextLine());
        System.out.print("Enter name: ");
        name = in.nextLine();
        System.out.print("Enter subject: ");
        subject = in.nextLine();
        System.out.print("Enter sem: ");
        sem = Integer.parseInt(in.nextLine());

        Student s = new Student(roll, name, subject, sem);

        if (searchStudent(s.roll) != null) {
            System.out.println("Student already exists with roll no: " + s.roll);
            return;
        }

        boolean append = file.exists();
        try {
            FileOutputStream fos = new FileOutputStream(this.file, append);
            if (file.length() == 0) {
                ObjectOutputStream oos = new ObjectOutputStream(fos);
                oos.writeObject(s);
                oos.close();
            } else {
                MyObjectOutputStream oos = null;
                oos = new MyObjectOutputStream(fos);
                oos.writeObject(s);
                oos.close();
            }
            System.out.println("Student added with roll: " + roll);
            fos.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    void addStudent(Student s) {
        boolean append = file.exists();
        try {
            FileOutputStream fos = new FileOutputStream(this.file, append);
            if (file.length() == 0) {
                ObjectOutputStream oos = new ObjectOutputStream(fos);
                oos.writeObject(s);
                oos.close();
            } else {
                MyObjectOutputStream oos = null;
                oos = new MyObjectOutputStream(fos);
                oos.writeObject(s);
                oos.close();
            }
            fos.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    Student searchStudent(int roll) {
        if (this.file.exists() != true) {
            System.out.println("Student not found with roll: " + roll);
            return null;
        }
        Student s = null;
        try {
            FileInputStream fileIn = new FileInputStream(this.file);
            ObjectInputStream objectIn = new ObjectInputStream(fileIn);
            while (fileIn.available() != 0) {
                Student std = (Student) objectIn.readObject();
                if (std.roll == roll) {
                    s = std;
                    break;
                }
            }
            objectIn.close();
            fileIn.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return s;
    }

    void displayAllStudents() {
        try {
            if (this.file.exists() != true) {
                System.out.println("No data found");
                return;
            }
            FileInputStream fileIn = new FileInputStream(this.file);
            ObjectInputStream objectIn = new ObjectInputStream(fileIn);
            while (fileIn.available() != 0) {
                Student std = (Student) objectIn.readObject();
                System.out.println(std);
            }
            objectIn.close();
            fileIn.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    Queue<Student> getAllStudent() {
        Queue<Student> q = new LinkedList<>();
        try {
            if (this.file.exists() != true) {
                return q;
            }
            FileInputStream fileIn = new FileInputStream(this.file);
            ObjectInputStream objectIn = new ObjectInputStream(fileIn);
            while (fileIn.available() != 0) {
                Student std = (Student) objectIn.readObject();
                q.add(std);
            }
            objectIn.close();
            fileIn.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return q;
    }

    void updateStudent() {
        Queue<Student> students = getAllStudent();
        Scanner in = new Scanner(System.in);
        int roll;
        String name;
        String subject;
        int sem;
        System.out.println("Enter Student Data");
        System.out.print("Enter roll: ");
        roll = Integer.parseInt(in.nextLine());
        Student s = searchStudent(roll);
        if (s == null) {
            System.out.println("Student not found");
            return;
        } else {
            System.out.println("Current details of the student:");
            System.out.println(s);
        }
        System.out.print("Enter name: ");
        name = in.nextLine();
        System.out.print("Enter subject: ");
        subject = in.nextLine();
        System.out.print("Enter sem: ");
        sem = Integer.parseInt(in.nextLine());
        s.name = name;
        s.subject = subject;
        s.sem = sem;
        if (this.file.delete()) {
            System.out.println("Updating...");
        }
        while (students.size() != 0) {
            Student std = students.remove();
            addStudent(std.roll == roll ? s : std);
        }
        System.out.println("Updated...");
    }

    void deleteStudent() {
        Queue<Student> students = getAllStudent();
        Scanner in = new Scanner(System.in);
        int roll;
        System.out.println("Enter Student Data");
        System.out.print("Enter roll: ");
        roll = Integer.parseInt(in.nextLine());
        Student s = searchStudent(roll);
        if (s == null) {
            System.out.println("Student not found");
            return;
        } else {
            System.out.println("Details of the student:");
            System.out.println(s);
            if (this.file.delete()) {
                System.out.println("Deleting...");
            }
            while (students.size() != 0) {
                Student std = students.remove();
                if (std.roll != roll) {
                    addStudent(std);
                }
            }
            System.out.println("Deleted...");
        }
    }

}

public class Assignment10 {
    public static void main(String[] args) {
        StudentManager sm = new StudentManager();
        while (true) {
            System.out.println("\n****Menu****");
            System.out.println("1. Add Student");
            System.out.println("2. Search Student");
            System.out.println("3. Display All Students");
            System.out.println("4. Update Student");
            System.out.println("5. Delete Student");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");
            Scanner in = new Scanner(System.in);
            int choice = Integer.parseInt(in.nextLine());
            switch (choice) {
                case 1:
                    sm.addStudent();
                    break;
                case 2:
                    System.out.print("Enter roll: ");
                    int roll = Integer.parseInt(in.nextLine());
                    Student s = sm.searchStudent(roll);
                    if (s != null) {
                        System.out.println("Student found: " + s);
                    } else {
                        System.out.println("Student not found");
                    }
                    break;
                case 3:
                    sm.displayAllStudents();
                    break;
                case 4:
                    sm.updateStudent();
                    break;
                case 5:
                    sm.deleteStudent();
                    break;
                case 0:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid Choice");
            }
        }
    }
}