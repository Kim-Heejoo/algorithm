package programmers;
import java.util.*;

public class Solution42576_2 {	//해시 완주하지 못한 선수
    public String solution(String[] participant, String[] completion) {
    	Arrays.sort(participant);
        Arrays.sort(completion);
        String answer = participant[participant.length-1];
        
        for(int i=0; i<completion.length; i++) {
            if(!participant[i].equals(completion[i])) {
                answer = participant[i];
                break;
            }
        }
        return answer;
    }
}
