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



public class diameter{

	static int diameter(Node root){
		if(root==null)
			return 0;
		int h1=height(root.left);
		int h2=height(root.right);

		int dia_left=diameter(root.left);
		int dia_right=diameter(root.right);
		return Math.max(Math.max(dia_left,dia_right),1+h1+h2);
	}

	static int height(Node root){
		if(root==null)
			return 0;
		return Math.max(height(root.left),height(root.right))+1;
	}


	public static void main(String args[]){
		Node root=new Node(1);
 		root.left=new Node(2);
 		root.right=new Node(3);
 		root.left.left=new Node(4);
 		root.left.right=new Node(5);
 		System.out.println(diameter(root));

	}
}