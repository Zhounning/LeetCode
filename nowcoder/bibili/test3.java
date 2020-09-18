package niuke.bibili;

import java.util.Scanner;

public class test3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int M = sc.nextInt();

        int w[] = new int[n];
        for (int i = 0; i < n; i++) {
            w[i] = sc.nextInt();
        }
        // int w[] = { 2, 2, 6, 5, 4 };
        int v[] = new int[n];
        for (int i = 0; i < n; i++) {
            v[i] = sc.nextInt();
        }
        // int v[] = { 6, 3, 5, 4, 6 };
        int[] dp = new int[M + 1];

        for (int i = 0; i < n; i++) {
            for (int j = M; j >= w[i]; j--) {
                dp[j] = Math.max(dp[j], dp[j - w[i]] + v[i]);
            }
        }
        System.out.println(dp[M]);
    }
}