package programmers;
import java.util.*;

public class Solution67257 {	//2020 카카오 인턴십 > 수식 최대화
	public static void main(String[] args) {
        System.out.println(solution("100-200*300-500+20"));
	}
	
	static int[] comb = new int[3];
	static boolean[] visited = new boolean[3];
	static char[] sign = {'+','-','*'};
	static long answer = 0;
	static ArrayList<Long> operand;
	static ArrayList<Character> operator;
	
    public static long solution(String expression) {
        operand = new ArrayList<>();
        operator = new ArrayList<>();
        
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < expression.length(); i++) {
			if(expression.charAt(i)>='0' && expression.charAt(i)<='9') {
				sb.append(expression.charAt(i));
			}else {
				operand.add(Long.parseLong(sb.toString()));
				sb = new StringBuilder();
				operator.add(expression.charAt(i));
			}
		}
        operand.add(Long.parseLong(sb.toString()));
        dfs(0);
        return answer;
    }
    static public void dfs(int n) {
    	if(n==3) {
    		LinkedList<Long> od = new LinkedList<>();
    		LinkedList<Character> op = new LinkedList<>();
    		
    		for(Long o : operand)
    			od.add(o);
    		for(Character o : operator)
    			op.add(o);
    		
    		for (int s = 0; s < 3; s++) {
				for (int i = 0; i < op.size(); i++) {
					if(op.get(i)==sign[comb[s]]) {
						if(op.get(i)=='+') {
							od.set(i, od.get(i)+od.get(i+1));
							od.remove(i+1);
						}else if(op.get(i)=='-') {
							od.set(i, od.get(i)-od.get(i+1));
							od.remove(i+1);
						}else {
							od.set(i, od.get(i)*od.get(i+1));
							od.remove(i+1);
						}
						op.remove(i);
						i--;
					}
				}
			}
    		
    		answer = Math.max(answer, Math.abs(od.peek()));
    		
    		return;
    	}
    	
    	for (int i = 0; i < 3; i++) {
    		if(!visited[i]) {
    			visited[i] = true;
    			comb[n] = i;
    			dfs(n+1);
    			visited[i] = false;			   			
    		}
		}
    }
}
