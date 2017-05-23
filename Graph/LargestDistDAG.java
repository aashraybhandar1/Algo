import java.util.*;
class graph{
	LinkedList [] array;
	int v ;
	Stack<Integer> st=new Stack<Integer>();
	int [] top_sort;
	int [] dist;
	graph(int v){
		this.v=v;
		array=new LinkedList[v];
		top_sort=new int[v];
		dist=new int[v];
		for(int i=0;i<v;i++){
			array[i]=new LinkedList<node_weight>();
			dist[i]=-100;
		}
	}

	class node_weight{
		int weight;
		int edge;
	}

	void addEdge(int v,int e,int weight){
		node_weight temp=new node_weight();
		temp.weight=weight;
		temp.edge=e;
		array[v].add(temp);
	}

	void topological_sort(boolean [] visited ,int v){
		if(visited[v]==true)
			return;
		visited[v]=true;
		Iterator<node_weight> i=array[v].listIterator();
		while(i.hasNext()){
			int temp=i.next().edge;
			if(!visited[temp])
				topological_sort(visited,temp);
		}
		st.push(v);
	}
	void worker_func(){
		boolean [] visited=new boolean[v];
		for(int i=0;i<v;i++){
			topological_sort(visited,i);
		}
		int i=0;
		while(!st.isEmpty()){
			top_sort[i]=st.pop();
			i++;
		}
	}

	void dist_calc(int e){
		dist[e]=0;
		for(int i=0;i<v;i++){
			Iterator<node_weight> temp=array[top_sort[i]].listIterator();
			while(temp.hasNext()){
				node_weight cur=temp.next();
				if(dist[cur.edge]<dist[i]+cur.weight)
					dist[cur.edge]=dist[i]+cur.weight;
			}
		}
		for(int i=0;i<v;i++){
			System.out.println(dist[i]);
		}

	}

}

public class LargestDistDAG{
	public static void main(String args []){
		graph g=new graph(6);
    	g.addEdge(0, 1, 5);
    	g.addEdge(0, 2, 3);
    	g.addEdge(1, 3, 6);
    	g.addEdge(1, 2, 2);
    	g.addEdge(2, 4, 4);
    	g.addEdge(2, 5, 2);
    	g.addEdge(2, 3, 7);
    	g.addEdge(3, 5, 1);
    	g.addEdge(3, 4, -1);
    	g.addEdge(4, 5, -2);

    	g.worker_func();
    	g.dist_calc(1);
 

	}
}