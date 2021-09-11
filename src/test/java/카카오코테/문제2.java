package 카카오코테;

import java.util.Stack;

import org.junit.jupiter.api.Test;

class 문제2 {
    public int solution(int n, int k) {

        int answer = 0;

        StringBuilder sb = new StringBuilder();
        while (n > 0) {
            sb.append(n%k);
            n /= k;
        }
        String after = sb.reverse().toString();

        int left = 0, right = 0;
        while (right < after.length()) {

            if (after.charAt(left) == '0') {
                left++;
                right = left;
            }

            if (right + 1 < after.length()) {
                if (after.charAt(right + 1) == '0') {

                    String s = after.substring(left, right + 1);
                    if (isPrime(s)) {
                        if (left == 0 && right == after.length() - 1) {
                            answer++;
                        }

                        if (left == 0 && right + 1 != after.length() && after.charAt(right + 1) == '0') {
                            answer++;
                        }

                        if (right == after.length() -1 && left - 1 != -1 && after.charAt(left - 1) == '0') {
                            answer++;
                        }

                        if (left - 1 != -1 && right + 1 != after.length() && after.charAt(left - 1) == '0' && after.charAt(right + 1) == '0') {
                            answer++;
                        }
                    }

                    left = right + 1;
                    right = left;
                } else {
                    right++;
                }
            } else {

                if (after.charAt(right) != '0') {

                    String s = after.substring(left, right + 1);
                    if (isPrime(s)) {
                        if (left == 0 && right == after.length() - 1) {
                            answer++;
                        }

                        if (left == 0 && right + 1 != after.length() && after.charAt(right + 1) == '0') {
                            answer++;
                        }

                        if (right == after.length() -1 && left - 1 != -1 && after.charAt(left - 1) == '0') {
                            answer++;
                        }

                        if (left - 1 != -1 && right + 1 != after.length() && after.charAt(left - 1) == '0' && after.charAt(right + 1) == '0') {
                            answer++;
                        }
                    }
                }

                break;
            }

        }

        return answer;
    }

    public boolean isPrime(String s) {
        int i = Integer.parseInt(s);
        if (i < 2) return false;
        if (i == 2) return true;

        for (int j = 2; j <= Math.sqrt(i); j++) {
            if (i % j == 0) return false;
        }
        return true;
    }

    @Test
    public void main() {
        System.out.println(
            solution(
                437674, 3
            )
        );

        System.out.println(
            solution(
                110011, 10
            )
        );
        System.out.println(
            solution(
                3285023, 3
            )
        );
    }
}
