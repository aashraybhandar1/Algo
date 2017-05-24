import java.util.*;

public class longestPalindrome{

	static int palindrome(String a){
		int [][] array=new int [a.length()][a.length()];
		for(int i=0;i<a.length();i++)
			array[i][i]=1;
		for (int cl=1; cl<a.length(); cl++)
        {
            for (int i=0; i<a.length()-cl; i++)
            {
                int j = i+cl;
                if (a.charAt(i) == a.charAt(j) && cl == 1)
                   array[i][j] = 2;
                else if (a.charAt(i) == a.charAt(j))
                   array[i][j] = array[i+1][j-1] + 2;
                else
                   array[i][j] = Math.max(array[i][j-1], array[i+1][j]);
            }
        }
         
		return array[0][a.length()-1];
	}

	public static void main(String args []){
		System.out.println(palindrome("GEEKSFORGEEKS"));

	}
}