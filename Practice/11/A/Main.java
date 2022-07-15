// Implement equals and equalsIgnoreCase in java

class Main {
    public static void main(String args[]) {
        String str1 = "hello";
        String str2 = "HELLO";

        System.out.println("Function equals:: " + str1.equals(str2));
        System.out.println("Function equalsIgnoreCase:: " + str1.equalsIgnoreCase(str2));
    }
}