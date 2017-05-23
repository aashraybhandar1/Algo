import java.util.*;

public class minCostPath{
	static int [][] value;

	static void findValue(int[][] array){
		value=new int[array.length][array[0].length];
		for(int i=0;i<array.length;i++){
			for(int j=0;j<array[0].length;j++){
				if(i==0 && j==0){
					value[i][j]=array[i][j];
					continue;
				}
				if(i==0){
					value[i][j]=value[i][j-1]+array[i][j];
					continue;
				}
				if(j==0){
					value[i][j]=value[i-1][j]+array[i][j];
					continue;
				}
				value[i][j]=Math.min(Math.min(value[i-1][j],value[i][j-1]),value[i-1][j-1])+array[i][j];
			}
		}
	}

	public static void main(String args[]){
		int cost[][]= {{1, 2, 3},
                       {4, 8, 2},
                       {1, 5, 3}};
        findValue(cost);
        System.out.println(value[2][2]);
        System.out.println(value[2][1]);
	}
}