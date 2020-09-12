package programmers;
import java.util.*;

public class Solution42587 {	//스택/큐 > 프린터
	public static void main(String[] args) {
		int[] priorities = {1, 1, 9, 1, 1, 1};
        System.out.println(solution(priorities, 0));
	}
    public static int solution(int[] priorities, int location) {
        int answer = 0;
        Queue<Print> queue = new LinkedList<>();
        
        for (int i = 0; i < priorities.length; i++) {
			queue.add(new Print(i, priorities[i]));
		}
        
        while(!queue.isEmpty()) {
        	Print now = queue.poll();
        	boolean check = false;
        	
        	for(Print a : queue) {
        		if(now.priority < a.priority) {
        			check = true;
        			break;
        		}
        	}
        	
        	if(check) {
        		queue.add(now);
        	}else {
        		answer++;
        		if(now.idx == location)
        			break;
        	}
        }
        
        return answer;
    }
    
    static public class Print {
    	int idx, priority;
    	Print(int idx, int priority) {
    		this.idx = idx;
    		this.priority = priority;
    	}
    }
}
