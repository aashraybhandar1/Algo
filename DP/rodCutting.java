import java.util.*;

public class rodCutting{

	static int rod(int [] array,int len){
		int [] value=new int [len+1];
		value[1]=array[0];
		for(int i=2;i<array.length;i++){
			value[i]=array[i-1];
		}
		for(int i=2;i<=len;i++){
			int temp=0;
			
			for(int j=i-1;j>=0;j--){
					if(value[j]+value[i-j]>temp)
						temp=value[j]+value[i-j];
			}
				value[i]=temp;
			System.out.print(value[i]+"  ");

		}
		System.out.println("");
		return value[len];


	}


	public static void main(String args []){
		int arr[] = new int[] {1, 5, 8, 9, 10, 17, 17, 20};
		System.out.println(rod(arr,arr.length));
	}
}