package programmers;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main17472_´Ù¸®¸¸µé±â2 {	// ´Ù¸® ¸¸µé±â 2
	static int R,C;
	static int[][] map;
	static int ans=-1;
	static int randCnt;
	static boolean[][] visit;
	static int[] dx= {-1,1,0,0};
	static int[] dy= {0,0,-1,1};
	static int[] disjoint;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		R = sc.nextInt();
		C = sc.nextInt();
		map = new int[R][C];
		visit = new boolean[R][C];
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				map[i][j]=sc.nextInt();
			}
		}
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if(map[i][j]!=0 && !visit[i][j]) {
					randCnt++;
					visit[i][j]=true;
					map[i][j]=randCnt;
					dfs(i,j,randCnt);
				}
			}
		}
		PriorityQueue<Edge> pq = new PriorityQueue<>(new EdgeComparator());
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if(map[i][j]!=0) {
					int land=map[i][j];
					int dist,tmpi,tmpj;
					
					tmpi=i-1; dist=0;	//up
					while(tmpi>=0 && map[tmpi][j]==0) {
						dist++;
						tmpi--;
					}
					if(tmpi>=0 && map[tmpi][j]>0 && dist>1 && !pq.contains(new Edge(tmpi,j,dist))) {
						pq.add(new Edge(land,map[tmpi][j],dist));
					}
					
					tmpi=i+1;dist=0;	//down
					while(tmpi<R && map[tmpi][j]==0) {
						dist++;
						tmpi++;
					}
					if(tmpi<R && map[tmpi][j]>0 && dist>1 && !pq.contains(new Edge(tmpi,j,dist))) {
						pq.add(new Edge(land,map[tmpi][j],dist));
					}
					
					tmpj=j-1;dist=0;	//left
					while(tmpj>=0 && map[i][tmpj]==0) {
						dist++;
						tmpj--;
					}
					if(tmpj>=0 && map[i][tmpj]>0 && dist>1 && !pq.contains(new Edge(i,tmpj,dist))) {
						pq.add(new Edge(land,map[i][tmpj],dist));
					}
					
					tmpj=j+1;dist=0;	//right
					while(tmpj<C && map[i][tmpj]==0) {
						dist++;
						tmpj++;
					}
					if(tmpj<C && map[i][tmpj]>0 && dist>1 && !pq.contains(new Edge(i,tmpj,dist))) {
						pq.add(new Edge(land,map[i][tmpj],dist));
					}
					
				}
			}
		}
		disjoint = new int[randCnt+1];
		for(int i=1; i<=randCnt; i++)
			disjoint[i]=i;
		
		ArrayList<Edge> mst = new ArrayList<>();
		while(!pq.isEmpty() && mst.size()<randCnt-1) {
			Edge edge = pq.poll();
			
			if(find(edge.i) != find(edge.j)) {
				union(edge.i, edge.j);
				mst.add(edge);
			}
		}
		if(mst.size()==randCnt-1) {
			ans=0;
			for(Edge e:mst)
				ans+=e.d;
		}
		
		System.out.println(ans);
	}
	static void union(int n1, int n2) {
		int p1 = find(n1);
		int p2 = find(n2);
		if(p1 != p2)
			disjoint[p1]=p2;
	}
	
	static int find(int n) {
		if(disjoint[n]==n) return n;
		disjoint[n] = find(disjoint[n]);
		return disjoint[n];
	}
	static void dfs(int x, int y, int cnt) {
		for (int i = 0; i < 4; i++) {
			int cx = x+dx[i];
			int cy = y+dy[i];
			if(cx>=0 && cx<R && cy>=0 && cy<C && map[cx][cy]==1 && !visit[cx][cy]) {
				visit[cx][cy]=true;
				map[cx][cy]=cnt;
				dfs(cx,cy,cnt);
			}
		}
	}
	
	static class Edge {
		int i,j,d;
		Edge(int i, int j, int d) {
			this.i=i;
			this.j=j;
			this.d=d;
		}
	}
	static class EdgeComparator implements Comparator<Edge> {
		@Override
		public int compare(Edge o1, Edge o2) {
			return o1.d - o2.d;
		}
	}
}
