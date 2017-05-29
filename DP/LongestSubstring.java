public class LongestSubstring{

	static int answer(String s){
		int [][] array=new int [s.length()][s.length()];
		int maxlen=0;
		for(int i=0;i<s.length();i++)
			array[i][i]=(int)s.charAt(i)-(int)'0';
		for(int i=2;i<s.length();i++){
			for(int j=0;j<s.length()-i;j++){
				int k=j+i-1;
				int mid=(j+k)/2;
				array[j][k]=array[j][mid]+array[mid+1][k];
				if(array[j][mid]==array[mid+1][k] && i%2==0 && i>maxlen)
					maxlen=i;

			}
		}
		return maxlen;
	}

	public static void main(String args[]){

		System.out.println(answer("153803"));

	}
}