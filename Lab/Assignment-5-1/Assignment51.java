import java.util.*;

class Base{
	public void show(int a, int b){
		System.out.println("A: "+a+" B: "+b);
	}
	public void show(int a){
		System.out.println("A: "+a);
	}	
}

class Assignment51{
	public static void main(String[] args){
		Base bclass=new Base();
		bclass.show(10,5);
		bclass.show(10);
	}
}