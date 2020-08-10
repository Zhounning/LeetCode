package leetCode;

public class winnerSquareGame {
    public boolean WinnerSquareGame(int n) {
        boolean dp[] = new boolean[n + 1];

        for (int i = 0; i <= n; i++) {
            for (int j = 1; j * j <= i; j++) {
                dp[i] = !dp[i - j * j] || dp[i];
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        winnerSquareGame w = new winnerSquareGame();
        int n = 17;
        System.out.println(w.WinnerSquareGame(n));
    }
}