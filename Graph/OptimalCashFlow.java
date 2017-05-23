class Graph{
	int v;
	int [] [] array={{0,1000,2000},{0,0,5000},{0,0,0}};  
	Graph(int v){
		this.v=v;
	}
	void minCashFlow(){
		int [] amount=new int[v];
		for(int i=0;i<v;i++){
			for(int j=0;j<v;j++){
				amount[i]+=array[i][j]-array[j][i];
			}
		}
		reduce(amount);
	}
	void reduce(int [] amount){
		int max_index=0;
		int min_index=0;
		for(int i=0;i<v;i++){
			if(amount[i]>amount[max_index])
				max_index=i;
			if(amount[i]<amount[min_index])
				min_index=i;
		}
		if(amount[max_index]==0 && amount[min_index]==0)
			return;
		if(amount[max_index]>-amount[min_index]){
			System.out.println(max_index+" has to pay "+min_index+" "+amount[min_index]);
			amount[max_index]-=amount[min_index];
			amount[min_index]=0;
			
		}
		else{
			System.out.println(max_index+" has to pay "+min_index+" "+amount[max_index]);
			amount[min_index]+=amount[max_index];
			amount[max_index]=0;
		}
		reduce(amount);



	}
}

public class OptimalCashFlow{
	public static void main(String args[]){
		Graph g=new Graph(3);
		
		g.minCashFlow();
	}
}