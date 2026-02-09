public class BestTimeToSellStockIV{
        public int maxProfit(int k, int[] prices) {
        int n = prices.length;
        if (n == 0 || k == 0) return 0;

        // Optimization: unlimited transactions
        if (k >= n / 2) {
            int profit = 0;
            for (int i = 1; i < n; i++) {
                if (prices[i] > prices[i - 1]) {
                    profit += prices[i] - prices[i - 1];
                }
            }
            return profit;
        }

        // dp[t][0] = max profit after t transactions, not holding stock
        // dp[t][1] = max profit after t transactions, holding stock
        int[][] dp = new int[k + 1][2];

        for (int t = 0; t <= k; t++) {
            dp[t][1] = Integer.MIN_VALUE;
        }

        for (int price : prices) {
            for (int t = 1; t <= k; t++) {
                dp[t][0] = Math.max(dp[t][0], dp[t][1] + price);
                dp[t][1] = Math.max(dp[t][1], dp[t - 1][0] - price);
            }
        }

        return dp[k][0];
    }

}