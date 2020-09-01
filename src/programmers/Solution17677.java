package programmers;

import java.util.HashMap;

public class Solution17677 {	//2018 KAKAO BLIND RECRUITMENT > [1차] 뉴스 클러스터링
	public static void main(String[] args) {
		System.out.println(solution("FRANCE", "french"));
		System.out.println(solution("handshake", "shake hands"));
		System.out.println(solution("aa1+aa2", "AAAA12"));
		System.out.println(solution("E=M*C^2", "e=m*c^2"));
	}
    public static int solution(String str1, String str2) {
        str1 = str1.toUpperCase();
        str2 = str2.toUpperCase();
        
        int intersection = 0;
        int sum = 0;
        
        HashMap<String, Integer> hash = new HashMap<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str1.length(); i++) {
			if(str1.charAt(i)>='A' && str1.charAt(i)<='Z') {
				sb.append(str1.charAt(i));
				if(sb.length()==2) {
					hash.put(sb.toString(), hash.getOrDefault(sb.toString(), 0) + 1);
					sum++;
					sb.delete(0, 1);
				}
			}else {
				sb.delete(0, sb.length());
			}
		}
        sb.delete(0, sb.length());        
        
        for (int i = 0; i < str2.length(); i++) {
			if(str2.charAt(i)>='A' && str2.charAt(i)<='Z') {
				sb.append(str2.charAt(i));
				if(sb.length()==2) {
					if(hash.containsKey(sb.toString())) {
						intersection++;
						if(hash.get(sb.toString())-1==0) {
							hash.remove(sb.toString());
						}else {
							hash.put(sb.toString(), hash.get(sb.toString()) - 1);							
						}
					}else {
						sum++;
					}
					sb.delete(0, 1);
				}
			}else {
				sb.delete(0, sb.length());
			}
		}
        
        if(intersection==0 && sum==0)
        	return 65536;
        return (int)((double)intersection/sum * 65536);
    }
}
