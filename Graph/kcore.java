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
		array[v].add(u);
	}
	void findKcore(int k){
		boolean [] visited=new boolean[v];
		int [] size=new int [v];
		int min=Integer.MAX_VALUE;
		int min_index=0;
		for(int i=0;i<v;i++){
			size[i]=array[i].size();
			if(size[i]<min)
				min_index=i;
		}
		boolean boo=util(visited,size,min_index,k);
		for(int i=0;i<v;i++){
			if(!visited[i])
				 boo=util(visited,size,i,k);
		}
		for(int i=0;i<v;i++){
			if(size[i]>=k){
				Iterator<Integer> it=array[i].iterator();
				System.out.print("K cores of "+i+" are:");
				while(it.hasNext()){
					int as=it.next();
					if(size[as]>=k){
						System.out.print(as+" ");
					}
				}
				System.out.println("");
			}
		}
	}

	boolean util(boolean [] visited,int[] size,int src,int k){
		visited[src]=true;
		
			Iterator<Integer> it=array[src].iterator();
			while(it.hasNext()){
				int temp=it.next();
				if(size[src]<k){
					size[temp]--;
				}
				if(!visited[temp]){
					if(util(visited,size,temp,k))
						size[src]--;
				}
			}
			return (size[src]<k);
		
	}
}

public class kcore{
	public static void main(String args[]){
		 int k = 3;
    Graph g1=new Graph(9);
    g1.addEdge(0, 1);
    g1.addEdge(0, 2);
    g1.addEdge(1, 2);
    g1.addEdge(1, 5);
    g1.addEdge(2, 3);
    g1.addEdge(2, 4);
    g1.addEdge(2, 5);
    g1.addEdge(2, 6);
    g1.addEdge(3, 4);
    g1.addEdge(3, 6);
    g1.addEdge(3, 7);
    g1.addEdge(4, 6);
    g1.addEdge(4, 7);
    g1.addEdge(5, 6);
    g1.addEdge(5, 8);
    g1.addEdge(6, 7);
    g1.addEdge(6, 8);
    g1.findKcore(k);
 
    
 
    Graph g2=new Graph(13);
    g2.addEdge(0, 1);
    g2.addEdge(0, 2);
    g2.addEdge(0, 3);
    g2.addEdge(1, 4);
    g2.addEdge(1, 5);
    g2.addEdge(1, 6);
    g2.addEdge(2, 7);
    g2.addEdge(2, 8);
    g2.addEdge(2, 9);
    g2.addEdge(3, 10);
    g2.addEdge(3, 11);
    g2.addEdge(3, 12);
    g2.findKcore(k);
	}
}	