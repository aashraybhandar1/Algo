public class NearlySortedArray{

	static void heap(int [] array,int [] main_array,int [] new_array){
		int size=array.length;
		for(int i=size/2;i>=0;i--){
			heapify(array,i,size);
		}
		for(int i=size;i<main_array.length;i++){
			new_array[i-size]=array[0];
			for(int j=0;j<size;j++){
				System.out.print("  "+array[j]);
			}
			System.out.println("");
			array[0]=main_array[i];
			heapify(array,0,size);
		}
		for(int i=main_array.length-size;i<main_array.length;i++){
			new_array[i]=array[0];
			for(int j=0;j<size;j++){
				System.out.print("  "+array[j]);
			}
			System.out.println("");
			int temp=array[0];
			array[0]=array[(main_array.length-i)-1];
			array[(main_array.length-i)-1]=temp;
			heapify(array,0,main_array.length-i-1);
		}
	}

	static void heapify(int [] array,int index,int k){
		int left=index*2+1;
		int right=index*2+2;
		int largest=index;
		if(left<k && array[left]<array[largest]){
			largest=left;
		}
		if(right<k && array[right]<array[largest]){
			largest=right;
		}
		if(largest!=index){
			int temp=array[largest];
			array[largest]=array[index];
			array[index]=temp;
			heapify(array,largest,k);
		}
	}


	public static void main(String args[]){
		int [] array={2, 6, 3, 12, 56, 8,55};
		int k=3;
		int []temp_array=new int [k+1];
		for(int i=0;i<=k;i++){
			temp_array[i]=array[i];
		}
		int [] bla=new int[7];
		heap(temp_array,array,bla);
		for(int i=0;i<=	6;i++){
			System.out.println(bla[i]);
		}
	}
}