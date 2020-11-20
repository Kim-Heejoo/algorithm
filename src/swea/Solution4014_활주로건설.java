package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
 
public class Solution4014_활주로건설 {	//4014.[모의 SW 역량테스트] 활주로 건설
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        
        for (int t = 1; t <= T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int X = Integer.parseInt(st.nextToken());
            int[][] map = new int[N][N];
            
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            
            int ans = N*2;
            for (int i = 0; i < N; i++) {
                int now = map[i][0];
                int cnt = 1;
                
                for (int j = 1; j < N; j++) {
                    if(now==map[i][j]) cnt++;
                    else if(now-1==map[i][j]) {
                        int fcnt=1;
                        for (int f = j+1; f < N; f++) {
                            if(map[i][f]!=now-1) break;
                            else {
                                fcnt++;
                            }
                        }
                        
                        if(fcnt<X) {
                            ans--;
                            break;
                        }else {
                            now = map[i][j+X-1];
                            cnt=0;
                            j=j+X-1;
                        }
                    }else if(now+1==map[i][j]) {
                        if(cnt>=X) {
                            now = map[i][j];
                            cnt=1;
                        }else {
                            ans--;
                            break;
                        }
                    }else {
                        ans--;
                        break;
                    }
                }
            }
             
            for (int i = 0; i < N; i++) {
                int now = map[0][i];
                int cnt = 1;
                
                for (int j = 1; j < N; j++) {
                    if(now==map[j][i]) cnt++;
                    else if(now-1==map[j][i]) {
                        int fcnt=1;
                        for (int f = j+1; f < N; f++) {
                            if(map[f][i]!=now-1) break;
                            else fcnt++;
                        }
                        
                        if(fcnt<X) {
                            ans--;
                            break;
                        }else {
                            now = map[j+X-1][i];
                            cnt=0;
                            j=j+X-1;
                        }
                    }else if(now+1==map[j][i]) {
                        if(cnt>=X) {
                            now = map[j][i];
                            cnt=1;
                        }else {
                            ans--;
                            break;
                        }
                    }else {
                        ans--;
                        break;
                    }
                }
            }
             
            System.out.println("#"+t+" "+ans);
        }
    }
}