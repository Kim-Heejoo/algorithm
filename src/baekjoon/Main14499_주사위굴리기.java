package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main14499_주사위굴리기 {	// 주사위 굴리기
	static int[][] map;
	static int N,M;
	static int x,y;
	static int[] dice1;
	static int[] dice2;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] s = br.readLine().split(" ");
		N = Integer.parseInt(s[0]);
		M = Integer.parseInt(s[1]);
		x = Integer.parseInt(s[2]);
		y = Integer.parseInt(s[3]);
		
		map = new int[N][M];
		for (int i = 0; i < N; i++) {
			String[] ss = br.readLine().split(" ");
			for (int j = 0; j < ss.length; j++) {
				map[i][j] = Integer.parseInt(ss[j]);
			}
		}
		
		String[] cmd = br.readLine().split(" ");
		dice1 = new int[4];
		dice2 = new int[4];
		
		for (int i = 0; i < cmd.length; i++) {
			move(Integer.parseInt(cmd[i])-1);
		}
	}
	
	static int[] dx = {0,0,-1,1};
	static int[] dy = {1,-1,0,0};
	static void move(int d) {
		if(x+dx[d]>=N || x+dx[d]<0 || y+dy[d]>=M || y+dy[d]<0) {
			return;
		}
		
		x += dx[d];
		y += dy[d];
		if(d==0) {
			int tmp = dice2[0];
			dice2[0]=dice2[1];
			dice2[1]=dice2[2];
			dice2[2]=dice2[3];
			dice2[3]=tmp;
			dice1[0]=dice2[0];
			dice1[2]=dice2[2];
		}else if(d==1) {
			int tmp = dice2[3];
			dice2[3]=dice2[2];
			dice2[2]=dice2[1];
			dice2[1]=dice2[0];
			dice2[0]=tmp;
			dice1[0]=dice2[0];
			dice1[2]=dice2[2];
		}else if(d==2) {
			int tmp = dice1[3];
			dice1[3]=dice1[2];
			dice1[2]=dice1[1];
			dice1[1]=dice1[0];
			dice1[0]=tmp;
			dice2[0]=dice1[0];
			dice2[2]=dice1[2];
		}else {
			int tmp = dice1[0];
			dice1[0]=dice1[1];
			dice1[1]=dice1[2];
			dice1[2]=dice1[3];
			dice1[3]=tmp;
			dice2[0]=dice1[0];
			dice2[2]=dice1[2];
		}
		
		if(map[x][y]==0) {
			map[x][y]=dice1[2];
		}else {
			dice1[2]=map[x][y];
			dice2[2]=map[x][y];
			map[x][y]=0;
		}
		
		System.out.println(dice1[0]);
	}
}