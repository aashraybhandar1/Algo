import java.util.*;


class Node{
	int key;
	Node left,right;
	Node(int key){
		this.key=key;
		this.left=null;
		this.right=null;
	}
} 

 public class levelTrav{

 	static void trav(Node root){
 		Queue <Node> q=new LinkedList<Node>();
 		q.add(root);
 		while(q.isEmpty()==false){
 			Node temp=q.remove();
 			if(temp.left != null)
 				q.add(temp.left);
 			if(temp.right!=null)
 				q.add(temp.right);
 			System.out.print(temp.key+" ");
 		}
 	}

 	public static void main(String args[]){
 		Node root=new Node(1);
 		root.left=new Node(2);
 		root.right=new Node(3);
 		root.left.left=new Node(4);
 		root.left.right=new Node(5);
 		trav(root);


 	}
 }