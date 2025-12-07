
import java.util.Scanner;

public class WinnerLottery{
        
        
    private static int cost(char a, char b) {
        int x = a - 'a';
        int y = b - 'a';
        int forward = (y - x + 26) % 26;
        int backward = (x - y + 26) % 26;
        return Math.min(forward, backward);
    }

    public static int getMaximumLength(String lotteryID, String winnerID, int k) {
        int n = lotteryID.length();
        int m = winnerID.length();

        int[][][] dp = new int[n + 1][m + 1][k + 1];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {

                int convertCost = cost(lotteryID.charAt(i - 1), winnerID.charAt(j - 1));

                for (int c = 0; c <= k; c++) {

                    dp[i][j][c] = Math.max(dp[i][j][c], dp[i - 1][j][c]);

                    dp[i][j][c] = Math.max(dp[i][j][c], dp[i][j - 1][c]);

                    if (c >= convertCost) {
                        dp[i][j][c] = Math.max(
                            dp[i][j][c],
                            1 + dp[i - 1][j - 1][c - convertCost]
                        );
                    }
                }
            }
        }

        int ans = 0;
        for (int c = 0; c <= k; c++) {
            ans = Math.max(ans, dp[n][m][c]);
        }
        return ans;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String lotteryID = "hacker";
        String winnerID = "hacker";
        int k = 10;

        System.out.println(getMaximumLength(lotteryID, winnerID, k));
    }
}