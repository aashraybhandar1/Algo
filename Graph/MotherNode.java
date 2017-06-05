import java.util.*;

class Graph{
	int v;
	LinkedList<Integer> [] array;
	Stack<Integer> st=new Stack<Integer>();

	Graph(int v){
		this.v=v;
		array=new LinkedList[v];
		for(int i=0;i<v;i++){
			array[i]=new LinkedList<Integer>();
		}
	}

	void addEdge(int u,int v){
		array[u].add(v);
	}
	int MotherUtil(){
		boolean [] visited=new boolean[v];
		for(int i=0;i<v;i++){
			if(!visited[i]){
				MotherV(visited,i);
			}
		}
		Integer temp=st.pop();
		if(dfsutil(temp)==v){
			return temp;
		}
		return -1;
	}

	void MotherV(boolean [] visited,int src){
		visited[src]=true;
		Iterator<Integer> it=array[src].iterator();
		while(it.hasNext()){
			int temp=it.next();
			if(!visited[temp]){
				MotherV(visited,temp);
			}
		}
		st.push(src);
	}

	int dfsutil(int src){
		boolean [] visited=new boolean[v];
		dfs(visited,src);
		for(int i=0;i<v;i++){
			if(!visited[i])
				return -1;
		}
		return v;
	}

	void dfs(boolean[] visited,int src){
		visited[src]=true;
		Iterator<Integer> it=array[src].iterator();
		while(it.hasNext()){
			int temp=it.next();
			if(!visited[temp]){
				dfs(visited,temp);
			}
		}
	}

}


public class MotherNode{
	public static void main(String args[]){

	Graph g=new Graph(7);
    g.addEdge(0, 1);
    g.addEdge(0, 2);
    g.addEdge(1, 3);
    g.addEdge(4, 1);
    g.addEdge(6, 4);
    g.addEdge(5, 6);
    g.addEdge(5, 2);
    g.addEdge(6, 0);
    System.out.println(g.MotherUtil());

	}

}