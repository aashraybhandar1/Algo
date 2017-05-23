import java.util.*;

public class knapsack{

	static int knap(int [] wt,int [] val,int w){
		int [][] array=new int [wt.length+1][w+1];
		for(int i=0;i<=wt.length;i++){
			for(int j=0;j<=w;j++){

				if(i==0||j==0){
					array[i][j]=0;
					continue;
				}
				if(wt[i-1]<=j){
					array[i][j]=Math.max(array[i-1][j-wt[i-1]]+val[i-1],array[i-1][j]);
				}
				else{
					array[i][j]=array[i-1][j];
				}
				System.out.print(array[i][j]+"  ");
			}
			System.out.println("");
		}
		return array[wt.length][w];
	}

	public static void main(String args[]){
		int val[] = new int[]{60, 100, 120};
    	int wt[] = new int[]{10, 20, 30};
    	int  W = 50;
    	System.out.println(knap(wt,val,W));

	}
}