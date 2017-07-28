class Node{
	int val;
	Node next;
	Node(int val){
		this.val=val;
	}
	static Node globe=null;
	void reversal(Node head,int k){
		Node head2=head;
		Node prev=null;
		while(head2!=null && head2.next!=null){
			Node boo=reversalUtil(head2,k,prev);
			System.out.println(boo.val);
			System.out.println(globe.val);
			head2=boo.next;
			prev=boo;
		}


	}

	Node reversalUtil(Node head,int k,Node prev2){
		Node prev=null;
		Node current=head;
		Node next=head.next;
		int count=0;
		while(count<k-1 && next!=null){
			current.next=prev;
			prev=current;
			current=next;
			next=current.next;
			count ++;
		}
		current.next=prev;
		head.next=next;
		if(prev2!=null){
			System.out.println("Yolo");
			System.out.println(prev2.val);
			System.out.println(current.val);
			System.out.println("hello");
			prev2.next=current;
		}
		if(prev2==null){
			Node.globe=current;
		}
		return head;

	}
}


public class reverseinsize{
	public static void main(String [] args){
		Node head=new Node(1);
		head.next=new Node(2);
		head.next.next=new Node(3);
		head.next.next.next=new Node(4);
		head.next.next.next.next=new Node(5);
		head.next.next.next.next.next=new Node(6);
		head.next.next.next.next.next.next=new Node(7);
		//head.next.next.next.next.next.next.next=new Node(8);
		head.reversal(head,4);
		Node temp=Node.globe;
		while(temp!=null){
			System.out.print(temp.val+" ");
			temp=temp.next;
		}


	} 
}