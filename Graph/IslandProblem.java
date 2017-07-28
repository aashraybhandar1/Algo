public class IslandProblem{

	static void findIslands(int [][] array,boolean [][] visited,int m,int n){
		visited[m][n]=true;
		int len=array.length;
		int len2=array[0].length;
		for(int i=-1;i<=1;i++){
			for(int j=-1;j<=1;j++){
				if(m+i>=0 && m+i<len && n+j>=0 && n+j<len2 && array[m+i][n+j]==1 && visited[m+i][n+j]==false){
					findIslands(array,visited,m+i,n+j);
				}
			}
		}
	}

	static int IslandUtil(int [][] array){
		boolean [][] visited=new boolean[array.length][array[0].length];
		int ans=0;
		for(int i=0;i<array.length;i++){
			for(int j=0;j<array[0].length;j++){
				if(array[i][j]==1 && visited[i][j]==false){
					findIslands(array,visited,i,j);
					ans++;
				}
			}
		}
		return ans;
	}


	public static void main(String args[]){
		int [][] array=new int[][] {{1, 1, 0, 0, 0},
                                 {0, 1, 0, 0, 1},
                                 {1, 0, 0, 1, 1},
                                 {0, 0, 0, 0, 0},
                                 {1, 0, 1, 0, 1}
                                };

        System.out.println(IslandUtil(array));

	}
}