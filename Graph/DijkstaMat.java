public class DijkstaMat{
	
	static void dijksta(int [][] mat,int src){
		int [] array=new int [mat.length];
		boolean [] included=new boolean[mat.length];
		for(int i=0;i<array.length;i++){
			array[i]=Integer.MAX_VALUE ;
			//System.out.println(array[i]);
		}
		array[src]=0;
		included[src]=true;

		for(int i=0;i<array.length;i++){
			if(mat[i][src]!=0)
				array[i]=mat[i][src];
		}

		for(int i=0;i<array.length ;i++){
			int min=Integer.MAX_VALUE;
			int min_index=-1;
			for(int j=0;j<array.length ;j++){
				if(array[j]<min && included[j]==false){
					min=array[j];
					min_index =j;
				}
			}
			//System.out.println("min index is "+min_index);
			if(min_index==-1)
				break;
			included[min_index]=true;
			for(int j=0;j<array.length;j++){
				if(array[min_index]+mat[min_index][j]<array[j] && mat[min_index][j]!=0){
					array[j]=array[min_index]+mat[min_index][j];
				}
			}
		}
		for(int i=0;i<array.length;i++){
			System.out.println(array[i]);
		}

	}



	public static void main(String args []){
		 int [][] graph = {{0, 4, 0, 0, 0, 0, 0, 8, 0},
                      {4, 0, 8, 0, 0, 0, 0, 11, 0},
                      {0, 8, 0, 7, 0, 4, 0, 0, 2},
                      {0, 0, 7, 0, 9, 14, 0, 0, 0},
                      {0, 0, 0, 9, 0, 10, 0, 0, 0},
                      {0, 0, 4, 14, 10, 0, 2, 0, 0},
                      {0, 0, 0, 0, 0, 2, 0, 1, 6},
                      {8, 11, 0, 0, 0, 0, 1, 0, 7},
                      {0, 0, 2, 0, 0, 0, 6, 7, 0}
                     };

        dijksta(graph,0);

	}
}