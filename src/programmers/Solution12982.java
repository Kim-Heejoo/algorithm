package programmers;
import java.util.*;

public class Solution12982 {	//Summer/Winter Coding(~2018) > ¿¹»ê
	public static void main(String[] args) {
		int[] d = {1,3,2,5,4};
		int budget = 9;
        System.out.println(solution(d, budget));
	}
    public static int solution(int[] d, int budget) {
        int answer = 0;
        Arrays.sort(d);
        for (int i = 0; i < d.length; i++) {
			if(d[i]>budget)
				break;
			budget -= d[i];
			answer++;
		}
        return answer;
    }
}
