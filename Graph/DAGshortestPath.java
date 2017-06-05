import java.util.*;

class Graph{
	int v;
	Stack <Integer> st=new Stack<Integer>();
	class Node{
		int v,w;
	}

	LinkedList<Node> [] array;
	int [] dist;

	Graph(int v){
		this.v=v;
		dist=new int[v];
		array=new LinkedList[v];
		for(int i=0;i<v;i++){
			array[i]=new LinkedList<Node>();
			dist[i]=Integer.MAX_VALUE ;
		}
	}

	void topological_sort(boolean [] visited,int src){
		visited[src]=true;
		Iterator<Node> it=array[src].iterator();
		while(it.hasNext()){
			Node temp=it.next();
			if(visited[temp.v]==false){
				topological_sort(visited,temp.v);
			}
		}
		st.push(src);
	}

	void allPair(int src){
		boolean [] visited=new boolean[v];
		for(int i=0;i<v;i++){
			if(visited[i]==false){
				topological_sort(visited,i);
			}
		}
		dist[src]=0;
		while(! st.isEmpty()){
			int temp=st.pop();
			if(dist[temp]!=Integer.MAX_VALUE){
				Iterator<Node> it=array[temp].iterator();
				while(it.hasNext()){
					Node blah=it.next();
					if(dist[blah.v]>dist[temp]+blah.w){
						dist[blah.v]=dist[temp]+blah.w;
					}
				}
			}
		}
		for(int i=0;i<v;i++){
			System.out.println(dist[i]);
		}
	}

	void addEdge(int a,int b,int c){
		Node temp=new Node();
		temp.v=b;
		temp.w=c;
		array[a].add(temp);
	}

}


public class DAGshortestPath{
	public static void main(String args []){

		Graph g = new Graph(6);
        g.addEdge(0, 1, 5);
        g.addEdge(0, 2, 3);
        g.addEdge(1, 3, 6);
        g.addEdge(1, 2, 2);
        g.addEdge(2, 4, 4);
        g.addEdge(2, 5, 2);
        g.addEdge(2, 3, 7);
        g.addEdge(3, 4, -1);
        g.addEdge(4, 5, -2);

        g.allPair(1);


	}
}