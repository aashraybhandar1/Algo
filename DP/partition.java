public class partition{

	static boolean partition(int [] array){
		int sum=0;
		for(int i=0;i<array.length;i++)
			sum+=array[i];
		if(sum%2!=0)
			return false;
		boolean [][] temp=new boolean[sum/2 +1][array.length +1 ];
		for(int i=0;i<=array.length;i++)
			temp[0][i]=true;
		for(int i=1;i<=sum/2;i++)
			temp[i][0]=false;
		for(int i=1;i<=sum/2;i++){
			for(int j=1;j<=array.length;j++){
				temp[i][j]=temp[i][j-1];
				if(i>=array[j-1])
					temp[i][j]=temp[i][j-1] || temp[i-array[j-1]][j-1];
				System.out.print(temp[i][j]+" ");
			}
			System.out.println("");
		}
		return temp[sum/2][array.length];
	}

	public static void main(String args []){
		int arr[] = {3, 1, 1, 2, 2,1};
		System.out.println(partition(arr));
	}
}