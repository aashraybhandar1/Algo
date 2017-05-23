import java.util.*;
import java.lang.*;
import java.io.*;

class SumOfPair {
	public static void main (String[] args) {
		//code
		Scanner sc=new Scanner(System.in);
		int testcases=sc.nextInt();
		for(int j=0;j<testcases;j++){
		    int [] array=new int[sc.nextInt()];
		    int [] array2=new int[sc.nextInt()];
		    int sum=sc.nextInt();
		    HashMap<Integer,Integer> h=new HashMap<Integer,Integer>();
		    for(int i=0;i<array.length;i++){
		        array[i]=sc.nextInt();
		       // System.out.print(array[i]+" ");
		        h.put(array[i],0);
		    }
		    //System.out.println("");
		    for(int i=0;i<array2.length;i++){
		        array2[i]=sc.nextInt();
		        //System.out.print((sum-array2[i])+" ");
		        if(h.get(sum-array2[i])!=null){
		            h.put(sum-array2[i],h.get(sum-array2[i]) +1);
		        }
		    }
		 // System.out.println("");
		  Iterator it = h.entrySet().iterator();
		  ArrayList<Integer> ans=new ArrayList<Integer>();
		 // System.out.println("Hello");
            while (it.hasNext()) {
                Map.Entry pair = (Map.Entry)it.next();
               // System.out.println(pair.getValue()+"  "+pair.getKey());
                if(pair.getValue()==null)
                	continue;
                if((int)pair.getValue()>0)
                    ans.add((int)pair.getKey());
                it.remove(); // avoids a ConcurrentModificationException
            }

            Collections.sort(ans);
            System.out.println(ans.size());
            for(int i=0;i<ans.size();i++){
                System.out.print(ans.get(i)+" "+(sum-ans.get(i))+", ");
            }
            System.out.println("");
		}
	}
}