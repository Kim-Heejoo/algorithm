package programmers;
import java.util.*;

public class Solution17682 {	//2018 KAKAO BLIND RECRUITMENT > [1차] 다트 게임
	public static void main(String[] args) {
        System.out.println(solution("1D2S3T*"));
	}
    public static int solution(String dartResult) {
    	int answer = 0;
        int[] score = new int[3];
        
        int cnt = 0;
        
        for (int i = 0; i < dartResult.length(); i++) {
			if(dartResult.charAt(i)>='0' && dartResult.charAt(i)<='9') {
				if(dartResult.charAt(i+1)=='0') {
					score[cnt] = 10;
					i++;
				}else {
					score[cnt] = dartResult.charAt(i)-'0';
				}
				if(dartResult.charAt(i+1)=='S') {
					score[cnt] = (int) Math.pow(score[cnt], 1);
				}else if(dartResult.charAt(i+1)=='D') {
					score[cnt] = (int) Math.pow(score[cnt], 2);
				}else if(dartResult.charAt(i+1)=='T') {
					score[cnt] = (int) Math.pow(score[cnt], 3);
				}
				cnt++;
				i++;
			}else if(dartResult.charAt(i)=='*') {
				score[cnt-1] *= 2;
				if(cnt>1)
					score[cnt-2] *= 2;
			}else {
				score[cnt-1] *= -1;
			}
		}
        
        for (int i = 0; i < score.length; i++) {
			answer += score[i];
		}
        return answer;
    }
}
