import java.util.*;

class Graph{
	int v,e;
	Edge [] trav;
	class Edge{
		int src,dest;
	}
	Graph(int v,int e){
		this.v=v;
		this.e=e;
		trav=new Edge[e];
		for(int i=0;i<e;i++){
			trav[i]=new Edge();
		}
	}
	boolean findCycle(){
		int [] parent=new int[this.v];
		for(int i=0;i<this.v;i++)
			parent[i]=-1;
		for(int i=0;i<trav.length;i++){
			int pa1=find(parent,trav[i].src);
			int pa2=find(parent,trav[i].dest);
			if(pa1!=pa2)
				union(parent,pa1,pa2);
			else
				return true;
		}
		return false;
	}
	int find(int[] parent,int node){
		if(parent[node]==-1)
			return node;
		else
			return find(parent,parent[node]);
	}
	void union(int [] parent,int node1,int node2){
		int temp=find(parent,node1);
		int temp2=find(parent,node2);
		parent[temp]=temp2;
	}
}

public class UndirectedCycle{
	public static void main(String args[]){
		int V = 7, E = 6;
        Graph graph = new Graph(V, E);
 
        // add edge 0-1
        graph.trav[0].src = 0;
        graph.trav[0].dest = 1;
 
        // add edge 1-2
        graph.trav[1].src = 1;
        graph.trav[1].dest = 2;
 
        // add edge 0-2
        graph.trav[2].src = 3;
        graph.trav[2].dest = 2;

        graph.trav[3].src = 3;
        graph.trav[3].dest = 4;
 
        // add edge 1-2
        graph.trav[4].src = 1;
        graph.trav[4].dest = 6;
 
        // add edge 0-2
        graph.trav[5].src = 0;
        graph.trav[5].dest = 5;
 
        if (graph.findCycle()==true)
            System.out.println( "graph contains cycle" );
        else
            System.out.println( "graph doesn't contain cycle" );

	}
}