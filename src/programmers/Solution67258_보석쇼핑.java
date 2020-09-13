package programmers;
import java.util.*;

public class Solution67258_보석쇼핑 {	//2020 카카오 인턴십 > 보석 쇼핑
	public static void main(String[] args) {
		String[] gems = {"DIA", "RUBY", "RUBY", "DIA", "DIA", "EMERALD", "SAPPHIRE", "DIA"};
        System.out.println(Arrays.toString(solution(gems)));
	}
	
    public static int[] solution(String[] gems) {
    	Queue<String> queue = new LinkedList<String>();
        HashSet<String> hs = new HashSet<String>(); 
        HashMap<String, Integer> hm = new HashMap<String, Integer>();
        int start = 0;
        int startPoint = 0;
        int length = 100000;
    	
        for(String gem : gems) {
        	hs.add(gem);
        }
        
        for(int i = 0; i < gems.length; i++) {
        	hm.put(gems[i], hm.getOrDefault(gems[i],0)+1);
        	queue.add(gems[i]);
        	
        	while(true) {
        		String check = queue.peek();
        		if(hm.get(check) > 1) {
        			hm.put(check, hm.get(check)-1);
        			queue.poll();
        			startPoint++;
        		}
        		else {
        			break;
        		}
        	}
        	if(hm.size()==hs.size() && queue.size() < length) {
        		start = startPoint;
        		length = queue.size();
        	}
        }
        
        int[] answer = {start+1, start+length};  
        return answer;  
    }
}
