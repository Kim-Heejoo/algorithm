package programmers;
import java.util.*;

public class Solution42576_완주하지못한선수 {	//해시 > 완주하지 못한 선수
	public static void main(String[] args) {
		String[] p = {"mislav", "stanko", "mislav", "ana"};
        String[] c = {"stanko", "ana", "mislav"};
        System.out.println(solution(p,c));
	}
    public static String solution(String[] participant, String[] completion) {
    	String answer = "";
        HashMap<String, Integer> hash = new HashMap<>();
        for (String player : participant) hash.put(player, hash.getOrDefault(player, 0) + 1);
        for (String player : completion) hash.put(player, hash.get(player) - 1);
        
        for (String key : hash.keySet()) {
            if (hash.get(key) != 0){
                answer = key;
                break;
            }
        }
        return answer;
    }
}
