import java.util.*;

class Graph{
	int v;
	int time=0;
	LinkedList<Integer> [] array;
	int [] disc;
	int [] low;
	boolean [] visited;
	boolean [] ans;
	int [] parent;

	Graph(int v){
		array=new LinkedList[v];
		this.v=v;
		disc=new int[v];
		low=new int[v];
		visited=new boolean[v];
		ans=new boolean[v];
		parent=new int[v];
		for(int i=0;i<v;i++){
			array[i]=new LinkedList<Integer>();
			parent[i]=-1;
		}
	}

	void addEdge(int u,int v){
		array[u].add(v);
		array[v].add(u);
	}

	void  articulationPoint(int src){
		visited[src]=true;
		disc[src]=low[src]=time++;
		int children=0;

		Iterator<Integer> it=array[src].iterator();

		while(it.hasNext()){
			int temp=it.next();
			if(src==5){
				System.out.println(temp+ "b00");
			}
			if(visited[temp]==false){
				children++;
				parent[temp]=src;
				articulationPoint(temp);

				low[src]=Math.min(low[src],low[temp]);

				if(parent[src]==-1 && children>1){
					System.out.println("temp is "+temp+" src is "+src);
					ans[src]=true;
				}
				if(parent[src]!=-1 && low[temp]>=disc[src]){
					System.out.println("temp is "+temp+" src is2 "+src);
					System.out.println(disc[src]+" "+low[temp]);
					ans[src]=true;
				}



			}

			else if (temp != parent[src]){
				//ystem.out.println("src is "+src+"v. is ")
				if(src==5){
				System.out.println(temp+ "b002");
			}
                low[src]  = Math.min(low[src], disc[temp]);
			}
		}

	}
	
}


public class articulatePoint{
	public static void  main(String[] args) {

	
        // Create graphs given in above diagrams
       System.out.println("Articulation points in first graph ");
        Graph g1 = new Graph(5);
        g1.addEdge(1, 0);
        g1.addEdge(0, 2);
        g1.addEdge(2, 1);
        g1.addEdge(0, 3);
        g1.addEdge(3, 4);
        g1.articulationPoint(0);
        for(int i=0;i<5;i++){
        	if(g1.ans[i])
        		System.out.println(i);
        }
        System.out.println();
 
        System.out.println("Articulation points in Second graph");
        Graph g2 = new Graph(4);
        g2.addEdge(0, 1);
        g2.addEdge(1, 2);
        g2.addEdge(2, 3);
        g2.articulationPoint(0);
        for(int i=0;i<4;i++){
        	if(g2.ans[i])
        		System.out.println(i);
        }
        System.out.println();
 
        System.out.println("Articulation points in Third graph ");
        Graph g3 = new Graph(7);
        g3.addEdge(0, 1);
        g3.addEdge(1, 2);
        g3.addEdge(2, 0);
        g3.addEdge(1, 3);
        g3.addEdge(1, 4);
        g3.addEdge(1, 6);
        g3.addEdge(3, 5);
        g3.addEdge(4, 5);
        g3.articulationPoint(0);
        for(int i=0;i<4;i++){
        	if(g3.ans[i])
        		System.out.println(i);
        }
    }
		
	}
