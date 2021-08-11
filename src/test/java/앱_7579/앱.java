package 앱_7579;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

import org.junit.jupiter.api.Test;

public class 앱 {
    @Test
    public static void main(String[] args) throws IOException {
        BufferedReader r = new BufferedReader(
            new FileReader("C:\\Users\\prayme\\workspace\\boj\\src\\test\\java\\앱_7579\\input.txt"));
        BufferedWriter w = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(r.readLine());
        int N = parse(st.nextToken());
        int M = parse(st.nextToken());
        int answer = Integer.MAX_VALUE;

        int[] memories = new int[N];
        int[] costs = new int[N];
        int[] dp = new int[10_001];

        StringTokenizer mem = new StringTokenizer(r.readLine());
        StringTokenizer co = new StringTokenizer(r.readLine());
        for (int i = 0; i < N; i++) {
            memories[i] = parse(mem.nextToken());
            costs[i] = parse(co.nextToken());
        }

        for (int i = 0; i < N; i++) {
            int memory = memories[i];
            int cost = costs[i];

            for (int j = 10_000; j >= cost; j--) {
                dp[j] = Math.max(dp[j - cost] + memory, dp[j]);
            }
        }

        for (int i = 0; i <= 10_000; i++) {
            if (dp[i] >= M) {
                System.out.println(i);
                break;
            }
        }

    }

    private static int parse(String s) {
        return Integer.parseInt(s);
    }
}
