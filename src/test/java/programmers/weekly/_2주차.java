package programmers.weekly;

import org.junit.jupiter.api.Test;

public class _2주차 {

    @Test
    void main() {
        int[][] input = {
            {100, 90, 98, 88, 65},
            {50, 45, 99, 85, 77},
            {47, 88, 95, 80, 67},
            {61, 57, 100, 80, 65},
            {24, 90, 94, 75, 65}
        };
        System.out.println(new Solution().solution(input));
    }

    class Solution {
        public String solution(int[][] scores) {
            StringBuilder sb = new StringBuilder();
            for (int row = 0; row < scores.length; row++) {
                // 분모
                int divide = scores.length;
                // 분자 (점수들의 합)
                int sum = 0;
                sum = sum(scores, row, sum);

                // 내 점수
                int my = scores[row][row];

                // 최대 최소 구하기
                int max = max(scores, row);
                int min = min(scores,row);
                // 내 점수가 최대이거나 최소 일 때
                if (my == max || my == min) {
                    // 내 점수가 유일하게 최대이거나 최소 일떄
                    int count = isOnly(scores, row, my);
                    if (count < 2) {
                        // 분모에서 내 점수 빼고 분자에서 나를 뺸다.
                        sum -= my;
                        --divide;
                    }
                }

                int mean = sum / divide;
                if (90 <= mean) sb.append('A');
                else if (80 <= mean && mean < 90) sb.append('B');
                else if (70 <= mean && mean < 80) sb.append('C');
                else if (50 <= mean && mean < 70) sb.append('D');
                else sb.append('F');
            }

            return sb.toString();
        }

        private int min(int[][] scores, int row) {
            int min = 101;
            for (int col = 0; col < scores.length; col++) {
                int other = scores[col][row];
                min = Math.min(other, min);
            }
            return min;
        }

        private int isOnly(int[][] scores, int row, int my) {
            int count = 0;
            for (int col = 0; col < scores.length; col++) {
                if (my == scores[col][row]) count++;
            }
            return count;
        }

        private int max(int[][] scores, int row) {
            int max = -1;
            for (int col = 0; col < scores.length; col++) {
                int other = scores[col][row];
                max = Math.max(other, max);
            }
            return max;
        }

        private int sum(int[][] scores, int row, int sum) {
            for (int col = 0; col < scores.length; col++) {
                sum += scores[col][row];
            }
            return sum;
        }

    }
}
