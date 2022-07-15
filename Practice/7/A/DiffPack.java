package pack2;

import pack1.*;

class C extends A {
    public void display() {
        // System.out.println("Class C->Different Package Subclass:: Default Variable:: " + def);
        System.out.println("Class C->Different Package Subclass:: Public Variable:: " + pub);
        // System.out.println("Class C->Different Package Subclass:: Private Variable:: " + pri);
        System.out.println("Class C->Different Package Subclass:: Protectd Variable:: " + pro);
    }
}

public class DiffPack {
    public static void main(String[] args) {
        A a = new A();
        C c = new C();

        a.display();
        c.display();

        // System.out.println("Class DiffPack->Different Package Non Subclass:: Default Variable:: " + a.def);
        System.out.println("Class DiffPack->Different Package Non Subclass:: Public Variable:: " + a.pub);
        // System.out.println("Class DiffPack->Different Package Non Subclass:: Private Variable:: " + a.pri);
        // System.out.println("Class DiffPack->Different Package Non Subclass:: Protectd Variable:: " + a.pro);
    }
}
