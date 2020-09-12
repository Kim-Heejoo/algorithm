package programmers;
import java.util.*;

public class Solution42840 {	//완전탐색 > 모의고사
	public static void main(String[] args) {
		int[] answers = {1,2,3,4,5};
		int[] student = solution(answers);
		for (int i = 0; i < student.length; i++) {
			System.out.print(student[i]+" ");
		}
	}
	public static int[] solution(int[] answers) {
        int[] answer ;
        int[] s1 = {1,2,3,4,5};
        int[] s2 = {2,1,2,3,2,4,2,5};
        int[] s3 = {3,3,1,1,2,2,4,4,5,5};
        int[] score = new int[3];
        
        for(int i=0; i<answers.length; i++) {
            if(s1[i%s1.length] == answers[i])
                score[0]++;
            if(s2[i%s2.length] == answers[i])
                score[1]++;
            if(s3[i%s3.length] == answers[i])
                score[2]++;
        }
        
        int max = Math.max(score[0], Math.max(score[1], score[2]));
        ArrayList<Integer> list = new ArrayList<>();
        
        for (int i = 0; i < score.length; i++) {
			if(score[i]==max)
				list.add(i+1);
		}

        answer = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
			answer[i] = list.get(i);
		}
        
        return answer;
    }
}
