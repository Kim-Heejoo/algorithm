package programmers;

public class Solution67256 {	//2020 카카오 인턴십 > 키패드 누르기
	public static void main(String[] args) {
		int[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 0};
		String hand = "right";
		System.out.println(solution(numbers, hand));
	}
	public static String solution(int[] numbers, String hand) {
        StringBuilder answer = new StringBuilder();
        int left = 10;
        int right = 12;
        int[] dist = {0,1,2,1,2,3,2,3,4,3,4};
        
        for (int i = 0; i < numbers.length; i++) {
			if(numbers[i]==1 || numbers[i]==4 || numbers[i]==7) {
				left = numbers[i];
				answer.append("L");
			}else if(numbers[i]==3 || numbers[i]==6 || numbers[i]==9) {
				right = numbers[i];
				answer.append("R");
			}else {
				if(numbers[i]==0) numbers[i]=11;
				if(dist[Math.abs(left-numbers[i])] > dist[Math.abs(right-numbers[i])]) {
					right = numbers[i];
					answer.append("R");
				}else if(dist[Math.abs(left-numbers[i])] < dist[Math.abs(right-numbers[i])]) {
					left = numbers[i];
					answer.append("L");
				}else {
					if(hand.equals("right")) {
						right = numbers[i];
						answer.append("R");
					}else {
						left = numbers[i];
						answer.append("L");
					}
				}
			}
		}
        return answer.toString();
    }
}
