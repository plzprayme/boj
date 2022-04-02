package 쇼미더코드.숫자이어붙이기;

import java.io.*;
import java.math.BigDecimal;
import java.util.*;

import org.junit.jupiter.api.Test;

class Main {

    static int N, Q;
    static int[] graph;

    static List<Integer>[] child;
    static Play[] play;

    static BigDecimal WEIGHT = BigDecimal.valueOf(1_000_000_007);

    static StringBuilder sb = new StringBuilder();

    static List<Integer>[][] cache;

    static class Play {
        int src, dst;

        public Play(int src, int dst) {
            this.src = src;
            this.dst = dst;
        }
    }

    @Test
    public static void main(String[] args) throws IOException {
        input();
        solution();
    }

    private static void solution() {
        // 1과 2를 붙이면 12가 된다.
        // 17과 13을 붙이면 1713이 된다.

        // 100과 1000을 붙이면 1001000이;된다.

        // 이어 붙이는 순서에 따라서 값이 달라진다.
        // 두 집 사이에 존재하는 도로를 통해 서로 이동할 수 있다.
        // 총 N - 1개의 도로가 존재한다. (그래프?)
        // 두번 방문 안하면 경로가 유일하다.

        // Q번 수를 이어 붙이는 놀이

        for (Play p : play) {
            dfs(0, p.src, p.src, p.dst, String.valueOf(graph[p.src]));
        }

        System.out.println(sb);

    }

    static void dfs(int pre, int src, int now, int dst, String answer) {
        if (now == dst) {
            sb.append(new BigDecimal(answer).remainder(WEIGHT)).append('\n');
            return;
        }

        for (Integer next : child[now]) {
            if (pre == next) continue;

            if (!cache[next][dst].isEmpty()) {
                StringBuilder d = new StringBuilder();
                for (Integer i : cache[next][dst]) {
                    d.append(i);
                }

                sb.append(new BigDecimal(answer + d).remainder(WEIGHT)).append('\n');
                return;
            }

            cache[src][next].addAll(cache[src][now]);
            cache[src][next].add(graph[next]);

            cache[next][src].addAll(cache[src][now]);
            cache[next][src].add(graph[next]);
            Collections.reverse(cache[next][src]);
            dfs(now, src, next, dst, answer + graph[next]);
        }

    }

    private static void input() throws IOException {
        InputReader r = new InputReader("C:\\Users\\workspace\\boj\\src\\test\\java\\쇼미더코드\\숫자이어붙이기\\input.txt");
        N = r.nextInt();
        Q = r.nextInt();

        graph = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            graph[i] = r.nextInt();
        }

        // 놀이를 시작할 집의 번호와 끝낼 집의 번호
        child = new List[N + 1];
        for (int i = 1; i<= N;i++) {
            child[i] =new ArrayList<>();
        }

        for (int i = 1; i < N; i++) {
            int src = r.nextInt();
            int dst = r.nextInt();
            child[src].add(dst);
            child[dst].add(src);
        }


        play = new Play[Q];
        for (int i = 0; i < Q; i++) {
            play[i] = new Play(r.nextInt(), r.nextInt());
        }

        cache = new List[N + 1][N + 1];
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                cache[i][j] = new ArrayList<>();
            }
        }
    }

    private static class InputReader {
        StringTokenizer st;
        BufferedReader r;

        public InputReader(String filePath) throws FileNotFoundException {
            this(new FileReader(filePath));
        }

        public InputReader() {
            this(new InputStreamReader(System.in));
        }

        private InputReader(InputStreamReader reader) {
            r = new BufferedReader(reader);
            st = new StringTokenizer("");
        }

        public int nextInt() throws IOException {
            if (!st.hasMoreTokens()) st = new StringTokenizer(r.readLine());
            return Integer.parseInt(st.nextToken());
        }

        public char[] nextCharArr() throws IOException {
            return r.readLine().toCharArray();
        }
    }


}

