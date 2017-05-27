import java.util.*;
public class uglyNumber{
	public static void main(String args []){
		int [] array=new int [160];
		HashMap<Integer,Integer> m=new HashMap<Integer,Integer>();

		array[0]=1;
		int index2=0,index3=0,index5 =0;
		int value2,value3,value5=0;
		for(int i=1;i<150;i++){
			while(true){

				value2=array[index2]*2;
				if(m.get(value2)== null)
					break;
				else
					index2++;
			}
			while(true){
				value3=array[index3]*3;
				if(m.get(value3)==null)
					break;
				else
					index3++;
			}
			while(true){
				value5=array[index5]*5;
				if(m.get(value5)==null)
					break;
				else
					index5++;
			}

			int val=Math.min(Math.min(value2,value3),value5);
			if(val==value2)
				index2++;
			else if(val==value3)
				index3++;
			else
				index5++;
			array[i]=val;
			m.put(val,i);
			System.out.print(array[i]+" ");
		}
		System.out.println("");
		System.out.println(array[149]);
	}
}