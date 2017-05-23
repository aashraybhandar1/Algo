import java.util.*;
class graph{
	LinkedList [] array;
	graph(int v){
		array=new LinkedList[v];
		for(int i=0;i<v;i++)
			array[i]=new LinkedList();
	}

	void addEdge(int v,int node){
		array[v].add(node);
	}
	void bfs(int start){
		boolean [] visited=new boolean[array.length];
		LinkedList<Integer> queue=new LinkedList<Integer>();
		visited[start]=true;
		queue.add(start);
		while(queue.size()!=0){
			int current=queue.poll();
			System.out.println(current);
			Iterator<Integer> trav=array[current].listIterator();
			while(trav.hasNext()){
				int temp=trav.next();
				if(visited[temp]!=true){
					queue.add(temp);
					visited[temp]=true;
				}
			}
		}
	}
}


public class BreadthFirstSearch{
	public static void main(String args []){
		graph g = new graph(4);
 
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);

        g.bfs(2);

	}
}