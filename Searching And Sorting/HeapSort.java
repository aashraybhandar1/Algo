import java.util.*;
public class HeapSort{
	static void heap(int [] array){
		int length=array.length;
		for(int i=length/2  ;i>=0;i--)
			heapify(array,i,length-1);
		for(int i=length-1;i>=0;i--){
			int temp=array[0];
			array[0]=array[i];
			array[i]=temp;
			heapify(array,0,i);
		}
	}

	static void heapify(int [] array,int index,int n){
		int left=2*index+1;
		int right=2*index+2;
		int largest=index;
		if(left<n && array[left]>array[largest]){
			largest=left;
		}
		if(right<n && array[right]>array[largest]){
			largest=right;
		}
		if(largest!=index){
			int temp=array[largest];
			array[largest]=array[index];
			array[index]=temp;
			heapify(array,largest,n);
		}
	}

	public static void main(String args[]){
		int [] array=new int [10];

		for (int i=0;i<10;i++){
			Random rand = new Random();
			array[i]=rand.nextInt(50) + 1;
			System.out.print(array[i]+" ");
		}
		System.out.println("");
		heap(array);
		for (int i=0;i<10;i++){
			System.out.print(array[i]+" ");
		}
	}
}