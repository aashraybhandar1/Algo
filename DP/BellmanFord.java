class Graph{
	int edge,vertice;
	store [] array;
	int [] value;

	class store{
		int u,v,weight;
	}

	Graph(int edge,int vertice){
		this.edge=edge;
		this.vertice=vertice;
		array=new store[edge];
		value=new int[vertice];
		for(int i=0;i<edge;i++){
			array[i]=new store();
		}

	}
	void bellman(int start){
		for(int i=0;i<vertice;i++){
			value[i]=100000;
		}
		value[start]=0;
		for(int i=0;i<vertice;i++){
			for(int j=0;j<edge;j++){
				int temp1=array[j].u;
				int temp2=array[j].v;
				int temp3=array[j].weight;
				if(value[temp1]!=100000 && value[temp2]>value[temp1]+temp3)
					value[temp2]=temp3+value[temp1];
			}
		}
		for(int i=0;i<vertice;i++){
			System.out.println(value[i]);
		}
	}
}



public class BellmanFord{
	public static void main(String args[]){
		Graph graph=new Graph(8,5);

		  // add edge 0-1 (or A-B in above figure)
        graph.array[0].u = 0;
        graph.array[0].v = 1;
        graph.array[0].weight = -1;
 
        // add array 0-2 (or A-C in above figure)
        graph.array[1].u = 0;
        graph.array[1].v = 2;
        graph.array[1].weight = 4;
 
        // add array 1-2 (or B-C in above figure)
        graph.array[2].u = 1;
        graph.array[2].v = 2;
        graph.array[2].weight = 3;
 
        // add array 1-3 (or B-D in above figure)
        graph.array[3].u = 1;
        graph.array[3].v = 3;
        graph.array[3].weight = 2;
 
        // add array 1-4 (or A-E in above figure)
        graph.array[4].u = 1;
        graph.array[4].v = 4;
        graph.array[4].weight = 2;
 
        // add array 3-2 (or D-C in above figure)
        graph.array[5].u = 3;
        graph.array[5].v = 2;
        graph.array[5].weight = 5;
 
        // add array 3-1 (or D-B in above figure)
        graph.array[6].u = 3;
        graph.array[6].v = 1;
        graph.array[6].weight = 1;
 
        // add array 4-3 (or E-D in above figure)
        graph.array[7].u = 4;
        graph.array[7].v = 3;
        graph.array[7].weight = -3;

        graph.bellman(0);




	}
}