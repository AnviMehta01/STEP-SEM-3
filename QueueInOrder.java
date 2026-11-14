package week11assignment;


public class QueueInOrder {

    static int firstBreak(int[] tokens) {
        for (int i = 1; i < tokens.length; i++) {
            if (tokens[i] < tokens[i - 1])
                return i;
        }

        return -1;
    }

    public static void main(String[] args) {
        int[] tokens = {3, 5, 5, 8, 6, 9};
        System.out.println(firstBreak(tokens));

        int[] tokens2 = {1, 2, 2, 5};
        System.out.println(firstBreak(tokens2));
    }
}

