package 코딜리티;

public class 트레이닝3 {
    class Solution {
        public int solution(int[] A) {
            int right = 0;
            for (int i = 1; i < A.length; i++) {
                right += A[i];
            }

            int left = A[0];
            int answer = Math.abs(left - right);
            for (int i = 1; i < A.length - 1; i++) {
                left += A[i];
                right -= A[i];
                answer = Math.min(Math.abs(left - right), answer);
            }

            answer = Math.min(Math.abs(left - right), answer);
            return answer;
        }
    }
}
