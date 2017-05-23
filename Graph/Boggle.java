class Graph{
	int v;
	String [] [] array={{"G","I","Z"},
                       {"U","E","K"},
                       {"Q","S","E"}};
	String [] dict= {"GEEKS", "FOR", "QUIZ", "GO","UEGIGZKSESUGQ"};
	boolean [][]visited=new boolean[3][3]; 
	Graph(int v){
		this.v=v;
	}
	
	void graphTrav(String str,int i,int j){
		visited[i][j]=true;
		for(int l=i-1;l<=i+1;l++){
			for(int k=j-1;k<=j+1;k++){
				if(l>=v || k>=v || l<0 || k<0)
					continue;
				if(l==i && k==j)
					continue;
				if(visited[l][k]==false){
					str+=array[l][k];
					System.out.println(str);
					test(str);
					//visited[l][k]=true;
					graphTrav(str,l,k);
				}
			}
		}
		str=str.substring(0,str.length()-1);
		visited[i][j]=false;
	}
	void test(String str){
		for(int i=0;i<dict.length;i++){
			//System.out.println(dict[i]);
			if(str==dict[i]){
				System.out.println("This is there "+dict[i]);
			}
		}
	}
}

public class Boggle{
	public static void main(String args[]){
		Graph g=new Graph(3);
		for(int i=0;i<3;i++){
			for(int j=0;j<3;j++){
				String str="";
				boolean [][] visited=new boolean[3][3];
				g.graphTrav(str,i,j);
			}
		}
	}
}