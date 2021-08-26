package 해킹_10282;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;
import java.util.StringTokenizer;

import javax.swing.plaf.nimbus.State;

import org.junit.jupiter.api.Test;

public class 해킹 {
    private static int COM_SIZE = 10_001;
    private static int[] dp = new int[COM_SIZE];
    private static int[][] time = new int[COM_SIZE][COM_SIZE];
    private static Map<Integer, Stack<Integer>> dependencies = new HashMap<>();
    private static int count = 0;

    @Test
    public static void main(String[] args) throws IOException {
        BufferedReader r = new BufferedReader(new FileReader("C:\\Users\\prayme\\workspace\\boj\\src\\test\\java\\해킹_10282\\input.txt"));
        BufferedWriter w = new BufferedWriter(new OutputStreamWriter(System.out));

        int K = parse(r.readLine());
        for (int i = 0; i < K; i++) {
            StringTokenizer st = new StringTokenizer(r.readLine());
            int com = parse(st.nextToken());
            int N = parse(st.nextToken());
            int start = parse(st.nextToken());

            dp = new int[COM_SIZE];
            Arrays.fill(dp, 999_999);
            dp[start] = 0;

            dependencies = new HashMap<>();
            for (int j = 1; j <= com; j++) {
                dependencies.put(j, new Stack<>());
            }

            time = new int[COM_SIZE][COM_SIZE];
            for (int j = 0; j < N; j++) {
                st = new StringTokenizer(r.readLine());
                int from = parse(st.nextToken());
                int to = parse(st.nextToken());
                int t = parse(st.nextToken());
                time[from][to] = t;
                dependencies.get(to).add(from);
            }

            dfs(start, 0);

            int count = 0;
            int time = 0;
            for (int j = 1; j <= com; j++) {
                if (dp[j] != 999_999) {
                    count++;
                    time = Math.max(time, dp[j]);
                }
            }

            w.write(String.format("%d %d\n", count, time));
        }
    }

    private static void dfs(int to, int currentTime) {
        dp[to] = Math.min(dp[to], currentTime);

        Stack<Integer> froms = dependencies.get(to);
        while (!froms.isEmpty()) {
            int from = froms.pop();
            dfs(from, time[from][to] + currentTime);
        }

    }

    private static int parse(String s) {
        return Integer.parseInt(s);
    }
}
