import java.util.Arrays;

class Solution {
    public int candy(int[] ratings) {
        int n = ratings.length;
        int[] candies = new int[n];
        Arrays.fill(candies, 1);

        // Recorrido de izquierda a derecha
        for (int i = 1; i < n; i++) {
            if (ratings[i] > ratings[i - 1]) {
                candies[i] = candies[i - 1] + 1;
            }
        }

        // Recorrido de derecha a izquierda
        for (int i = n - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1]) {
                candies[i] = Math.max(candies[i], candies[i + 1] + 1);
            }
        }

        // Sumar los caramelos
        int totalCandies = 0;
        for (int candy : candies) {
            totalCandies += candy;
        }

        return totalCandies;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] ratings1 = { 1, 0, 2 };
        System.out.println(sol.candy(ratings1)); // Output: 5
        int[] ratings2 = { 1, 2, 2 };
        System.out.println(sol.candy(ratings2)); // Output: 4
        int[] ratings3 = { 1, 2, 3, 4, 5, 4, 3, 2, 1 };
        System.out.println(sol.candy(ratings3)); // Output: 25
    }
}