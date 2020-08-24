package programmers;

public class Solution43165 {	//����/�ʺ� �켱 Ž��(DFS/BFS) Ÿ�� �ѹ�
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
