package dp.lc518零钱兑换II;

/**
 * ClassName: Change
 * Package: dp.lc518零钱兑换II
 *
 * @author: 罗骏杰
 * @create: 2025-12-14 17:43
 * @Description:
 */
class Solution {
    public int change(int amount, int[] coins) {
        int n = coins.length;
        // 使用下标为[0, i]的coins[i]能够凑满j（包括j）这么大容量的包，有dp[i][j]种组合方法。
        int[][] dp = new int[n][amount+1];
        for(int i = 0; i < n; i++){
            dp[i][0] = 1;
        }

        for(int j = 0; j <= amount; j++){
            if(j % coins[0] == 0) dp[0][j] = 1;
        }

        for(int i = 1; i < n; i++){
            for(int j = 0; j <= amount; j++){
                if(j < coins[i]) {
                    dp[i][j] = dp[i-1][j];
                }else {
                    dp[i][j] = dp[i][j- coins[i]] + dp[i-1][j];
                }
            }
        }

        return dp[n-1][amount];

    }
}

public class Change {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int amount = 5;
        int[] coins = {1, 2, 5};
        int res = solution.change(amount, coins);
        System.out.println(res);
    }
}