import java.util.*;
class graph{
	LinkedList [] array;
	LinkedList<Integer> queue=new LinkedList<Integer>();
	graph(int v){
		array=new LinkedList[v];
		for(int i=0;i<v;i++)
			array[i]=new LinkedList();
	}

	void addEdge(int v,int node){
		array[v].add(node);
	}
	boolean detectCycle(int v,boolean [] visited,boolean [] recur){
		visited[v]=true;
		recur[v]=true;
		Iterator<Integer> trav=array[v].listIterator();
		while(trav.hasNext()){
			int temp=trav.next();
			if(!visited[temp] && detectCycle(temp,visited,recur))
				return true;
			else if(recur[temp])
				return true;
		}
		recur[v]=false; 
		return false;
	}
}


public class CycleDetection{
	public static void main(String args []){
		graph g = new graph(4);
 
         g.addEdge(0, 1);
    	g.addEdge(0, 2);
    	g.addEdge(1, 2);
    	g.addEdge(2, 0);
    	g.addEdge(2, 3);
    	g.addEdge(3, 3);
        boolean []visited=new boolean[4];
        boolean [] recur=new boolean[4];
        if(g.detectCycle(2,visited,recur))
        	System.out.println("This sucks");

	}
}