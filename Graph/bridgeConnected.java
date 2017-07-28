import java.util.*;
class Graph{
	int v;
	LinkedList<Integer> [] array;
	boolean [] visited ;
	Graph(int v){
		this.v=v;
		array=new LinkedList[v];
		visited=new boolean[v];
		for(int i=0;i<v;i++){
			array[i]=new LinkedList<Integer>();
		}
	}

	void addEdge(int u,int v){
		array[u].add(v);
		array[v].add(u);
	}

	int isConnected(){

		for(int i=0;i<v;i++){
			if(array[i].size() >0){
				dfsUtil(i,visited);
				break;
			}
		}
		for(int i=0;i<v;i++){
			if(array[i].size() >0 && visited[i]==false)
				return -1;
		}
		return 0;
	}

	void dfsUtil(int i,boolean [] visited){
		visited[i]=true;
		Iterator <Integer> it=array[i].iterator();
		while(it.hasNext()){
			int temp=it.next();
			if(!visited[temp])
				dfsUtil(temp,visited);
		}
	}

	int bridge_connected(){
		if(isConnected()== -1)
			return -1;
		int odd=0;
		for(int i=0;i<v;i++){
			if(visited[i]==true && array[i].size()%2!=0)
				odd++;
		}
		if(odd>2)
			return -1;
		if(odd==2)
			return 0;
		return 1;
	}
}

class bridgeConnected{
	public static void main(String [] args){
	Graph g1=new Graph(5);
    g1.addEdge(1, 0);
    g1.addEdge(0, 2);
    g1.addEdge(2, 1);
    g1.addEdge(0, 3);
    g1.addEdge(3, 4);
    System.out.println(g1.bridge_connected());
 
    Graph g2=new Graph(5);
    g2.addEdge(1, 0);
    g2.addEdge(0, 2);
    g2.addEdge(2, 1);
    g2.addEdge(0, 3);
    g2.addEdge(3, 4);
    g2.addEdge(4, 0);
    System.out.println(g2.bridge_connected());
 
    Graph g3=new Graph(5);
    g3.addEdge(1, 0);
    g3.addEdge(0, 2);
    g3.addEdge(2, 1);
    g3.addEdge(0, 3);
    g3.addEdge(3, 4);
    g3.addEdge(1, 3);
    System.out.println(g3.bridge_connected());
 
    // Let us create a graph with 3 vertices
    // connected in the form of cycle
    Graph g4=new Graph(3);
    g4.addEdge(0, 1);
    g4.addEdge(1, 2);
    g4.addEdge(2, 0);
    System.out.println(g4.bridge_connected());
 
    // Let us create a graph with all veritces
    // with zero degree
    Graph g5=new Graph(3);
    System.out.println(g5.bridge_connected());
	}
}