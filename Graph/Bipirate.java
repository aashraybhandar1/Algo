import java.util.*;
class graph{
	LinkedList [] array;
	boolean isBip=false;
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
		int [] colour=new int[array.length];
		LinkedList<Integer> queue=new LinkedList<Integer>();
		visited[start]=true;
		colour[start]=1;
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
					if(colour[current]==1)
						colour[temp]=2;
					else
						colour[temp]=1;
					System.out.println("Temp  is "+temp+"colur is "+colour[temp]);

				}
				else{
					if(colour[temp]==colour[current]){
						isBip=false;
						return;
					}
				}
			}
		}
		isBip=true;
	}
}


public class Bipirate{
	public static void main(String args []){
		graph g = new graph(5);
 
        g.addEdge(0,1);
        g.addEdge(1,2);
        g.addEdge(2,3);
        g.addEdge(3,4);
        g.addEdge(4,3);
        g.addEdge(0,4);
        g.addEdge(4,0);
        g.addEdge(3,2);
        g.addEdge(2,1);
        g.addEdge(1,0);

        g.bfs(2);
        System.out.println(g.isBip);

	}
}