package LCS_9251;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

import org.junit.jupiter.api.Test;

class Main {
    @Test
    public static void main(String[] args) throws IOException {
        BufferedReader r = new BufferedReader(new FileReader("C:\\Users\\prayme\\workspace\\boj\\src\\test\\java\\LCS_9251\\input.txt"));

        char[] s1 = (" " + r.readLine()).toCharArray();
        char[] s2 = (" " + r.readLine()).toCharArray();
        int[][] dp = new int[s1.length][s1.length];

        for (int i1 = 1; i1 < dp.length; i1++) {
            for (int i2 = 1; i2 < dp.length; i2++) {
                dp[i1][i2] = s1[i1] == s2[i2] ? dp[i1-1][i2-1] + 1 : Math.max(dp[i1 - 1][i2], dp[i1][i2-1]);
            }
        }

        System.out.println(dp[s1.length-1][s2.length-1]);
    }
}
