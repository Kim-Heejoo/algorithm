package programmers;

public class Solution42860_조이스틱 {	//탐욕법(Greedy) > 조이스틱
	public static void main(String[] args) {
		System.out.println(solution("JEROEN"));
	}
	public static int solution(String name) {
		int answer = 0;
		int min = name.length() - 1;
        for(int i = 0 ; i < name.length() ; i++) {
			int up = name.charAt(i) - 'A';
			int down = 'Z' - name.charAt(i) + 1;
			
			if (up < down) {
				answer += up;
			} else {
				answer += down;
			}

			if (name.charAt(i) != 'A') {
				int next = i + 1;
				while (next < name.length() && name.charAt(next) == 'A') {
					next++;
				}
				int move = i*2 + name.length() - next;
				min = Math.min(min, move);
			}
		}       
        
        return answer + min;
    }
}
