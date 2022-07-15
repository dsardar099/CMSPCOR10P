package pack1;

public class A {
    int def;
    public int pub;
    private int pri;
    protected int pro;

    public A() {
        def = 1;
        pub = 2;
        pri = 3;
        pro = 4;
    }

    public void display() {
        System.out.println("Class A->Original Class:: Default Variable:: " + def);
        System.out.println("Class A->Original Class:: Public Variable:: " + pub);
        System.out.println("Class A->Original Class:: Private Variable:: " + pri);
        System.out.println("Class A->Original Class:: Protectd Variable:: " + pro);
    }
}
