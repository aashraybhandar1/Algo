public class contiguousArray{
	public static void main(String args[]){
		int [] array={-2, -3, 4, -1, -2, 1, 5, -3};
		int max_value=0;
		int max_till_now=0;
		int [] value=new int [array.length];
		for(int i=0;i<array.length;i++){
			if(max_till_now+array[i]<0){
				value[i]=max_value;
				max_till_now=0;
			}
			else{
				max_till_now=max_till_now+array[i];
				if(max_till_now>max_value)
					max_value=max_till_now;
				value[i]=max_value;
			}
			System.out.print(value[i]+" ");

		}
	}
}