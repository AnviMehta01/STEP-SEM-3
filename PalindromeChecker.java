package week1;

import java.util.*;

public class PalindromeChecker {

    static boolean isPalindromeIterative(String text) {
        int i = 0;
        int j = text.length() - 1;

        while (i < j) {
            if (text.charAt(i) != text.charAt(j))
                return false;

            i++;
            j--;
        }

        return true;
    }

    static boolean isPalindromeRecursive(String text) {
        if (text.length() <= 1)
            return true;

        if (text.charAt(0) != text.charAt(text.length() - 1))
            return false;

        return isPalindromeRecursive(
            text.substring(1, text.length() - 1)
        );
    }

    static boolean isPalindromeArrayReversal(String text) {
        char[] arr = text.toCharArray();

        int i = 0;
        int j = arr.length - 1;

        while (i < j) {
            char temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;

            i++;
            j--;
        }

        String reversed = new String(arr);

        return text.equals(reversed);
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter text: ");
        String text = sc.nextLine();

        System.out.println("Iterative: " +
            (isPalindromeIterative(text)
            ? "Palindrome" : "Not Palindrome"));

        System.out.println("Recursive: " +
            (isPalindromeRecursive(text)
            ? "Palindrome" : "Not Palindrome"));

        System.out.println("Array Reversal: " +
            (isPalindromeArrayReversal(text)
            ? "Palindrome" : "Not Palindrome"));
    }
}