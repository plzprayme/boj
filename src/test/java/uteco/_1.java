package uteco;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

public class _1 {
    @Test
    public void main() {
        solution(
            new int[]{ 2, 1, 3, 1, 2, 1 }
        );

        solution(
            new int[]{ 3, 3, 3, 3, 3, 3 }
        );

        solution(
            new int[]{ 1, 2, 3 }
        );

        solution(
            new int[]{ 1, 1, 2, 2 }
        );
    }

    public int[] solution(int[] arr) {
        int[] counts = getCounts(arr);
        int maxCount = getMax(counts);
        return getAnswer(counts, maxCount);
    }

    private int[] getCounts(int[] arr) {
        int[] counts = { 0, 0, 0 };
        for (int i : arr) {
            counts[i - 1]++;
        }
        return counts;
    }

    private int getMax(int[] arr) {
        int max = Integer.MIN_VALUE;
        for (int i : arr) {
            max = Math.max(i, max);
        }
        return max;
    }

    private int[] getAnswer(int[] counts, int maxCount) {
        int[] answer = {0, 0, 0};
        for (int i = 0; i < counts.length; i++) {
            int count = counts[i];
            answer[i] += maxCount - count;
        }
        return answer;
    }
}
