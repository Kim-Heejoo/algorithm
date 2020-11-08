package swea;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.PriorityQueue;
 
public class Solution7396_종구의딸이름짓기 {	// 종구의 딸이름 짓기
    static char[][] map;
    static boolean[][] visit;
    static int N,M;
    static int[] dx = {0,1};
    static int[] dy = {1,0};
     
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            String[] line = br.readLine().split(" ");
            N = Integer.parseInt(line[0]);
            M = Integer.parseInt(line[1]);
            map = new char[N][];
            visit = new boolean[N][M];
            
            for (int i = 0; i < N; i++) {
                map[i] = br.readLine().toCharArray();
            }
             
            PriorityQueue<Point> pq = new PriorityQueue<>();
            ArrayList<Point> list = new ArrayList<>();
            pq.add(new Point(0,0,map[0][0]));
            visit[0][0] = true;
             
            bw.write("#"+t+" ");
            while(!pq.isEmpty()) {
                int size = pq.size();
                 
                Point first = pq.peek();
                for(int s = 0; s<size; s++) {
                    Point now = pq.poll();
                    if(first.ch == now.ch) {
                        for (int d = 0; d < 2; d++) {
                            int nx = now.i + dx[d];
                            int ny = now.j + dy[d];
                             
                            if(nx>=0 && nx<N && ny>=0 && ny<M && !visit[nx][ny]) {
                                list.add(new Point(nx,ny,map[nx][ny]));
                                visit[nx][ny] = true;
                            }
                        }
                    }else {
                        break;
                    }
                }
                pq.clear();
                pq.addAll(list);
                list.clear();
                bw.write(first.ch);
            }
            bw.write("\n");
        }
        br.close();
        bw.flush();
        bw.close();
    }
     
    static class Point implements Comparable<Point> {
        int i,j;
        char ch;
        Point(int i, int j, char ch) {
            this.i = i;
            this.j = j;
            this.ch = ch;
        }
        @Override
        public int compareTo(Point o) {
            return this.ch-o.ch;
        }
    }
}