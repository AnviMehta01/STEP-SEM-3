package week4assignment;

import java.util.Scanner;

public class ThreeSum {

    static int[][] threeSum(int[] nums) {

        // Sort the array
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = 0; j < nums.length - i - 1; j++) {
                if (nums[j] > nums[j + 1]) {
                    int temp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = temp;
                }
            }
        }

        int[][] tempResult = new int[nums.length][3];
        int count = 0;

        for (int i = 0; i < nums.length - 2; i++) {

            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            int left = i + 1;
            int right = nums.length - 1;

            while (left < right) {

                int sum = nums[i] + nums[left] + nums[right];

                if (sum == 0) {

                    tempResult[count][0] = nums[i];
                    tempResult[count][1] = nums[left];
                    tempResult[count][2] = nums[right];
                    count++;

                    int leftValue = nums[left];
                    int rightValue = nums[right];

                    while (left < right && nums[left] == leftValue) {
                        left++;
                    }

                    while (left < right && nums[right] == rightValue) {
                        right--;
                    }

                } else if (sum < 0) {
                    left++;
                } else {
                    right--;
                }
            }
        }

        int[][] result = new int[count][3];

        for (int i = 0; i < count; i++) {
            result[i][0] = tempResult[i][0];
            result[i][1] = tempResult[i][1];
            result[i][2] = tempResult[i][2];
        }

        return result;
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

        int[][] result = threeSum(nums);

        System.out.print("Result: [");

        for (int i = 0; i < result.length; i++) {

            System.out.print("["
                    + result[i][0] + ", "
                    + result[i][1] + ", "
                    + result[i][2] + "]");

            if (i < result.length - 1) {
                System.out.print(", ");
            }
        }

        System.out.println("]");
    }
}