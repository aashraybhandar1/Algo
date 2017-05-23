import java.util.*;
public class QuickSort{
	static void quick(int [] array,int start,int stop){
		if(start>=stop)
			return;
		int pivot=array[stop];
		int flag=start;
		for(int i=start;i<stop;i++){
			if(array[i]<=pivot){
				int temp=array[flag];
				array[flag]=array[i];
				array[i]=temp;
				flag++;
			}
		}
		array[stop]=array[flag];
		array[flag]=pivot;
		quick(array,start,flag-1);
		quick(array,flag+1,stop);
	}
	public static void main(String argss[]){
		int [] array=new int[25];
		for (int i=0;i<25;i++){
			Random rand = new Random();
			array[i]=rand.nextInt(50) + 1;
			System.out.print(array[i]+" ");
		}
		System.out.println("");
		quick(array,0,24);
		for(int i=0;i<25;i++){
			System.out.print(array[i]+" ");
		}
	}
}