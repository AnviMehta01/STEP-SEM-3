package week4assignment;

import java.util.HashMap;
import java.util.Scanner;

public class SubarraySumEqualsK {

    static int subarraySum(int[] nums, int k) {

        HashMap<Integer, Integer> prefixSum = new HashMap<>();

        prefixSum.put(0, 1);

        int currentSum = 0;
        int count = 0;

        for (int i = 0; i < nums.length; i++) {

            currentSum = currentSum + nums[i];

            if (prefixSum.containsKey(currentSum - k)) {
                count = count + prefixSum.get(currentSum - k);
            }

            if (prefixSum.containsKey(currentSum)) {
                prefixSum.put(currentSum,
                        prefixSum.get(currentSum) + 1);
            } else {
                prefixSum.put(currentSum, 1);
            }
        }

        return count;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of elements: ");
        int n = sc.nextInt();

        int[] nums = new int[n];

        System.out.println("Enter elements:");
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        System.out.print("Enter k: ");
        int k = sc.nextInt();

        System.out.println("Number of subarrays: "
                + subarraySum(nums, k));
    }
}