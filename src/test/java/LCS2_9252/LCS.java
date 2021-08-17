package LCS2_9252;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;
import java.util.StringTokenizer;

import org.junit.jupiter.api.Test;

public class LCS {
    @Test
    public void 오잉() throws IOException {
        // BufferedReader r = new BufferedReader(new FileReader("C:\\Users\\prayme\\workspace\\boj\\src\\test\\java\\LCS2_9252\\input.txt"));
        BufferedWriter w = new BufferedWriter(new OutputStreamWriter(System.out));

        Scanner sc = new Scanner(System.in);

        // String s1 = r.readLine();
        // String s2 = r.readLine();
        String s1 = sc.nextLine();
        String s2 = sc.nextLine();

        int[][] dp = new int[s1.length()][s2.length()];
        for (int i = 0; i < s1.length(); i++) {

            for (int j = 0; j < s2.length(); j++) {
                // 같은 문자일 때
                if (s1.charAt(i) == s2.charAt(j)) {
                    // 같은 문자이면서 1보다 긴 순열일 때
                    if (i > 0 && j > 0) dp[i][j] = dp[i-1][j-1] + 1;
                    // Row나 Col 순열의 크기가 1일 때
                    else dp[i][j] = 1;
                }
                // 같은 문자가 아닐 때
                else {
                    if (i > 0 && j > 0) dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                    else if (i > 0) dp[i][j] = dp[i-1][j];
                    else dp[i][j] = dp[i][j-1];
                }
            }

        }

        System.out.println(dp[s1.length()-1][s2.length()-1]);
    }
}
