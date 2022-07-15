package pack1;

class B extends A {
    public void display() {
        System.out.println("Class B->Same Package Subclass:: Default Variable:: " + def);
        System.out.println("Class B->Same Package Subclass:: Public Variable:: " + pub);
        // System.out.println("Class B->Same Package Subclass:: Private Variable:: " + pri);
        System.out.println("Class B->Same Package Subclass:: Protectd Variable:: " + pro);
    }
}

public class SamePack {
    public static void main(String[] args) {
        A a = new A();
        B b = new B();

        a.display();
        b.display();

        System.out.println("Class SamePack->Same Package Non Subclass:: Default Variable:: " + a.def);
        System.out.println("Class SamePack->Same Package Non Subclass:: Public Variable:: " + a.pub);
        // System.out.println("Class SamePack->Same Package Non Subclass:: Private Variable:: " + a.pri);
        System.out.println("Class SamePack->Same Package Non Subclass:: Protectd Variable:: " + a.pro);
    }
}
