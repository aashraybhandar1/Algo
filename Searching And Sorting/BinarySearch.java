public class BinarySearch{

	static int bin_search(int [] array,int start,int end,int value){
		int temp=(start+end)/2;
		if(start>end)
			return -1;
		if(array[temp]==value){
			return temp;
		}
		else if(array[temp]>value){
			return bin_search(array,start,temp-1,value);
		}
		else{
			return bin_search(array,temp+1,end,value);
		}
		
	}

	public static void main(String args[]){
		int [] array=new int[25];
		for(int i=0;i<25;i++){
			array[i]=i+2;
			System.out.print(array[i]+" ");
		}
		System.out.println("");
		System.out.println(bin_search(array,0,24,24));
		System.out.println(bin_search(array,0,24,1));
	}
}