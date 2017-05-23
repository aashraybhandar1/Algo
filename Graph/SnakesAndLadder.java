import java.util.*;
class graph{
	LinkedList [] array;
	int [] ladder;
	int [] snake;
	int v;
	int answer;

	graph(int v){
		this.v=v;
		array=new LinkedList[v];
		ladder=new int[v];
		snake=new int[v];
		for(int i=0;i<v;i++){
			array[i]=new LinkedList();
			ladder[i]=i;
			snake[i]=i;
		}
	}

	class hybrid{
		int node;
		int dist;
		hybrid(int node,int dist){
			this.node=node;
			this.dist=dist;
		}
	}

	void snakesAndLadder(int start){
		boolean [] visited=new boolean[v];
		visited[start]=true;
		LinkedList<hybrid> queue=new LinkedList<hybrid>();
		hybrid first=new hybrid(0,0);
		queue.add(first);
		int times=0;
		while(queue.size()!=0){
			hybrid temp=queue.poll();
			for(int i=1;i<=6;i++){
				if(ladder[temp.node+i]!=temp.node+i){
					hybrid ad=new hybrid(ladder[temp.node + i],temp.dist +1);
					queue.add(ad);
				}
				else if(snake[temp.node+i]!=temp.node+i){
					hybrid ad=new hybrid(snake[temp.node + i],temp.dist +1);
					queue.add(ad);
				}
				else{
					hybrid ad=new hybrid(temp.node + i,temp.dist +1);
					queue.add(ad);
				}
				if(temp.node + i==v-1){
					answer=temp.dist+1;
					return;
				}
			}
		}
	}


}

public class SnakesAndLadder{
	public static void main(String args []){

	graph g=new graph(30);
	g.ladder[2] = 21;
    g.ladder[4] = 7;
    g.ladder[10] = 25;
    g.ladder[19] = 28;
 
    // Snakes
    g.snake[26] = 0;
    g.snake[20] = 8;
    g.snake[16] = 3;
    g.snake[18] = 6;

    g.snakesAndLadder(0);
    System.out.println(g.answer);
	}
}