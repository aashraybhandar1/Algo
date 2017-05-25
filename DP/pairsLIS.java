public class pairsLIS{
	
	static int findPairs(int [] array){
		int [] answer=new int [array.length/2];
		answer[0]=1;
		for(int i=2;i<array.length;i+=2){
			answer[i/2]=1;
			for(int j=i-1;j>=0;j=j-2){
				if(array[i]>array[j] && answer[i/2]<1+answer[(j-1)/2])
					answer[i/2]=1+answer[(j-1)/2];
			}
		}
		return answer[(array.length/2)-1];
	}

	public static void main(String args []){
		int [] array={ 5, 24, 15, 25,
                          27, 40, 50, 60 };
        System.out.println(findPairs(array));

	}
}