package 문자열지옥에빠진호석;

import java.io.*;
import java.util.*;

import org.junit.jupiter.api.Test;

class Main {

    static int N, M, K;
    static String[] map;

    static int[] dx = {0, 1, 1, 1, 0, -1, -1, -1};
    static int[] dy = {-1, -1, 0, 1, 1, 1, 0, -1};

    static Map<String, Integer> counter = new HashMap<>();

    static InputReader r;

    @Test
    public static void main(String[] args) throws IOException {
        input();
        solution();
    }

    private static void solution() throws IOException {
        // TODO
        // 뭘로 시작하는지가 중요하다.
        // 한번 반복으로 모든 경우를 찾으면 좋겠다.

        // 완탐이 가능할까?
        // 최악의 경우: N = 10, M = 10, String = aaa_aaa_aaa_a
        // 100 * 8 * 8 * 8 * 8 * 8


        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                dfs(1, i, j, Character.toString(map[i].charAt(j)));
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < K; i++) {
            sb.append(counter.getOrDefault(r.nextLine(), 0)).append('\n');
        }
        System.out.println(sb);
    }

    private static void dfs(int cur, int y, int x, String s) {
        counter.put(s, counter.getOrDefault(s, 0) + 1);

        if (cur == 5) return;

        for (int i = 0; i < 8; i++) {
            int nx = getNext(x + dx[i], M);
            int ny = getNext(y + dy[i], N);
            dfs(cur + 1, ny, nx, s + map[ny].charAt(nx));
        }
    }

    private static int getNext(int xy, int limit) {
        if (xy == limit) return 0;
        else if (xy == -1) return limit - 1;
        else return xy;
    }

    private static void input() throws IOException {
        r = new InputReader("C:\\Users\\workspace\\boj\\src\\test\\java\\문자열지옥에빠진호석\\input.txt");
        N = r.nextInt();
        M = r.nextInt();
        K = r.nextInt();
        map = new String[N];
        for (int i = 0; i < N; i++) map[i] = r.nextLine();
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

        public String nextLine() throws IOException {
            return r.readLine();
        }
    }


}

