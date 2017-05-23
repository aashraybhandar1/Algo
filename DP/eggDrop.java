import java.util.*;

public class eggDrop{

	static int noOfTries(int num,int floors){
		int [][] array=new int [floors+1][num+1];
		for(int i=0;i<=num;i++){
			array[0][i]=0;
			array[1][i]=1;
		}
		for(int i=1;i<=floors;i++){
			array[i][1]=i;
		}



		for(int j=2;j<=num;j++){
			for(int i=2;i<=floors;i++){

				array[i][j]=1000000;
				for(int temp=1;temp<=i;temp++){
					int bleh=1+Math.max(array[temp-1][j-1],array[i-temp][j]);
					if(bleh<array[i][j])
						array[i][j]=bleh;
				}



			}
		}



		return array[floors][num];
	}


	public static void main(String args []){
		System.out.println(noOfTries(2,36));

	}
}