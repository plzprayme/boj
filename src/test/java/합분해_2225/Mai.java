package 합분해_2225;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

import org.junit.jupiter.api.Test;

class Mai {
    @Test
    public static void main(String[] args) throws IOException {
        BufferedReader r = new BufferedReader(new FileReader("C:\\Users\\prayme\\workspace\\boj\\src\\test\\java\\합분해_2225\\input.txt"));
        BufferedWriter w = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(r.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[][] dp = new int[K+1][N+1];
        Arrays.fill(dp[1], 1);

        for (int i = 1; i <= K; i++) {
            dp[i][0] = 1;
        }



        for (int k = 2; k <= K; k++) {
            for (int n = 1; n <= N; n++) {
                dp[k][n] = (dp[k - 1][n] + dp[k][n - 1]) % 1_000_000_000;
            }
        }

        System.out.println(dp[K][N]);
    }


}
