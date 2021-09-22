package N과M2_15650;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

import org.junit.jupiter.api.Test;

class N과M2 {
    static int N, M;
    static int[] selected;
    static boolean[] visited;
    static StringBuilder sb = new StringBuilder();

    @Test
    public static void main(String[] args) throws IOException {
        BufferedReader r = new BufferedReader(new FileReader("C:\\Users\\prayme\\workspace\\boj\\src\\test\\java\\N과M2_15650\\input.txt"));

        StringTokenizer st = new StringTokenizer(r.readLine());
        N = parse(st.nextToken());
        M = parse(st.nextToken());
        selected = new int[M + 1];
        visited = new boolean[N + 1];

        rec(1, 1);

        System.out.println(sb.toString());
    }

    static int parse(String s) {
        return Integer.parseInt(s);
    }

    static void rec(int n, int m) {
        if (m == M + 1) {
            for (int i = 1; i <= M; i++) {
                sb.append(selected[i]).append(' ');
            }
            sb.append('\n');
        } else {
            for (int i = n; i <= N; i++) {
                if (!visited[i]) {
                    visited[i] = true;
                    selected[m] = i;
                    rec(i, m + 1);
                    visited[i] = false;
                }
            }
        }
    }
}
