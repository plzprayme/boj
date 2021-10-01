package 선수과목_14567;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

import org.junit.jupiter.api.Test;

public class 선수과목 {

    static List<Integer>[] subjects;
    static boolean[] visited;
    static int[] dp;
    static StringBuilder sb = new StringBuilder();

    @Test
    public static void main(String[] args) throws IOException {
        BufferedReader r = new BufferedReader(new FileReader("C:\\Users\\prayme\\workspace\\boj\\src\\test\\java\\선수과목_14567\\input.txt"));

        StringTokenizer st = new StringTokenizer(r.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        dp = new int[N + 1];
        Arrays.fill(dp, 1);
        visited = new boolean[N + 1];
        subjects = new List[N + 1];
        for (int i = 1; i <= N; i++) {
            subjects[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(r.readLine());
            int left = Integer.parseInt(st.nextToken());
            int right = Integer.parseInt(st.nextToken());
            subjects[right].add(left);
        }

        for (int i = N; i > 0; i--) dfs(i);

        for (int i = 1; i <= N; i++) {
            sb.append(dp[i]).append(' ');
        }

        System.out.println(sb);
    }

    static int dfs(int i) {
        if (visited[i]) return dp[i] + 1;
        if (subjects[i].isEmpty()) {
            visited[i] = true;
            return dp[i] + 1;
        }

        List<Integer> child = subjects[i];
        int max = 0;
        for (int c : child) {
            max = Math.max(dfs(c), max);
            visited[c] = true;
        }
        visited[i] = true;
        dp[i] = max;
        return max + 1;
    }
}
