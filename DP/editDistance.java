import java.util.*;
public class editDistance{

	static int findValue(String a,String b){
		int [][] dp=new int[a.length()+1][b.length()+1];
		for(int j=0;j<=b.length();j++){
			for(int i=0;i<=a.length();i++){

				if(j==0){
					dp[i][j]=i;
					continue;
					
				}

				if(i==0){
					dp[i][j]=j;
					continue;
				}


				if(a.charAt(i-1)==b.charAt(j-1))
					dp[i][j]=dp[i-1][j-1];
				else
					dp[i][j]=1+Math.min(Math.min(dp[i-1][j],dp[i][j-1]),dp[i-1][j-1]);
			}
		}
		return dp[a.length()][b.length()];
	}

	public static void main(String args[]){
		String a="sunday";
		String b="saturday";
		System.out.println(findValue(a,b));

	}
}