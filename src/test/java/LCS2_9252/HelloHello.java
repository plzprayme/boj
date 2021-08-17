package LCS2_9252;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import org.junit.jupiter.api.Test;

public class HelloHello {
    @Test
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(new File("C:\\Users\\prayme\\workspace\\boj\\src\\test\\java\\LCS2_9252\\input.txt"));


        String s1 = "#" + sc.nextLine();
        String s2 = "#" + sc.nextLine();

        int s1Size = s1.length();
        int s2Size = s2.length();

        int[][] dp = new int[s1Size][s2Size];
        for (int i = 1; i < s1Size; i++) {
            for (int j = 1; j < s2Size; j++) {
                dp[i][j] = s1.charAt(i) == s2.charAt(j) ? dp[i-1][j-1] + 1 : Math.max(dp[i-1][j], dp[i][j-1]);
            }
        }

        StringBuilder sb = new StringBuilder();
        int x = s1Size-1;
        int y = s2Size-1;
        while (dp[x][y] != 0) {
            // 왼쪽으로 움직인다.
            if (dp[x][y] == dp[x-1][y]) --x;
            // 위로 움직인다.
            else if (dp[x][y] == dp[x][y-1]) --y;
            // 대각선으로 움직인다.
            else if (s1.charAt(x) == s2.charAt(y)) { sb.append(s1.charAt(x)); --x; --y; }
        }

        System.out.println(dp[s1Size -1][s2Size -1]);
        System.out.println(sb.reverse());
    }
}
