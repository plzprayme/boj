package 코딜리티;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

public class 트레이닝2 {
    @Test
    public void main() {
        // int[] arr = new int[] {
        //     3, 8, 9, 7, 6
        // };
        // int[] arr = new int[] {
        //     0, 0, 0
        // };
        int[] arr = new int[] {
            -5, 1000
        };


        System.out.println(Arrays.toString(new Solution().solution(new int[]{}, 0)));
    }

    static class Solution {
        public int[] solution(int[] A, int K) {
            if (K == A.length || K == 0 || A.length == 0) return A;
            K %= A.length;
            int[] newArr = new int[A.length];

            for (int i = 0; i < K; i++) {
                newArr[i] = A[A.length - K + i];
            }

            for (int i = K; i < A.length; i++) {
                newArr[i] = A[i - K];
            }

            return newArr;
        }
    }
}
