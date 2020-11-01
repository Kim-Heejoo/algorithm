package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main17281_야구 {	// ⚾
	static boolean[] visit;
	static int[] hit;
	static int[][] record;
	static int N;
	static int ans;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		record = new int[N][9];
		visit = new boolean[9];
		hit = new int[9];
		StringTokenizer st;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 9; j++) {
				record[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		dfs(1);
		System.out.println(ans);
	}
	static void dfs(int r) {
		if (r == 9) {
			play();
			return;
		}
		for (int i = 1; i < 9; i++) {
			if (!visit[i]) {
				visit[i] = true;
				hit[r]=i;
				dfs(r + 1);
				visit[i] = false;
			}
		}
	}
	static void play() {
		int sum=0;
		int start = 6;
		for (int game = 0; game < N; game++) {
			int[] base = new int[3];
			int out=0;
			while(out<3) {
				int now = record[game][hit[start]];
				if(now==1) {
					if(base[0]==1) sum++;
					base[0]=base[1];
					base[1]=base[2];
					base[2]=1;
				}else if(now==2) {
					if(base[0]==1) sum++;
					if(base[1]==1) sum++;
					base[0]=base[2];
					base[1]=1;
					base[2]=0;
				}else if(now==3) {
					for (int i = 0; i < 3; i++) {
						if(base[i]==1) sum++;
						base[i]=0;
					}
					base[0]=1;
				}else if(now==4) {
					for (int i = 0; i < 3; i++) {
						if(base[i]==1) sum++;
						base[i]=0;
					}
					sum++;
				}else if(now==0) {
					out++;
				}
				start = (start+1)%9;
			}
		}
		ans = Math.max(ans, sum);
	}
}