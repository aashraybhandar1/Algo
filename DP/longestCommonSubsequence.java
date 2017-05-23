import java.util.*;

public class longestCommonSubsequence{

	static int find_answer(String a,String b){
		int [][] array=new int [a.length()+1][b.length()+1];
		for(int j=1;j<=b.length();j++){
			for(int i=1;i<=a.length();i++){
				if(a.charAt(i-1)==b.charAt(j-1))
					array[i][j]=array[i-1][j-1]+1;
				else
					array[i][j]=Math.max(array[i-1][j],array[i][j-1]);
			}
		}
		return array[a.length()][b.length()];
	}

	public static void main(String args[]){
		String a="AGGTAB";
		String b="GXTXAYB";
		System.out.println(find_answer(a,b));

	}
}