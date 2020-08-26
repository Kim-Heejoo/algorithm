package programmers;

public class Solution64061 {	//2019 카카오 개발자 겨울 인턴십 > 크레인 인형뽑기 게임
	public static void main(String[] args) {
		int[][] board = {{0,0,0,0,0},{0,0,1,0,3},{0,2,5,0,1},{4,2,4,4,2},{3,5,1,3,1}};
		int[] moves = {1,5,3,5,1,2,1,4};
        System.out.println(solution(board,moves));
	}
	public  static int solution(int[][] board, int[] moves) {
        int answer = 0;
        int[] basket = new int[moves.length];
        int idx = 0;
        for (int m = 0; m < moves.length; m++) {
			for (int i = 0; i < board.length; i++) {
				if(board[i][moves[m]-1]!=0) {
					if(idx==0) {
						basket[idx] = board[i][moves[m]-1];
						idx++;
					}else if(basket[idx-1] == board[i][moves[m]-1]) {
						basket[idx-1] = 0;
						idx--;
						answer += 2;
					}else {
						basket[idx] = board[i][moves[m]-1];
						idx++;
					}
					board[i][moves[m]-1] = 0;
					break;
				}
			}
		}
        return answer;
    }
}
