package week11;


import java.util.*;

public class RemoveDuplicates {

    static int removeDuplicates(int[] nums) {
        if (nums.length == 0)
            return 0;

        int j = 0;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[j]) {
                j++;
                nums[j] = nums[i];
            }
        }

        return j + 1;
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 2, 2, 2, 3, 4, 4, 5};

        int length = removeDuplicates(nums);

        System.out.println("Length = " + length);
        System.out.println("nums[0.." + (length - 1) + "] = " +
                Arrays.toString(Arrays.copyOf(nums, length)));
    }
}

