package 특정거리의도시찾기_18352;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
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
        dp[start] = 0;

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

        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        while (!q.isEmpty()) {
            int now = q.poll();

            List<Integer> to = node[now];
            for (int i = 0; i < to.size(); i++) {
                int next = to.get(i);

                if (dp[next] == 300_001) {
                    dp[next] = dp[now] + 1;
                    q.offer(next);
                }
            }

        }

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



    static int parse(String s) {
        return Integer.parseInt(s);
    }
}

