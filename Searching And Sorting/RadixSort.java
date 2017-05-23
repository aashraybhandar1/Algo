import java.util.*;
//import java.Math.*;
public class RadixSort{
	static int max(int [] array){
		int max=0;
		for(int i=0;i<array.length;i++){
			if(array[i]>array[max])
				max=i;
		}
		return max;
	}
	static void radix(int [] array){
		int m=max(array);
		for(int i=0;array[m]/(Math.pow(10,i))>=1;i++){
			arrange(array,i);
		}
	}
	static void arrange(int [] array,int j){
		int [] output=new int [array.length];
		int [] count=new int[10];
		for(int i=0;i<array.length;i++){
			count[(array[i]/(int)(Math.pow(10,j)))%10]++;
		}
		for(int i=1;i<10;i++){
			count[i]+=count[i-1];
		}
		for (int i = array.length - 1; i >= 0; i--)
        {
            output[count[ (array[i]/(int)Math.pow(10,j))%10 ]-1] = array[i];
            count[ (array[i]/(int)(Math.pow(10,j)))%10 ]--;
        }
        for(int i=0;i<array.length;i++){
        	array[i]=output[i];
        }

	}
	public static void main(String args []){
		int [] array=new int[25];
		for (int i=0;i<25;i++){
			Random rand = new Random();
			array[i]=rand.nextInt(50) + 1;
			System.out.print(array[i]+" ");
		}
		System.out.println(" ");
		radix(array);
		for(int i=0;i<25;i++){
			System.out.print(array[i]+" ");
		}
	}
}