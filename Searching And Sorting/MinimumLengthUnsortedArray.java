public class MinimumLengthUnsortedArray{
	public static void main(String args[]){
		int [] array={10, 12, 20, 30, 25, 40, 32, 31, 35, 50, 60};
		int left=array.length;
		int right=0;
		for(int i=1;i<11;i++){
			if(array[i]<array[i-1]){
				left=i-1;
				break;
			}
		}
		for(int i=9;i>=0;i--){
			if(array[i]>array[i+1]){
				right=i+1;
				break;
			}
		}
		if(left==array.length && right==0){
			System.out.println("No change");
		}
		else{
			int minimum=left+1;
			int maximum=left;
			for(int i=left;i<=right;i++){
				if(array[i]>array[maximum])
					maximum=i;
				if(array[minimum]>array[i])
					minimum=i;
			}
			for(int i=0;i<left;i++){
				if(array[i]>array[minimum]){
					left=i;
					break;
				}
			}
			for(int i=right+1;i<array.length;i++){
				if(array[i]<array[maximum]){
					right=i;

					break;
				}
			}
			System.out.println("Indices are "+left+"  "+right);
		}
	}
}