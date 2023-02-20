import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class TwoSum {

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

        // Get the target sum from the user
        System.out.print("Enter the target sum: ");
        int target = scanner.nextInt();

        // Check if there exist two elements in the array whose sum is the target
        boolean result = hasTwoSum(array, target);

        // Print the result
        if (result) {
            System.out.println("There exist two elements in the array whose sum is " + target);
        } else {
            System.out.println("There does not exist two elements in the array whose sum is " + target);
        }

        scanner.close();
    }

    public static boolean hasTwoSum(int[] array, int target) {
        Set<Integer> set = new HashSet<Integer>();
        for (int i = 0; i < array.length; i++) {
            int complement = target - array[i];
            if (set.contains(complement)) {
                return true;
            }
            set.add(array[i]);
        }
        return false;
    }
}
