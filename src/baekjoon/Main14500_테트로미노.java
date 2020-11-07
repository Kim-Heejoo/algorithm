package baekjoon;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main14500_테트로미노 {		// 테트로미노
	static int N,M;
	static int max=0;
	static int[][] map;
	static boolean[][] visit;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		visit = new boolean[N][M];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				visit[i][j] = true;
				dfs(i,j,1,map[i][j]);
				visit[i][j] = false;
				
				if(i-1>=0 && j-1>=0 && j+1<M)
					max=Math.max(max, map[i-1][j]+map[i][j]+map[i][j-1]+map[i][j+1]);
				if(i-1>=0 && i+1<N && j+1<M)
					max=Math.max(max, map[i-1][j]+map[i][j]+map[i+1][j]+map[i][j+1]);
				if(i+1<N && j-1>=0 && j+1<M)
					max=Math.max(max, map[i+1][j]+map[i][j]+map[i][j-1]+map[i][j+1]);
				if(i-1>=0 && i+1<N && j-1>=0)
					max=Math.max(max, map[i-1][j]+map[i][j]+map[i+1][j]+map[i][j-1]);
			}
		}
		System.out.println(max);
	}
	
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	static void dfs(int x, int y, int r, int sum) {
		if(r==4) {
			max = Math.max(max, sum);
			return;
		}
		
		for (int d = 0; d < 4; d++) {
			int cx = x+dx[d];
			int cy = y+dy[d];
			if(cx>=0 && cy>=0 && cx<N && cy<M && !visit[cx][cy]) {
				visit[cx][cy]=true;
				dfs(cx,cy,r+1,sum+map[cx][cy]);
				visit[cx][cy]=false;
			}
		}
	}
}