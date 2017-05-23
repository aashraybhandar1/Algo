import java.util.*;
public class coinChange{

	static int change(int value,int [] array){
		Arrays.sort(array);
		int [] temp=new int [value+1];
		temp[array[0]]=1;
		for(int i=array[0]+1;i<=value;i++){
			for(int j=0;j<array.length;j++){
				if(array[j]==i){
					temp[i]++;
					break;
				}
			}
			int dummy=1;
			while(temp[dummy]==0 || temp[i-dummy]==0 && dummy<i){
				dummy++;
			}
			if(dummy!=i)
				temp[i]=temp[dummy]+temp[i-dummy];
			//System.out.println(temp[i]);
		}
		return temp[value];
	}


	public static void main(String args[]){
		int [] array= {1, 2, 3};
		System.out.println(change(4,array));

	}
}