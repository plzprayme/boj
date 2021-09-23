package 코딜리티;

import org.junit.jupiter.api.Test;

public class 트레이닝1 {
    @Test
    public static void main(String[] args) {
        System.out.println(new Solution().solution(
            new int[] {
                1, -2, 0, 9, -1, -2
            }
        ));
    }

    static class Solution {
        static int N;
        static int answer;
        static int[] a;

        public int solution(int[] A) {
            N = A.length;
            answer = A[0];
            a = A;

            rec(0, answer);

            return answer;
        }

        void rec(int n, int value) {
            if (n == N - 1) {
                answer = Math.max(answer, value);
            } else {
                for (int i = 1; i <= 6; i++) {

                    if (n + i < N) {
                        rec(n + i, value + a[n + i]);
                    }

                }
            }
        }
    }
}
