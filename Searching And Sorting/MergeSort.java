import java.util.*;
public class MergeSort{

	static void merging(int [] array,int start,int temp,int end){
		ArrayList<Integer> left=new ArrayList<Integer>();
		ArrayList<Integer> right=new ArrayList<Integer>();
		for(int i=start;i<temp+1;i++){
			left.add(array[i]);
		}
		for(int i=temp+1;i<=end;i++){
			right.add(array[i]);
		}
		int i=start;
		int j=0;
		int k=0;
		//System.out.println(start +" "+end+"  "+temp);
		//System.out.println("size is "+left.size()+"  "+right.size());
		if(left.size()==0){
			while(k<right.size()){
				array[i]=right.get(k);
				i++;
				k++;
			}
			return;
		}
		if(right.size()==0){
			while(j<left.size()){
				array[i]=left.get(j);
				i++;
				j++;
			}
			return;
		}
		while(true){
			if(j>=left.size() && k>=right.size())
				break;
			if(j>=left.size()){
				array[i]=right.get(k);
				k++;
				i++;
				continue;
			}
			if(k>=right.size()){
				array[i]=left.get(j);
				j++;
				i++;
				continue;
			}
			
			if(left.get(j)<right.get(k)){
				array[i]=left.get(j);
				j++;
				i++;
			}
			else{
				array[i]=right.get(k);
				k++;
				i++;
			}

		}
		//System.out.println("Hello");

	}

	static void merge(int [] array,int start,int end){
		if(start<end){
			int temp=(start+end)/2;
			merge(array,start,temp);
			merge(array,temp+1,end);
			merging(array,start,temp,end);
		}
		
	}

	public static void main(String args[]){
		int [] array=new int[10];
		for (int i=0;i<10;i++){
			Random rand = new Random();
			array[i]=rand.nextInt(50) + 1;
			System.out.print(array[i]+" ");
		}
		System.out.println("");
		merge(array,0,9);
		for(int i=0;i<10;i++){
			System.out.print(array[i]+" ");
		}
	}
}