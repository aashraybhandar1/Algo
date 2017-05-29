public class smallestSubsequence{

	static String ans(String s1,String s2){
		String [][] array=new String[s1.length()+1][s2.length()+1];
		for(int i=1;i<=s2.length();i++ ){
			array[0][i]=s2.substring(0,i);
		}
		for(int i=1;i<=s1.length();i++){
			array[i][0]=s1.substring(0,i);
		}
		for(int i=1;i<=s1.length();i++){
			for(int j=1;j<=s2.length();j++){
				if(s1.charAt(i-1)==s2.charAt(j-1)){
					array[i][j]=array[i-1][j-1]+""+s1.substring(i-1,i);
				}
				else{
					if(array[i-1][j].length()<array[i][j-1].length()){
						array[i][j]=array[i-1][j]+""+s1.substring(i-1,i);
					}
					else{
						array[i][j]=array[i][j-1]+""+s2.substring(j-1,j);
					}
				}
			}
		}
		return array[s1.length()][s2.length()];
	}

	public static void main(String args[]){
		System.out.println(ans("AGGTAB","GXTXAYB"));

	}
}