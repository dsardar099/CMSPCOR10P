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

class LinkedListQueue{
	Node front;
	Node rear;
	
	LinkedListQueue(){
		front=null;
		rear=front;
	}
	
	void insert(int data){
		Node temp=new Node(data);
		temp.setNext(null);
		if(rear==null){
			rear=temp;
			front=temp;
		}else{
			rear.setNext(temp);
			rear=temp;
		}
	}
	
	void delete(){
		if(front!=null){
			Node next=front.getNext();
			Node pop=front;
			front=next;
			System.out.println("Popped data= "+pop.getData());
		}else{
			System.out.println("Queue Underflow");
		}
	}
	
	void display(){
		Node temp=front;
		System.out.println("Displaying queue");
		System.out.println("Bottom->.......->Top");
		while(temp!=null){
			System.out.print(temp.getData());
			temp=temp.getNext();
			if(temp!=null){
				System.out.print("->");
			}
		}
	}
}

class Assignment4{
	public static void main(String[] args){
		LinkedListQueue queue=new LinkedListQueue();
		Scanner scanInput=new Scanner(System.in);
		int choice=-1;
		while(choice!=0){
			System.out.println("\n******************");
			System.out.println("Menu:");
			System.out.println("1. Push an element in queue");
			System.out.println("2. Pop an element from queue");
			System.out.println("3. Display queue");
			System.out.println("0. Exit");
			System.out.print("Enter Your Choice: ");
			choice=scanInput.nextInt();
			switch(choice){
				case 1:
					System.out.print("Please enter an integer data to push: ");
					int temp=scanInput.nextInt();
					queue.insert(temp);
					break;
				case 2:
					queue.delete();
					break;
				case 3:
					queue.display();
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