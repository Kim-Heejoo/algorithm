package programmers;
import java.util.*;

public class Solution1829 {	//2017 카카오코드 예선 > 카카오프렌즈 컬러링북
	public static void main(String[] args) {
		int m = 6;
		int n = 4;
		int[][] picture = {{1,1,1,0},{1,2,2,0},{1,0,0,1},{0,0,0,1},{0,0,0,3},{0,0,0,3}};
        System.out.println(Arrays.toString(solution(m,n,picture)));
	}
    public static int[] solution(int m, int n, int[][] picture) {
        int numberOfArea = 0;
        int maxSizeOfOneArea = 0;

        Queue<Color> queue = new LinkedList<>();
        boolean[][] visited = new boolean[m][n];
        int[] dx = {-1,1,0,0};
        int[] dy = {0,0,-1,1};
        int cnt=0;
        
        for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if(picture[i][j]>0 && !visited[i][j]) {
					numberOfArea++;
					cnt = 1;
					visited[i][j] = true;
					
					queue.add(new Color(i,j));
					while(!queue.isEmpty()) {
						Color c = queue.poll();
						
						for (int d = 0; d < dy.length; d++) {
							int nx = c.x+dx[d];
							int ny = c.y+dy[d];
							
							if(nx>=0 && ny>=0 && nx<m && ny<n && !visited[nx][ny] && picture[nx][ny]==picture[i][j]) {
								visited[nx][ny] = true;
								cnt++;
								queue.add(new Color(nx,ny));
							}
						}
					}
					maxSizeOfOneArea = Math.max(maxSizeOfOneArea, cnt);
				}
			}
		}
        
        int[] answer = new int[2];
        answer[0] = numberOfArea;
        answer[1] = maxSizeOfOneArea;
        return answer;
    }
    static class Color {
    	int x,y;
    	Color (int x, int y) {
    		this.x = x;
    		this.y = y;
    	}
    }
}
