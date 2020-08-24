package programmers;

public class Solution43165 {	//±íÀÌ/³Êºñ ¿ì¼± Å½»ö(DFS/BFS) Å¸°Ù ³Ñ¹ö
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
