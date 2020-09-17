package programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution42586_기능개발 {	//스택/큐 > 기능개발
	public static void main(String[] args) {
		int[] progresses = {93, 30, 55};
		int[] speeds = {1, 30, 5};
		System.out.println(Arrays.toString(solution(progresses, speeds)));
	}
	public static int[] solution(int[] progresses, int[] speeds) {
		List<Integer> list = new ArrayList<>();
		
		int day = 0;
		int cnt = 0;
		for (int i = 0; i < progresses.length; i++) {
			int temp = 0;
			while(progresses[i]<100) {
				temp++;
				progresses[i] += speeds[i];
			}
			
			if (temp <= day) {
				cnt++;
			} else {
				list.add(cnt);
				day = temp;
				cnt = 1;
			}
		}
		list.add(cnt);
		
        int[] answer = new int[list.size()-1];
        for (int i = 1; i < list.size(); i++) {
			answer[i-1] = list.get(i);
		}
        return answer;
    }
}
