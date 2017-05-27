public class JumpingArray{
	
	static int minSteps(int [] array){
		int [] jumps=new int [array.length];
		for(int i=array.length-2;i>=0;i--){
			int val=array[i];
			int min=100000;
			for(int j=i+1;j<array.length && j<=i+val;j++){
				if(jumps[j]<min)
					min=jumps[j];
			}
			jumps[i]=min+1;
			//System.out.print(array[i]+" ");

		}
		System.out.println("");
		return jumps[0];
	}


	public static void main(String args[]){
		int [] array = {1, 3, 6, 1, 0, 9};
		System.out.println(minSteps(array));

	}
}