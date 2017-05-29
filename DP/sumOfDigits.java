public class sumOfDigits{

	static int ans(int n){
		int [] array=new int[n+1];
		for(int i=1;i<10 && i<n+1;i++){
			array[i]=array[i-1]+i;
		}
		for(int i=10;i<=n;i++){
			String s=""+i;
			for(int j=0;j<s.length();j++){
				if(s.charAt(j)!='0'){
					array[i]+=array[(int)s.charAt(j)-(int)'0']-array[(int)s.charAt(j)-(int)'0' -1 ];
				}
			}
			array[i]+=array[i-1];
		}
		for(int i=0;i<=n;i++){
			System.out.print(array[i]+" ");
		}
		System.out.println("");
		return array[n];
	}

	public static void main(String args[]){
		System.out.println(ans(328));

	}
}