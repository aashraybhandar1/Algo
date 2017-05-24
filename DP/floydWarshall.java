public class floydWarshall{
	
	static void allPair(int [][] dist){
		for(int k=0;k<dist.length;k++){
			for(int i=0;i<dist.length;i++){
				for(int j=0;j<dist.length;j++){
					if(dist[i][j]>dist[i][k]+dist[k][j])
						dist[i][j]=dist[i][k]+dist[k][j];
				}
			}
		}
	}

	public static void main(String args[]){
		int graph[][] = { {0,   5,  1000, 10},
                          {1000, 0,   3, 1000},
                          {1000, 1000, 0,   1},
                          {1000, 1000, 1000, 0}};
        allPair(graph);
        for(int i=0;i<graph.length;i++){
        	for(int j=0;j<graph.length;j++){
        		System.out.print(graph[i][j]+" ");
        	}
        	System.out.println("");
        }

	}
}