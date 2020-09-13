package programmers;

public class Solution43165_타겟넘버 {	//깊이/너비 우선 탐색(DFS/BFS) > 타겟 넘버
	static int answer;
    public int solution(int[] numbers, int target) {
        answer = 0;
        dfs(numbers, target, 0, 0);
        return answer;
    }
    static void dfs(int[] numbers, int target, int sum, int count) {
        if(count==numbers.length) {
            if(sum==target)
                answer++;
            return;
        }
        
        dfs(numbers, target, sum+numbers[count], count+1);
        dfs(numbers, target, sum-numbers[count], count+1);
    }
}
