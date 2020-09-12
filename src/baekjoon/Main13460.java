package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main13460 {	// 구슬 탈출 2
	static char[][] map;
	static Queue<Bead> que;
	static int[][][][] visited = new int[10][10][10][10];
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	
	static class Bead {
		int rx, ry, bx, by, count;

		public Bead(int rx, int ry, int bx, int by, int count) {
			this.rx = rx;
			this.ry = ry;
			this.bx = bx;
			this.by = by;
			this.count = count;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] s = br.readLine().split(" ");
		int n = Integer.parseInt(s[0]);
		int m = Integer.parseInt(s[1]);
		
		map = new char[n][m];

		int rx = 0;
		int ry = 0;
		int bx = 0;
		int by = 0;
		
		for (int i = 0; i < n; i++) {
			String ls = br.readLine();
			map[i] = ls.toCharArray();
			for (int j = 0; j < m; j++) {
				if(map[i][j]=='R') {
					rx = i;
					ry = j;
				}else if(map[i][j]=='B') {
					bx = i;
					by = j;
				}
			}
		}
		
		que = new LinkedList<>();
		que.add(new Bead(rx, ry, bx, by, 0));
		visited[rx][ry][bx][by] = 1;
		
		int ans = -1;
		
		while(!que.isEmpty()) {
			Bead bead = que.poll();
			
			if(bead.count > 10)
				break;
			if(map[bead.rx][bead.ry] == 'O' && map[bead.bx][bead.by] != 'O') {
				ans = bead.count;
				break;
			}
			
			for (int d = 0; d < 4; d++) {
				int nrx = bead.rx;
				int nry = bead.ry;
				int nbx = bead.bx;
				int nby = bead.by;
				
				while(true) {
					if(map[nrx][nry] != '#' && map[nrx][nry] != 'O') {
						nrx += dx[d];
						nry += dy[d];
					}else {
						if(map[nrx][nry] == '#') {
							nrx -= dx[d];
							nry -= dy[d];
						}
						break;
					}
				}
				
				while(true) {
					if(map[nbx][nby] != '#' && map[nbx][nby] != 'O') {
						nbx += dx[d];
						nby += dy[d];
					}else {
						if(map[nbx][nby] == '#') {
							nbx -= dx[d];
							nby -= dy[d];
						}
						break;
					}
				}
				
				if(nrx == nbx && nry == nby) {
					if(map[nrx][nry] != 'O') {
						int red = Math.abs(nrx - bead.rx) + Math.abs(nry - bead.ry);
						int blue = Math.abs(nbx - bead.bx) + Math.abs(nby - bead.by);
						
						if(red > blue) {
							nrx -= dx[d];
							nry -= dy[d];
						}else {
							nbx -= dx[d];
							nby -= dy[d];
						}
					}
				}
				
				if(visited[nrx][nry][nbx][nby] == 0) {
					visited[nrx][nry][nbx][nby] = 1;
					que.add(new Bead(nrx, nry, nbx, nby, bead.count+1));
				}
			}
		}

		System.out.println(ans);
	}	
}
