package swea;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
  
public class Solution1247_최적경로 { // [S/W 문제해결 응용] 3일차 - 최적 경로
    static int min;
    static int N;
    static int[][] arr;
    static boolean[] check;
    static int hx,hy;
    
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        
        for (int t = 1; t <= T; t++) {
            N = Integer.parseInt(br.readLine());
            String[] s = br.readLine().split(" ");
            arr = new int[N][2];
            check = new boolean[N];
            
            int ox = Integer.parseInt(s[0]);
            int oy = Integer.parseInt(s[1]);
            hx = Integer.parseInt(s[2]);
            hy = Integer.parseInt(s[3]);
            
            for (int i = 0; i < N; i++) {
                arr[i][0] = Integer.parseInt(s[i*2+4]);
                arr[i][1] = Integer.parseInt(s[i*2+5]);
            }
            
            min = Integer.MAX_VALUE;
            
            for (int i = 0; i < N; i++) {
                int sum = Math.abs(ox-arr[i][0]) + Math.abs(oy-arr[i][1]);
                check[i]=true;
                d(i, sum,0);
                check[i]=false;
            }   
            System.out.println("#"+t+" "+min);
        }
    }
    
    static void d(int idx, int sum, int cnt) {
        if(cnt>=N-1) {
            sum += Math.abs(hx-arr[idx][0]) + Math.abs(hy-arr[idx][1]);
            
            if(sum<min) 
            	min = sum;
            
            return;
        }
        
        for (int i = 0; i < N; i++) {
            if(!check[i]) {
                check[i]=true;
                cnt++;
                int sum2 = sum + Math.abs(arr[idx][0]-arr[i][0]) + Math.abs(arr[idx][1]-arr[i][1]);
                
                d(i, sum2, cnt);
                
                cnt--;
                check[i]=false;
            }
        }
    }
}