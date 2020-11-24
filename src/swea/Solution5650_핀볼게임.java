package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution5650_핀볼게임 {	//5650.[모의 SW 역량테스트] 핀볼 게임
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    static int N;
    static int[][] map,warm;
    static int ans;
    static int x,y,ox,oy;
    
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        
        for (int t = 1; t <= T; t++) {
            N = Integer.parseInt(br.readLine());
            map = new int[N+2][N+2];
            warm = new int[5][5];
            
            for (int i = 0; i < N+2; i++) {
                if(i==0 || i==N+1) {
                    for (int j = 0; j < N+2; j++) {
                        map[i][j]=5;
                    }
                } else {
                    String[] line = br.readLine().split(" ");
                    
                    for (int j = 0; j < N+2; j++) {
                        if(j==0 || j==N+1) {
                            map[i][j]=5;
                        } else {
                            map[i][j] = Integer.parseInt(line[j-1]);
                            
                            if(map[i][j]>=6) {
                                if(warm[map[i][j]-6][0]==0) {
                                    warm[map[i][j]-6][0]=1;
                                    warm[map[i][j]-6][1]=i;
                                    warm[map[i][j]-6][2]=j;
                                } else {
                                    warm[map[i][j]-6][3]=i;
                                    warm[map[i][j]-6][4]=j;
                                    map[i][j]+=5;
                                }
                            }                           
                        }
                    }
                }
            }
            
            ans=0;
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= N; j++) {
                    if(map[i][j]==0) {
                        ox=i;
                        oy=j;
                        
                        for (int d = 0; d < 4; d++) {
                            x=i;
                            y=j;
                            play(d,0);
                        }
                    }
                }
            }
            System.out.println("#"+t+" "+ans);
        }
    }
    
    static void play (int d, int cnt) {
        if(map[x][y]==1) {
            if(d==0 || d==3) {
                cnt = cnt*2-1;
                if(cnt>ans) ans=cnt;
                return;
            }
            
            if(d==1) d=3;
            else d=0;
            
        }else if(map[x][y]==2) {
            if(d==1 || d==3) {
                cnt = cnt*2-1;
                if(cnt>ans) ans=cnt;
                return;
            }
            
            if(d==0) d=3;
            else d=1;
            
        }else if(map[x][y]==3) {
            if(d==1 || d==2) {
                cnt = cnt*2-1;
                if(cnt>ans) ans=cnt;
                return;
            }
            
            if(d==3) d=1;
            else d=2;
            
        }else if(map[x][y]==4) {
            if(d==0 || d==2) {
                cnt = cnt*2-1;
                if(cnt>ans) ans=cnt;
                return;
            }
            
            if(d==3) d=0;
            else d=2;
            
        }else if(map[x][y]==5) {
            cnt=cnt*2-1;
            if(cnt>ans) ans=cnt;
            return;
        }
        
        boolean flag = false;
        while(true) {
            x+=dx[d];
            y+=dy[d];
            
            if(map[x][y]==-1 || (x==ox && y==oy)) {
                if(cnt>ans) ans=cnt;
                return;
            }
            
            if(map[x][y]>=1 && map[x][y]<=5) {
                flag=true;
                break;
            }
            
            if(map[x][y]>=6 && map[x][y]<=10) {
                int a = map[x][y]-6;
                x=warm[a][3];
                y=warm[a][4];
            }else if(map[x][y]>=11) {
                int a = map[x][y]-11;
                x=warm[a][1];
                y=warm[a][2];
            }
        }
        
        if(flag) {
            play(d,cnt+1);
        }
    }
}