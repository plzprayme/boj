package 운동_1956;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.StringTokenizer;

import org.junit.jupiter.api.Test;

public class 운동 {
    @Test
    public static void main(String[] args) throws IOException {
        BufferedReader r = new BufferedReader(new FileReader("C:\\Users\\prayme\\workspace\\boj\\src\\test\\java\\운동_1956\\input.txt"));

        StringTokenizer st = new StringTokenizer(r.readLine());
        int V = parse(st.nextToken());
        int E = parse(st.nextToken());

        int max = 10001;
        int[][] dp = new int[V+1][V+1];
        for (int[] arr : dp) {
            Arrays.fill(arr, max);
        }
        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(r.readLine());
            int from = parse(st.nextToken());
            int to = parse(st.nextToken());
            int distance = parse(st.nextToken());

            dp[from][to] = distance;
        }

        for (int middle = 1; middle <= V; middle++) {
            for (int from = 1; from <= V; from++) {
                for (int to = 1; to <= V; to++) {
                    if (dp[from][middle] < max && dp[middle][to] < max && dp[from][middle] + dp[middle][to] < dp[from][to]) {
                        dp[from][to] = dp[from][middle] + dp[middle][to];
                    }
                }
            }
        }

        int answer = max;
        for (int i = 1; i <= V; i++) {
            answer = Math.min(dp[i][i], answer);
        }

        if (answer == max)
            System.out.println("-1");
        else
            System.out.println(answer);
    }

    private static int parse(String s) {
        return Integer.parseInt(s);
    }
}
