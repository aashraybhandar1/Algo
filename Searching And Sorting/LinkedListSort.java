import java.util.*;
class Node{
	int data;
	Node next;
	Node(int a){
		data=a;
		next=null;
	}
	
}


class LinkedList{
	Node global=null;
	LinkedList(Node a){
		global=a;
	}

	void trav(){
		Node temp=global;
		while(temp!=null){
			System.out.println(temp.data);
			temp=temp.next;
		}
		System.out.println("");
	}

	void push(Node a){
		a.next=global;
		global=a;
	}

	void merge(Node a){
		if(a==null || a.next==null)
			return;
		Node temp=split(a);
		System.out.println(a.data +"  "+temp.data);
		merge(a);
		merge(temp);
		global=combining(a,temp);
	}

	 Node combining(Node a,Node temp){
		if(a==null)
			return temp;
		if(temp==null)
			return a;
		Node head;
		if(a.data<temp.data){
			head=a;
			head.next=(combining(a.next,temp));
		}
		else{
			head=temp;
			head.next=(combining(a,temp.next));
		}
		return head;
	}

	Node split(Node a){
		Node slow=a;
		Node fast=a;
		while(fast!=null){
			fast=fast.next;
			if(fast==null)
				break;
			if(fast.next!=null){
				slow=slow.next;
				fast=fast.next;
			}
		}
		Node temp=slow.next;
		slow.next=null;
		return temp;
	}

}



public class LinkedListSort{
	public static void main(String args[]){
		Node headref=new Node(5);
		LinkedList a=new LinkedList(headref);
		for(int i=0;i<10;i++){
			Random rand = new Random();
			Node temp=new Node(rand.nextInt(50) + 1);
			a.push(temp);
			//headref=temp;
		}
		Node headref2=headref;
		a.trav();
		a.merge(a.global);
		a.trav();																																														
		
	}																																											
}