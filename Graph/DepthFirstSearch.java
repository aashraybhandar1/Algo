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
	void dfs(int start,boolean[] visited){
		visited[start]=true;
		System.out.println(start);
		Iterator<Integer> temp=array[start].listIterator();
		while(temp.hasNext()){
			int bla=temp.next();
			if(visited[bla]!=true)
				dfs(bla,visited);
		}

	}
}


public class DepthFirstSearch{
	public static void main(String args []){
		graph g = new graph(4);
 
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);
        boolean []visited=new boolean[4];
        g.dfs(2,visited);

	}
}