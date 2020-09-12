package programmers;
import java.util.*;

public class Solution42862 {	//탐욕법(Greedy) > 체육복
	public static void main(String[] args) {
		int n = 5;
		int[] lost = {2,4};
		int[] reserve = {3};
		System.out.println(solution(n,lost,reserve));
	}
	public static int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;
        int[] cnt = new int[n];
        
        for (int i = 0; i < lost.length; i++) {
			cnt[lost[i]-1]--;
		}
        for (int i = 0; i < reserve.length; i++) {
			cnt[reserve[i]-1]++;
		}
        
        for (int i = 0; i < cnt.length; i++) {
			if(cnt[i]==0) {
				answer++;
			}else if(cnt[i]==-1){
				if(i<cnt.length-1 && cnt[i+1]==1) {
					cnt[i]++;
					cnt[i+1]--;
					answer++;
				}
			}else {
				answer++;
				if(i<cnt.length-1 && cnt[i+1]==-1) {
					cnt[i]--;
					cnt[i+1]++;
				}
			}
		}
        
        return answer;
    }
}
