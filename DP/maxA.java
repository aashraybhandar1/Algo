import java.util.*;
public class maxA{

	static int max(int n){
		int [] array=new int[n];
		int current_buffer=0;
		int updated_buffer=0;
		array[0]=1;
		array[1]=2;
		array[2]=3;
		for(int i=3;i<n;i++){
			current_buffer=array[i-3];
			array[i]=Math.max(Math.max(array[i-1]+1,array[i-1]+updated_buffer),array[i-3]+current_buffer);
			if(array[i]==array[i-3]+current_buffer)
				updated_buffer=current_buffer;
		}
		return array[n-1];

	}


	public static void main(String args[]){
		System.out.println(max(11));

	}
}