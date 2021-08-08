package leet.august;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

public class PalindromePartitioning2 {

    @Test
    public void 예제() {
        minCut("aab");
    }

    public int minCut(String s) {
        int n = s.length();

        // Palindrome 여부를 기억하고 있기
        boolean[][] isPalindrome = new boolean[n][n];

        // 1글자는 모두 palindrome이다.
        for (int i = 0; i < n; i++) {
            isPalindrome[i][i] = true;
        }

        // 두 글자 palindrome
        for (int i = 0; i < n -1; i++) {
            isPalindrome[i][i+1] = s.charAt(i) == s.charAt(i+1);
        }

        // 세 글자 이상 palindrome
        for (int curr_len = 3; curr_len <= n; curr_len++) {
            for (int i = 0; i < n - curr_len + 1; i++) {
                int j = i + curr_len - 1;
                isPalindrome[i][j] = s.charAt(i) == s.charAt(j) && isPalindrome[i + 1][j - 1];
            }
        }

        // 조각들 찾기
        int[] cuts = new int[n];
        for (int i = 0; i < n; i++) {
            int temp = Integer.MAX_VALUE;
            if (isPalindrome[0][i]) {
                cuts[i] = 0;
            }
            else {
                for (int j = 0; j < i; j++) {
                    if (isPalindrome[j + 1][i] && temp > cuts[j] + 1) {
                        temp = cuts[j] + 1;
                    }
                }
                cuts[i] = temp;
            }
        }
        return cuts[n - 1];
    }
}
