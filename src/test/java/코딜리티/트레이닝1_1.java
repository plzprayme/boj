package 코딜리티;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

public class 트레이닝1_1 {
    @Test
    public static void main(String[] args) {
        System.out.println(new Solution().solution(1041));
    }


    static class Solution {

        public int solution(int N) {
            String bin = toBinaryString(N);

            int answer = 0;
            int left = 0;
            for (int i = 1; i < bin.length(); i++) {
                if (bin.charAt(i) == '1') {
                    answer = Math.max(i - left - 1, answer);
                    left = i;
                }
            }

            return answer;
        }

        private String toBinaryString(int N) {
            StringBuilder sb = new StringBuilder();
            while (N != 1) {
                sb.append(N % 2);
                N /= 2;
            }
            sb.append(N);
            return sb.reverse().toString();
        }

    }

}
