package programmers;

public class Solution17681_비밀지도 {	//2018 KAKAO BLIND RECRUITMENT > [1차] 비밀지도
	public static void main(String[] args) {
		int n = 5;
		int[] arr1 = {9, 20, 28, 18, 11};
		int[] arr2 = {30, 1, 21, 17, 28};
		
		String[] answer = solution(n,arr1,arr2);
		for (int i = 0; i < answer.length; i++) {
			System.out.println(answer[i]+" ");
		}
	}
    public static String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];
        String[][] map = new String[n][n];
        
        for (int i = 0; i < n; i++) {
        	for (int j = 0; j < n; j++) {
        		map[i][n-j-1]=" ";
        		
        		if(arr1[i]%2==1) {
    				map[i][n-j-1] = "#";
    			}
    			arr1[i] /= 2;
        		
    			if(arr2[i]%2==1) {
    				map[i][n-j-1] = "#";
    			}
    			arr2[i] /= 2;
			}
		}
        
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map.length; j++) {
				sb.append(map[i][j]);
			}
			answer[i] = sb.toString();
			sb.delete(0, n);
		}
        
        return answer;
    }
}
