import java.util.Arrays;

public class MaxDiscount {
    public static int minimizeThePurchase(int[] price, int k, int x) {
        int n = price.length;
        int[][] dp = new int[n + 1][k + 1];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        return memo(price, k, x, 0, dp);
    }

    public static int memo(int[] price, int remainingCoupons, int x, int index, int[][] dp) {
        // Base case: when we've processed all items
        if (index >= price.length) {
            return 0;
        }

        // If we've already computed this state
        if (dp[index][remainingCoupons] != -1) {
            return dp[index][remainingCoupons];
        }

        // Don't use any coupon on current item
        int minCost = price[index] + memo(price, remainingCoupons, x, index + 1, dp);

        // Try using coupons (can use multiple coupons on same item)
        int couponsToUse = 1;
        while (couponsToUse <= remainingCoupons) {
            int reducedPrice = Math.max(0, price[index] - (couponsToUse * x));
            int costWithCoupons = reducedPrice +
                    memo(price, remainingCoupons - couponsToUse, x, index + 1, dp);
            minCost = Math.min(minCost, costWithCoupons);

            // If price is already reduced to 0, no need to try more coupons
            if (reducedPrice == 0) break;

            couponsToUse++;
        }

        dp[index][remainingCoupons] = minCost;
        return minCost;
    }

    public static void main(String[] args) {
        // Test case 1
        int[] prices1 = {8, 3, 10, 5, 13};
        int k1 = 4, x1 = 7;
        System.out.println("Test case 1: " + minimizeThePurchase(prices1, k1, x1)); // Should output 12

        // Test case 2
        int[] prices2 = {7, 2, 8, 4, 11};
        int k2 = 9, x2 = 7;
        System.out.println("Test case 2: " + minimizeThePurchase(prices2, k2, x2)); // Should output 0

        // Test case 3
        int[] prices3 = {1, 3, 4};
        int k3 = 1, x3 = 13;
        System.out.println("Test case 3: " + minimizeThePurchase(prices3, k3, x3)); // Should output 4
    }
}