//Application of bfs dfs Stepping numbers
import java.util.*;
public class SteppingNumbers{

	static int findSteppingNumbers(int n,int m,int start){
	    int count=0;
		LinkedList<Integer> queue=new LinkedList<Integer>();
		queue.add(start);
		while(!queue.isEmpty()){
			int temp=queue.poll();
			if(temp>=n && temp<=m)
				count++;
			if(temp>=m)
				continue;
			

			int lastnum=temp%10;
			int firstNum=temp*10+(lastnum-1);
			int secondNum=temp*10+(lastnum+1);
			if(lastnum==0)
				queue.add(secondNum);
			else if(lastnum==9)
				queue.add(firstNum);
			else{
				queue.add(firstNum);
				queue.add(secondNum);
			}
		}
		return count;
	}


	public static void main(String args []){
		Scanner sc=new Scanner(System.in);
		int t=sc.nextInt();
		for(int j=0;j<t;j++){
		    if(j!=0)
		        System.out.println("");
		    int count=0;
		    int n=sc.nextInt();
		    int m=sc.nextInt();
		    for(int i=1;i<=9;i++){
			    count+=findSteppingNumbers(n,m,i);
		    }
		    if(0>=n && 0<=m)
		        count++;
		    System.out.print(count);
		}
		
	}
}