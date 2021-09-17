package 특정거리의도시찾기_18352;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

import org.junit.jupiter.api.Test;

class Main {

    static int[] dp;
    static List[] node;
    static int K;

    @Test
    public static void main(String[] args) throws IOException {
        BufferedReader r = new BufferedReader(new FileReader("C:\\Users\\prayme\\workspace\\boj\\src\\test\\java\\특정거리의도시찾기_18352\\input.txt"));

        StringTokenizer st = new StringTokenizer(r.readLine());
        int N = parse(st.nextToken());
        int M = parse(st.nextToken());
        K = parse(st.nextToken());
        int start = parse(st.nextToken());

        dp = new int[N + 1];
        Arrays.fill(dp, 300_001);

        node = new List[N + 1];
        for (int i = 0; i <= N; i++) {
            node[i] = new ArrayList<Integer>();
        }

        for (int m = 0; m < M; m++) {
            st = new StringTokenizer(r.readLine());
            int from = parse(st.nextToken());
            int to = parse(st.nextToken());
            node[from].add(to);
        }

        dfs(start, 0);

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= N; i++) {
            if (dp[i] == K) {
                sb.append(String.format("%d\n", i));
            }
        }

        String answer = sb.toString();
        if (answer.equals("")) {
            System.out.println(-1);
        } else {
            System.out.println(answer);
        }
    }

    static void dfs(int from, int count) {
        if (count > K) return;
        if (dp[from] != 300_001) return;
        dp[from] = count;

        List<Integer> to = node[from];
        for (int i = 0; i < to.size(); i++) {
            dfs(to.get(i), count + 1);
        }
    }

    static int parse(String s) {
        return Integer.parseInt(s);
    }
}

