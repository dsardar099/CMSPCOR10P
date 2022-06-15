
// import java.io.FileInputStream;
// import java.io.FileOutputStream;
// import java.io.ObjectInputStream;
// import java.io.ObjectOutputStream;
// import java.io.IOException;
// import java.io.Serializable;
import java.util.Scanner;
// import java.io.File;
import java.io.*;

// helper class
class MyObjectOutputStream extends ObjectOutputStream {

    // Constructor of this class
    // 1. Default
    MyObjectOutputStream() throws IOException {

        // Super keyword refers to parent class instance
        super();
    }

    // Constructor of this class
    // 1. Parameterized constructor
    MyObjectOutputStream(OutputStream o) throws IOException {
        super(o);
    }

    // Method of this class
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
        return "Student{" +
                "Roll='" + roll + '\'' +
                ", Name=" + name +
                ", Subject=" + subject +
                ", Semester=" + sem +
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

        // File file = new File("studentRecord.dat");
        boolean append = file.exists();
        try {
            // write object to file
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

    void updateStudent() {
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
        try {
            FileOutputStream fos = new FileOutputStream(this.file, true);
            MyObjectOutputStream oos = new MyObjectOutputStream(fos);
            // TODO: update object
            oos.writeObject(s);
            oos.close();
            fos.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}

public class Assignment10 {
    public static void main(String[] args) {
        StudentManager sm = new StudentManager();
        while (true) {
            System.out.println("1. Add Student");
            System.out.println("2. Search Student");
            System.out.println("3. Display All Students");
            System.out.println("4. Update Student");
            System.out.println("5. Exit");
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
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid Choice");
            }
        }
    }
}