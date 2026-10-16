package week10assignment;

public class ExamScoreBandCounter {

    static int countInBand(int[] scores, int low, int high) {
        int left = 0, right = scores.length;

        // First position with score >= low
        while (left < right) {
            int mid = left + (right - left) / 2;

            if (scores[mid] < low)
                left = mid + 1;
            else
                right = mid;
        }

        int start = left;
        left = 0;
        right = scores.length;

        // First position with score > high
        while (left < right) {
            int mid = left + (right - left) / 2;

            if (scores[mid] <= high)
                left = mid + 1;
            else
                right = mid;
        }

        return left - start;
    }

    public static void main(String[] args) {
        int[] scores = {35, 42, 42, 50, 58, 58, 58, 63, 71, 88};

        System.out.println(countInBand(scores, 42, 58));
        System.out.println(countInBand(scores, 90, 100));
    }
}
