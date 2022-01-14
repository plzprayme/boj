package 문자열지옥에빠진호석;

import java.io.*;
import java.util.*;

import org.junit.jupiter.api.Test;

class Main {

    static int N, M, K;
    static String[] map;

    static int[] dx = {0, 1, 1, 1, 0, -1, -1, -1};
    static int[] dy = {-1, -1, 0, 1, 1, 1, 0, -1};

    static Set<String> like = new HashSet<>();

    static InputReader r;

    static int count;

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

        StringBuilder sb = new StringBuilder();
        for (int k = 0; k < K; k++) {
            count = 0;
            String s = r.nextLine();
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    dfs(0, i, j, s);
                }
            }
            sb.append(count).append('\n');
        }
        System.out.println(sb);
    }

    private static void dfs(int cur, int y, int x, String s) {
        if (cur == s.length()) {
            count++;
            return;
        }
        if (map[y].charAt(x) != s.charAt(cur)) return;

        for (int i = 0; i < 8; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx == -1 && ny == -1) { // 왼쪽 위
                nx = M - 1;
                ny = N - 1;

            } else if(nx == M && ny == -1) { // 오른 위
                nx = 0;
                ny = N - 1;
            } else if (nx == -1 && ny == N) { // 왼 아래
                nx = M - 1;
                ny = 0;
            } else if (nx == M && ny == N) { // 오른쪽 아래
                nx = 0;
                ny = 0;
            } else if (nx == -1) { //
                nx = M - 1;
            } else if (nx == M) {
                nx = 0;
            } else if (ny == -1) {
                ny = N - 1;
            } else if (ny == N) {
                ny = 0;
            }


            dfs(cur + 1, ny, nx, s);
        }
    }

    private static void input() throws IOException {
        r = new InputReader("C:\\Users\\workspace\\boj\\src\\test\\java\\문자열지옥에빠진호석\\input.txt");
        N = r.nextInt(); M = r.nextInt(); K = r.nextInt();
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

