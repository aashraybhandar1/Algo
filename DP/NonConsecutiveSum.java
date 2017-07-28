
public class NonConsecutiveSum{
	public static void main(String args []){
		int [] array={5, 5, 10, 100, 10, 5};
		int [] dp=new int[array.length+1] ;
		int max=0;
		dp[1]=array[0];
		for(int i=2;i<=array.length;i++){
			dp[i]=Math.max(dp[i-2]+array[i-1],dp[i-1]);
			if(dp[i]>max)
				max=dp[i];
		}
		System.out.println(max);
	}
}