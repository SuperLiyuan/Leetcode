package Leetcode75;

public class CoinChange_322 {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount+1];
        //初始化，所有硬币都用1,最大值的情况
        for(int i = 0;i<amount+1;i++){
            dp[i] = amount + 1;
        }
        for(int i = 0;i<amount+1;i++){
            for(int coin: coins){
                if(i-coin>=0){
                    dp[i] = Math.min(dp[i], dp[i-coin]+1);
                }
            }
        }
        return dp[amount] == amount+1?-1:dp[amount];
    }
}
