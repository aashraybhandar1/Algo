import java.util.*;
import java.lang.*;
import java.io.*;

class EqualPointString{
	public static void main (String[] args) {
	    Scanner sc=new Scanner(System.in);
		int t=sc.nextInt();
		int index=-1;
		sc.nextLine();
		for(int l=0;l<t;l++){
		    String str=sc.nextLine();
		    int [] array1=new int[str.length()+1];
		    int [] array2=new int[str.length()+1];
		    for(int i=1;i<=str.length();i++){
		    	if(str.charAt(i-1)=='(')
		    		array1[i]=array1[i-1]+1;
		    	else
		    	    array1[i]=array1[i-1];

		    }
		    for(int i=str.length()-1;i>=0;i--){
		    	if(str.charAt(i)==')')
		    		array2[i]=array2[i+1]+1;
		    	else
		    	    array2[i]=array2[i+1];

		    }
		    int flag=0;
		    //System.out.println(array2[1]);
		    for(int i=0;i<=str.length()+1;i++){
		    	if(array1[i]==array2[i] ){
		    		System.out.println(i);
		    		flag=1;
		    		break;
		    	}
		    }
		    if(flag==0){
		    	System.out.println("-1");
		    }
		    
		}
		//code
	}
}