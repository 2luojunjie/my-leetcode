package hot100.lc121;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * ClassName: Main
 * Package: hot100.lc121
 * Description: 买卖股票的最佳时机
 *
 * @Author: Luojunjie
 * @Create 2026/5/5 15:10
 * Version 1.0
 */
public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        if(line == null || line.trim().isEmpty()) return;

        int n = Integer.parseInt(line.trim());
        if(n == 0) {
            System.out.println(0);
            return;
        }

        int[] prices = new int[n];
        line = br.readLine();
        StringTokenizer st = new StringTokenizer(line);
        for(int i = 0; i < n; i++) prices[i] = Integer.parseInt(st.nextToken());

        int maxProfit = maxProfit(prices);
        System.out.print(maxProfit);

    }

    public static int maxProfit(int[] prices){
        if(prices == null || prices.length <= 1) return 0;
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;
        for(int i = 0; i < prices.length; i++){
            if(prices[i] < minPrice) minPrice = prices[i];
            if(prices[i] - minPrice > maxProfit) {
                maxProfit = prices[i] - minPrice;
            }
        }
        return maxProfit;
    }
}
