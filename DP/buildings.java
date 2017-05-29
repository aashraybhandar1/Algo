public class buildings{


	static class temp{
		int b,e;
	}

	static int answer(int n){
		temp [] array=new temp [n];
		for(int i=0;i<n;i++){
			array[i]=new temp();
		}
		array[0].b=1;
		array[0].e=1;
		for(int i=1;i<n;i++){
			array[i].b=array[i-1].e;
			array[i].e=(array[i-1].e+array[i-1].b);
		}
		return (array[n-1].b+array[n-1].e)*(array[n-1].b+array[n-1].e);
	}


	public static void main(String args[]){
		System.out.println(answer(4));

	}
}