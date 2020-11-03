package baekjoon;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class Main16236_아기상어 {	// 아기 상어
	static int N;
	static int[][] map;
	static boolean[][] visit;
	static int baby, bx,by, time;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		map = new int[N][N];
		visit = new boolean[N][N];
		baby = 2;		
		time=0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				map[i][j] = sc.nextInt();
				if(map[i][j]==9) {
					bx=i;
					by=j;
				}
			}
		}
		
		int[] dx= {-1,0,0,1};
		int[] dy= {0,-1,1,0};
		int cnt=0;
		while(true) {
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					visit[i][j]=false;
				}
			}
			
			Queue<Move> que = new LinkedList<>();
			PriorityQueue<Move> pq = new PriorityQueue<>();
			
			que.add(new Move(bx,by,0));
			visit[bx][by]=true;		
			boolean flag = false;
			int t = 0;
			
			while(!que.isEmpty()) {
				Move m = que.poll();
				if(flag) {
					if(m.n>t) break;
				}
				for (int d = 0; d < dy.length; d++) {
					int cx = m.x+dx[d];
					int cy = m.y+dy[d];
					if(cx>=0 && cy>=0 && cx<N && cy<N && !visit[cx][cy]) {
						if(map[cx][cy]<baby && map[cx][cy]>0) {	
							flag=true;
							t=m.n;
							pq.add(new Move(cx,cy,m.n+1));
						}else if(map[cx][cy]==baby || map[cx][cy]==0) {	
							visit[cx][cy]=true;
							que.add(new Move(cx,cy,m.n+1));
						}
					}
				}
			}
			
			if(flag) {
				Move m = pq.poll();
				map[bx][by]=0;
				bx=m.x;
				by=m.y;
				cnt++;
				if(cnt==baby) {
					baby++;
					cnt=0;
				}
				map[bx][by]=9;
				time+=m.n;
				
			}else
				break;
		}	
		System.out.println(time);
	}
	
	static class Move implements Comparable<Move> {
		int x,y,n;
		Move(int x, int y,int n) {
			this.x=x;
			this.y=y;
			this.n=n;
		}
		@Override
		public int compareTo(Move o) {
			if(this.n==o.n) {
				if(this.x==o.x)
					return this.y-o.y;
				return this.x-o.x;
			}
			return this.n-o.n;
		}
	}
}