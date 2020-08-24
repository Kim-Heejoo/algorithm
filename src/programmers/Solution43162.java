package programmers;

public class Solution43162 {	//깊이/너비 우선 탐색(DFS/BFS) 네트워크
	static boolean[] visited;
    public int solution(int n, int[][] computers) {
        int answer = 0;
        visited = new boolean[n];
        
        for(int i=0; i<n; i++) {
            if(!visited[i]) {
                visited[i] = true;
                dfs(n, computers, i);
                answer++;
            }
        }
        
        return answer;
    }
    static void dfs(int n, int[][] computers, int i) {
        for(int j=0; j<n; j++) {
            if(!visited[j] && computers[i][j]==1) {
                visited[j] = true;
                dfs(n, computers, j);
            }
        }
    }
}
