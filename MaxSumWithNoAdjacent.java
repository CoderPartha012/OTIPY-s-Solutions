import java.util.Scanner;

public class MaxSumWithNoAdjacent {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Get the input array from the user
        System.out.print("Enter the number of elements in the array: ");
        int n = scanner.nextInt();
        int[] array = new int[n];
        System.out.print("Enter the elements of the array: ");
        for (int i = 0; i < n; i++) {
            array[i] = scanner.nextInt();
        }

        // Compute the maximum sum with no adjacent elements
        int maxSum = computeMaxSumWithNoAdjacent(array);

        // Print the result
        System.out.println("The maximum sum of a subsequence with no adjacent elements is " + maxSum);

        scanner.close();
    }

    public static int computeMaxSumWithNoAdjacent(int[] array) {
        int n = array.length;
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return array[0];
        }
        int[] dp = new int[n];
        dp[0] = array[0];
        dp[1] = Math.max(array[0], array[1]);
        for (int i = 2; i < n; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + array[i]);
        }
        return dp[n - 1];
    }
}
