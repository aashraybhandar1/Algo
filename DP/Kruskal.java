import java.util.*;
class Edge implements Comparable<Edge>{
	int src;
	int dist;
	int weight;

	Edge(int src,int dest,int weight){
		this.src=src;
		this.dist=dest;
		this.weight=weight;
	}
	public int compareTo(Edge ed){
		if(this.weight<ed.weight)
			return -1;
		if(this.weight==ed.weight)
			return 0;
		return 1;
	}
}


public class Kruskal{

	static int findParent(int [] array,int i){
		if(array[i]==i)
			return i;
		return findParent(array,array[i]); 
	}

	public static void main(String [] args){

		ArrayList<Edge> array=new ArrayList<Edge>();
		array.add(new Edge(0,1,10));
		array.add(new Edge(0,2,6));
		array.add(new Edge(0,3,5));
		array.add(new Edge(2,3,4));

		

		Collections.sort(array);
		System.out.println(array.size() );
		ArrayList<Edge> ans=new ArrayList<Edge>();

		int [] boo=new int [4];
		for(int i=0;i<4;i++){
			boo[i]=i;
		}
		int count=0;
		while(count<3){
			Edge temp=array.remove(0);
			int x=findParent(boo,temp.src);
			int y=findParent(boo,temp.dist);

			if(x!=y){
				ans.add(temp);
				count++;
				boo[x]=y;
			}

		}
		for(int i=0;i<3;i++){
			System.out.println(ans.get(i).weight);
		}

	}
}