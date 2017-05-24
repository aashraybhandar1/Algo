public class wordsInALine{

	static void lines(int [] array,int n){
		int [][] temp=new int[array.length+1][array.length+1];
		int [][] cost=new int[array.length+1][array.length+1];
		for(int i=1;i<=array.length;i++){
			temp[i][i]=n-array[i-1];
			cost[i][i]=temp[i][i]*temp[i][i];
			if(i==array.length)
				cost[i][i]=0;
			for(int j=i+1;j<=array.length;j++){
				temp[i][j]=temp[i][j-1]-1-array[j-1];
				if(temp[i][j]<0){
					cost[i][j]=100000;
					continue;
				}
				if(temp[i][j]>0 && j==array.length){
					cost[i][j]=0;
					continue;
				}
				if(temp[i][j]>0){
					cost[i][j]=temp[i][j]*temp[i][j];
				}
			}
		}
		int [] last=new int [array.length+1];
		for(int i=1;i<=array.length;i++){
			last[i]=100000;
			for(int j=1;j<=i;j++){
				if(last[j-1] != 100000 && cost[j][i]!=100000 && last[j-1]+cost[j][i]<last[i])
					last[i]=last[j-1]+cost[j][i];

			}
			System.out.println(last[i]);
		}
		System.out.println(last[array.length]);
	}

	public static void main(String args[]){
		int l[] = {3, 2, 2, 5};
		lines(l,6);


	}
}