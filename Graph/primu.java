import java.util.*;
class boo implements Comparable<boo>{
	int v;
	int weight;

	boo(int v,int w){
		this.v=v;
		this.weight=w;
	}

	public int compareTo(boo b){
		if(this.weight<b.weight)
			return -1;
		if(this.weight>b.weight)
			return 1;
		return 0;
	}  
}
class graph{
	ArrayList<boo> [] array;
	int v;
	int [] ans;
	boolean [] visited;
	int [] ans2;
	graph(int v){
		array=new ArrayList[v];
		this.v=v;
		ans=new int [v];
		ans2=new int[v];
		visited=new boolean[v];
		for(int i=0;i<v;i++){
			array[i]=new ArrayList<boo>();
			ans[i]=Integer.MAX_VALUE;
		}
	}

	void addEdge(int src,int dest,int w){
		boo temp=new boo(dest,w);
		array[src].add(temp);
		boo temp2=new boo(src,w);
		array[dest].add(temp2);
	}

	void primu(int start){
		ans[start]=0;
		PriorityQueue<boo> p=new PriorityQueue<boo>();
		p.add(new boo(start,0));
		while(p.isEmpty()==false){

			boo temp=p.poll();
			if(visited[temp.v]==true)
				continue;

			visited[temp.v]=true;
			Iterator<boo> it=array[temp.v].iterator();
			System.out.println("");
			while(it.hasNext()){
				boo temp2=it.next();
				System.out.println(temp.v +" and the next one  "+temp2.v +"wajan is "+temp2.weight);
				if(temp2.weight <= ans[temp2.v] && visited[temp2.v]==false ){
					p.add(new boo(temp2.v,temp2.weight));
					ans[temp2.v]=temp2.weight ;
					ans2[temp2.v]=temp.v;
				}
			}
		}
	}


}


public class primu{
	public static void main(String args []){
		graph g=new graph(9);
		 g.addEdge(0, 1, 4);
    g.addEdge(0, 7, 8);
    g.addEdge(1, 2, 7);
    g.addEdge(1, 7, 11);
    g.addEdge(2, 3, 7);
    g.addEdge(2, 8, 2);
    g.addEdge(2, 5, 4);
    g.addEdge(3, 4, 9);
    g.addEdge(3, 5, 14);
    g.addEdge(4, 5, 10);
    g.addEdge(5, 6, 2);
    g.addEdge(6, 7, 1);
    g.addEdge(6, 8, 6);
    g.addEdge(7, 8, 7);
    	g.primu(0);
    	for(int i=1;i<9;i++)
    		System.out.println(g.ans2[i]);

	}
}