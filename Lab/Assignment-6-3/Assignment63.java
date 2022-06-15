import java.util.*;

class ParentClass{
	private int data;
	public ParentClass(int d){
		data=d;
	}
	void print(){
		System.out.println("Data from parent class: "+data);
	}
}
class ChildClass extends ParentClass{
	private int data;
	public ChildClass(int d){
		super(d);
		data=10;
	}
	void print(){
		System.out.println("Data from child class: "+data);
	}
}

class Assignment63{
	public static void main(String[] args){
		ChildClass c=new ChildClass(5);
		c.print();
	}
}