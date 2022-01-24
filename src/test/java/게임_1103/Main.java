package 게임_1103;

import java.io.*;
import java.util.*;

import org.junit.jupiter.api.Test;

class Main {

    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {-1, 0, 1, 0};

    static int N, M;
    static int[][] map;
    static int[][] dist;
    static boolean[][] visit;

    static boolean cycle;

    @Test
    public static void main(String[] args) throws IOException {
        input();
        solution();
    }

    private static void solution() {
        // 내가 착각한 점: 현재의 숫자와 다음의 숫자가 같을 때만 싸이클이 생길 것으로 예상
        // 무한번 움직이는 것은 싸이클이 있는 그래프를 의미한다.

        // 무한루프 케이스

        // 3 4
        // 3 H H 2
        // H H H H
        // 2 H H 3

        visit[1][1] = true;
        dfs(1, 1, 1);

        if (cycle) {
            System.out.println(-1);
        } else {
            int answer = 0;
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= M; j++) {
                    answer = Math.max(dist[i][j], answer);
                }
            }
            System.out.println(answer);
        }
    }

    private static void dfs(int x, int y, int step) {
        // DFS 내부에서 VISIT을 조작하지 말자.
        // DFS 내부에서는 함수를 종료하는 조건이 너무 많다.
        if (cycle) return;
        dist[y][x] = step;

        for (int d = 0; d < 4; d++) {
            int nx = x + dx[d] * map[y][x];
            int ny = y + dy[d] * map[y][x];
            int ns = step + 1;

            if (nx < 1 || nx > M || ny < 1 || ny > N) continue;
            if (visit[ny][nx]) {
                cycle = true;
                return;
            }
            if (dist[ny][nx] >= ns) continue;
            if (map[ny][nx] == 0) continue;
            visit[ny][nx] = true;
            dfs(nx, ny, ns);
            visit[ny][nx] = false;
        }

    }

    private static void input() throws IOException {
        InputReader r = new InputReader("C:\\Users\\workspace\\boj\\src\\test\\java\\게임_1103\\input.txt");
        N = r.nextInt();
        M = r.nextInt();

        map = new int[N + 1][M + 1];
        for (int i = 1; i <= N; i++) {
            char[] arr = r.nextCharArr();
            for (int j = 1; j <= M; j++) {
                int next;
                if (arr[j - 1] == 'H') next = 0;
                else next = arr[j- 1] - '0';
                map[i][j] = next;
            }
        }

        dist = new int[N + 1][M + 1];
        visit = new boolean[N + 1][M + 1];
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

