import java.util.*;

class Graph{
	LinkedList [] array;
	Stack<Integer> stack=new Stack<Integer>();
	Graph(int v){
		array=new LinkedList[v];
		for(int i=0;i<v;i++){
			array[i]=new LinkedList();
		}
	}
	void addEdge(int v,int e){
		array[v].add(e);
	}
	void topologicalSort(int v,boolean [] visited){
		visited[v]=true;
		Iterator<Integer> i=array[v].listIterator();
		while(i.hasNext()){
			int temp=i.next();
			if(!visited[temp])
				topologicalSort(temp,visited);
		}
		stack.push(v);

	}
}

public class TopologicalSort{
	public static void main(String args[]){
		Graph g = new Graph(6);
        g.addEdge(5, 2);
        g.addEdge(5, 0);
        g.addEdge(4, 0);
        g.addEdge(4, 1);
        g.addEdge(2, 3);
        g.addEdge(3, 1);
 
        System.out.println("Following is a Topological " +
                           "sort of the given graph");
        boolean [] visited=new boolean[6];
        g.topologicalSort(5,visited);
        while(g.stack.empty()==false){
        	System.out.print(g.stack.pop()+" ");
        }

	}
}