package N과M3_15651;

import java.io.*;
import java.util.*;

import org.junit.jupiter.api.Test;

class N과M3 {

    static int N, M;
    static int[] selected;
    static boolean[] visited;

    private static void solution() {
        // 백트래킹
        permutation(1);
    }

    private static void permutation(int m) {
        // N만큼 반복도 해야되고
        // M만큼 반복도 해야된다

        // O(N ^ M)
        // O(sizeOf(int) * M)



        if (m == M + 1) {
            StringBuilder sb = new StringBuilder();
            for (int i = 1; i <= M; i++) sb.append(selected[i]).append(' ');
            System.out.println(sb);
        } else {

            for (int i = 1; i <= N; i++) {
                if (visited[i]) continue;

                // 방문하지 않았다.
                selected[m] = i;
                visited[i] = true;
                permutation(m + 1);
                visited[i] = false;
            }

        }

    }

    private static void input() throws IOException {
        BufferedReader r = new BufferedReader(new FileReader("C:\\Users\\prayme\\workspace\\boj\\src\\test\\java\\N과M3_15651\\input.txt"));

        StringTokenizer st = new StringTokenizer(r.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        selected = new int[M + 1];
        visited = new boolean[N + 1];
    }

    @Test
    public static void main(String[] args) throws IOException {
        input();
        solution();
    }

}

