public class LIS{

	static int lis_value(int [] array){
		int [] value=new int[array.length];
		int max=0;
		value[0]=1;
		for(int i=1;i<array.length;i++){
			for(int j=i-1;j>=0;j--){
				if(array[j]<array[i] && value[i]<value[j]+1){
					value[i]=value[j]+1;
				}
			}
			if (value[i]==0)
				value[i]=1;
			if(max<value[i])
				max=value[i];
			//System.out.println(value[i]);
		}
		return max;
	}

	public static void main(String args[]){
		int [] array={10, 22, 9, 33, 21, 50, 41, 60};
		System.out.println(lis_value(array));

	}
}