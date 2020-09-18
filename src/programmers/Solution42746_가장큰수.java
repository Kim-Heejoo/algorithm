package programmers;
import java.util.*;

public class Solution42746_가장큰수 {	//정렬 > 가장 큰 수
	public static void main(String[] args) {
		int[] numbers = {6, 10, 2};
        System.out.println(solution(numbers));
	}
    public static String solution(int[] numbers) {
    	String[] str = new String[numbers.length];
    	for (int i = 0; i < str.length; i++) {
			str[i] = String.valueOf(numbers[i]);
		}
    	
    	Arrays.sort(str, new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				return (o2+o1).compareTo(o1+o2);
			}
		});
    	
        if(str[0].equals("0")) return "0";
        
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length; i++) {
			sb.append(str[i]);
		}
        
        return sb.toString();
    }
}
