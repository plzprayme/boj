package 동전_9084;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

import org.junit.jupiter.api.Test;

class Main {
    @Test
    public static void main(String[] args) throws IOException {
        BufferedReader r = new BufferedReader(new FileReader("C:\\Users\\prayme\\workspace\\boj\\src\\test\\java\\동전_9084\\input.txt"));
        BufferedWriter w = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = parse(r.readLine());
        for (int t = 0; t < T; t++) {

            int N = parse(r.readLine());
            int[] coin = new int[N];
            StringTokenizer st = new StringTokenizer(r.readLine());
            for (int n = 0; n < N; n++) {
                coin[n] = parse(st.nextToken());
            }

            int M = parse(r.readLine());
            int[] dp = new int[M+1];

            dp[0] = 1;
            for (int c : coin) {
                for (int i = c; i <= M; i++) {
                    dp[i] += dp[i - c];
                }
            }

            System.out.println(dp[M]);
        }
    }

    private static int parse(String s) {
        return Integer.parseInt(s);
    }
}
