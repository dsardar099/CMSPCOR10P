// Implement equals method and == operator for string in java
// Both equals() method and the == operator are used to compare two objects in Java.
// == is an operator and equals() is method.
// But == operator compares reference or memory location of objects in a heap, whether they point to the same location or not.
// Whenever we create an object using the operator new, it will create a new memory location for that object.
// So we use the == operator to check memory location or address of two objects are the same or not.

// Java String Pool=> s1,s2
// Java Heap=> s3,s4
// Both s1 and s2 refer to same objects.
// When we use the == operator for s1 and s2 comparison, the result is true as both have the same addresses in the string constant pool.
// Using equals, the result is true because it’s only comparing the values given in s1 and s2.

public class Main {
    public static void main(String[] args) {
        String s1 = "hello";
        String s2 = "hello";
        String s3 = new String("hello");
        String s4 = new String("hello");

        System.out.println("s1==s2:: " + (s1 == s2));
        System.out.println("s1.equals(s2):: " + s1.equals(s2));
        System.out.println("s1==s3:: " + (s1 == s3));
        System.out.println("s1.equals(s3):: " + s1.equals(s3));
        System.out.println("s3==s4:: " + (s3 == s4));
        System.out.println("s3.equals(s4):: " + s3.equals(s4));

    }
}
