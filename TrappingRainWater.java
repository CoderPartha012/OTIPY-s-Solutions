import java.util.Scanner;

public class TrappingRainWater {

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

        // Compute the amount of water that can be trapped
        int trappedWater = computeTrappedWater(array);

        // Print the result
        System.out.println("The amount of water that can be trapped is " + trappedWater);

        scanner.close();
    }

    public static int computeTrappedWater(int[] array) {
        int n = array.length;
        if (n == 0) {
            return 0;
        }
        int[] leftMax = new int[n];
        int[] rightMax = new int[n];
        leftMax[0] = array[0];
        for (int i = 1; i < n; i++) {
            leftMax[i] = Math.max(leftMax[i - 1], array[i]);
        }
        rightMax[n - 1] = array[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            rightMax[i] = Math.max(rightMax[i + 1], array[i]);
        }
        int trappedWater = 0;
        for (int i = 0; i < n; i++) {
            trappedWater += Math.min(leftMax[i], rightMax[i]) - array[i];
        }
        return trappedWater;
    }
}
