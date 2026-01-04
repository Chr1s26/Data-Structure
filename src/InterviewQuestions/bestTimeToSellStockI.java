public class bestTimeToSellStockI{
    public static void main(String[] args){

    }

    public int maxProfit(int[] prices) {
        if(prices.length == 0 || prices.length == 1) return 0;
        int buyPrices = prices[0];
        int profit = 0;
        for(int i = 1; i < prices.length; i++){
            buyPrices = Math.min(buyPrices,prices[i]);
            profit = Math.max(profit,prices[i] - buyPrices);
        }
        return profit;
    }
}