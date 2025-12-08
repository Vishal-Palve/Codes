package LeetCode;

public class Q121 {
        public  static int maxProfit(int[] prices) {
            int minPrice = prices[0];
            int maxProfit = 0;

            for (int i = 1; i < prices.length; i++) {
                if (prices[i] < minPrice) {
                    minPrice = prices[i]; // update buying price
                } else {
                    maxProfit = Math.max(maxProfit, prices[i] - minPrice);
                }
            }

            return maxProfit;
    }

    public static void main(String[] args) {
        int[] nums = {7,1,5,3,6,4};
        int[] num = {2,1,4};
        System.out.println(maxProfit(num));
    }
}
