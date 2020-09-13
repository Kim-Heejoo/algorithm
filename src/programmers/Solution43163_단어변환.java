package programmers;

public class Solution43163_단어변환 {	//깊이/너비 우선 탐색(DFS/BFS) > 단어 변환
	static boolean[] visited;
    public int solution(String begin, String target, String[] words) {
        int answer = 0;
        visited = new boolean[words.length];
        answer = dfs(begin, target, words, 0, words.length+1);
        if(answer>words.length) 
            return 0;
        return answer;
    }
    
    static int dfs(String begin, String target, String[] words, int step, int min) {
        for(int i = 0; i<words.length; i++) {   
            if( !visited[i] && compare(begin, words[i])) {
                if(words[i].equals(target)) {
                    return Math.min(min, step+1);
                }
                
                visited[i] = true;
                min = Math.min(dfs(words[i], target, words, step+1, min), min);
                visited[i]=false;
            }
        }
        return min;
    }
    
    static boolean compare(String begin, String word) {
        int cnt = 0;
        
        for(int i=0; i<begin.length(); i++) {
            if(begin.charAt(i) != word.charAt(i)) {
                cnt++;
                if( cnt > 1)
                    return false;
            }
        }
        
        return true;
    }
}
