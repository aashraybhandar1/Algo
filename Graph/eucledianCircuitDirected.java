import java.util.*;
class Graph{
	int v;
	LinkedList<Integer>[] array;
	boolean [] visited;
	int [] in;
	int [] out;
	

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
	}

	void isConnected(int u){
		visited[u]=true;
		Iterator<Integer> it=array[u].iterator();
		while(it.hasNext()){
			int temp=it.next();
			if(visited[temp]==false){
				isConnected(temp);
			}
		}
	}

	Graph reversal(){
		Graph temp=new Graph(v);
		for(int i=0;i<v;i++){
			Iterator<Integer> it=array[i].iterator();
			while(it.hasNext()){
				int val=it.next();
				temp.addEdge(val,i);
			}
		}
		return temp;
	}

	int checkConnectibity(){
		for(int i=0;i<v;i++){
			if(array[i].size() > 0){
				isConnected(i);
				break;
			}
		}
		for(int i=0;i<v;i++){
			if(array[i].size() > 0 && visited[i]!=true)
				return -1;
		}

		Graph reverse=reversal();

		for(int i=0;i<v;i++){
			if(array[i].size() > 0){
				reverse.isConnected(i);
				break;
			}
		}

		for(int i=0;i<v;i++){
			if(reverse.array[i].size() > 0 && reverse.visited[i]!=true)
				return -1;
		}

		for(int i=0;i<v;i++){
			if(array[i].size() != reverse.array[i].size())
				return -1;
		}
		return 1;

	}
}

class eucledianCircuitDirected{
	public static void main(String args[]){
		 Graph g = new Graph(5);
        g.addEdge(1, 0);
        g.addEdge(0, 2);
        g.addEdge(2, 1);
        g.addEdge(0, 3);
        g.addEdge(3, 4);
        g.addEdge(4, 0);
        g.addEdge(2,4);
        System.out.println(g.checkConnectibity());
	}
}