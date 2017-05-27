public class palindromeSubstring{
	public static void main(String args[]){
		String s="forgeeksskeegfor";
		boolean [][] array=new boolean [s.length()][s.length()];
		for(int i=0;i<s.length();i++)
			array[i][i]=true;
		int len=0;
		for(int k=0;k<s.length();k++){
			for(int i=0;i<s.length()-1-k;i++){
				int j=i+1+k;
				//System.out.println(" k is "+k);
				if(s.charAt(i)==s.charAt(j)){
					//System.out.println(i+" "+j);
					if(i+1>j-1){
						array[i][j]=true;
						if(j-i>len)
							len=j-i;
					}
					else{
						array[i][j]=array[i+1][j-1];
						if(array[i][j] && j-i>len)
							len=j-i;
					}
				}

			
			}
		}
		for(int i=0;i<s.length();i++){
			for(int j=0;j<s.length();j++){
				if(array[i][j])
					System.out.println("i is "+i+" j is "+j);
			}
			//System.out.println("");
		}
		System.out.println(len);
	}
}