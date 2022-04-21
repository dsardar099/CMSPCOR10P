import java.util.*;

class Node{
	private int data;
	private Node next;
	Node(int d){
		data=d;
	}
	int getData(){
		return data;
	}
	void setData(int d){
		this.data=d;
	}
	Node getNext(){
		return next;
	}
	void setNext(Node n){
		this.next=n;
	}
}

class LinkedListStack{
	Node head;
	
	LinkedListStack(){
		head=null;
	}
	
	void push(int data){
		Node temp=new Node(data);
		
		if(head==null){
			temp.setNext(null);
			head=temp;
		}else{
			temp.setNext(head);
			head=temp;
		}
	}
	
	void pop(){
		if(head!=null){
			Node next=head.getNext();
			Node pop=head;
			head=next;
			System.out.println("Popped data= "+pop.getData());
		}else{
			System.out.println("Stack Underflow");
		}
	}
	
	void display(){
		Node temp=head;
		System.out.println("Displaying stack");
		System.out.println("Top<-.......<-Bottom");
		while(temp!=null){
			System.out.print(temp.getData());
			temp=temp.getNext();
			if(temp!=null){
				System.out.print("<-");
			}
		}
	}
}

class Assignment3{
	public static void main(String[] args){
		LinkedListStack stack=new LinkedListStack();
		Scanner scanInput=new Scanner(System.in);
		int choice=-1;
		while(choice!=0){
			System.out.println("\n******************");
			System.out.println("Menu:");
			System.out.println("1. Push an element in stack");
			System.out.println("2. Pop an element from stack");
			System.out.println("3. Display stack");
			System.out.println("0. Exit");
			System.out.print("Enter Your Choice: ");
			choice=scanInput.nextInt();
			switch(choice){
				case 1:
					System.out.print("Please enter an integer data to push: ");
					int temp=scanInput.nextInt();
					stack.push(temp);
					break;
				case 2:
					stack.pop();
					break;
				case 3:
					stack.display();
					break;
				case 0:
					System.exit(0);
					break;
				default:
					System.out.println("please enter a valid choice");
			}
		}
	}
}