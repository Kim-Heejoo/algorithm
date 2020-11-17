package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main17135_캐슬디펜스 {
	static int N,M,D,enemy;
	static int[][] arr;
	static boolean[] used;
	static int max;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());
		
		arr = new int[N][M];
		used = new boolean[M];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				if(arr[i][j]==1) enemy++;
			}
		}
		
		dfs(0,3);
		System.out.println(max);
	}
	
	static void dfs(int idx, int r) {
		if(r==0) {
			war();
		}
		
		for (int i = idx; i < M; i++) {
			used[i] = true;
			dfs(i+1,r-1);
			used[i] = false;
		}
	}
	
	static int[] dx = {0,-1,0};
	static int[] dy = {-1,0,1};
	static void war() {
		int[][] map = new int[N][M];
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				map[i][j] = arr[i][j];
			}
		}
		
		Queue<Point> que = new LinkedList<>();
		int live = enemy;
		int kill = 0;
		int[] archer = new int[3];
		int idx=0;
		
		for (int i = 0; i < M; i++) {
			if(used[i]) archer[idx++]=i;
		}
		
		boolean[][] visit = new boolean[N][M];
		
		int round = 0;
		while(live!=0) {
			for (int i = 0; i < 3; i++) {
				visit = new boolean[N][M];
				que.add(new Point(N,archer[i],0));
				
				while(!que.isEmpty()) {
					Point a = que.poll();
					if(a.d>D) {
						que.clear();
						break;
					}
					if(a.x!=N && (map[a.x][a.y]==1 || map[a.x][a.y]==2)) {
						map[a.x][a.y]=2;
						que.clear();
						break;
					}
					
					for (int d = 0; d < 3; d++) {
						int x = a.x+dx[d];
						int y = a.y+dy[d];
						if(x>=0 && x<N && y>=0 && y<M && !visit[x][y]) {
							que.add(new Point(x,y,a.d+1));
						}
					}
					
				}
			}
			
			for (int i = N-1; i >= round; i--) {
				for (int j = 0; j < M; j++) {
					if(i==N-1) {
						if(map[i][j]==1) live--;
						else if(map[i][j]==2) {
							kill++;
							live--;
						}
					}else {
						if(map[i][j]==2) { 
							map[i+1][j]=0;
							kill++;
							live--;
						}else map[i+1][j]=map[i][j];
					}
				}
			}
			
			for (int i = 0; i < M; i++) {
				map[round][i]=0;
			}
			round++;
		}
		max = Math.max(max, kill);
		
	}
	
	static class Point{
		int x,y,d;
		Point(int x, int y, int d) {
			this.x=x;
			this.y=y;
			this.d=d;
		}
	}
}