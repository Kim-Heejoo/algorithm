package swea;

import java.util.Scanner;

public class Solution1266_소수완제품확률 { //1266. [S/W 문제해결 응용] 9일차 - 소수 완제품 확률
    static int[] primeNum = {2,3,5,7,11,13,17};
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        
        for (int t = 1; t <= T; t++) {
            double p1 = sc.nextInt()/100.0;
            double p2 = sc.nextInt()/100.0;     
            int n=18;
            double primeA=0;
            double primeB=0;
            
            for (int i = 0; i < primeNum.length; i++) {
                int r = primeNum[i];
                primeA += nCr(n,r,1)*Math.pow(p1, r)*Math.pow(1-p1, n-r);
                primeB += nCr(n,r,1)*Math.pow(p2, r)*Math.pow(1-p2, n-r);
            }
            
            double result = 1-((1-primeA)*(1-primeB));
            System.out.printf("#%d %.6f\n",t,result);
        }
    }
    
    static double nCr(int n, int r, double result) {
        if(r==1) {
            return result*n;
        }
        
        result *= n;
        result /= r;
        
        return nCr(n-1,r-1,result);
    }
}