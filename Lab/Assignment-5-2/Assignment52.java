import java.util.*;

class IntegerWrap{
	int data;
	IntegerWrap(int d){
		data=d;
	}
}

class Assignment52{
	public static void main(String[] args){
		int a=5;
		int b=10;
		System.out.println("*****************Call By Value********************");
		System.out.println("Before Swapping: A="+a+" B="+b);
		swap(a,b);
		System.out.println("After Swapping: A="+a+" B="+b);
		
		System.out.println("*****************Call By Reference********************");
		IntegerWrap inta=new IntegerWrap(5);
		IntegerWrap intb=new IntegerWrap(10);
		System.out.println("Before Swapping: A="+inta.data+" B="+intb.data);
		swap(inta,intb);
		System.out.println("After Swapping: A="+inta.data+" B="+intb.data);
	}
	
	public static void swap(int a, int b){
		System.out.println("Inside Swap Before: A="+a+" B="+b);
		int c=a;
		a=b;
		b=c;
		System.out.println("Inside Swap After: A="+a+" B="+b);
	}
	
	public static void swap(IntegerWrap a, IntegerWrap b){
		System.out.println("Inside Swap Before: A="+a.data+" B="+b.data);
		IntegerWrap c=new IntegerWrap(a.data);
		a.data=b.data;
		b.data=c.data;
		System.out.println("Inside Swap After: A="+a.data+" B="+b.data);
	}
}