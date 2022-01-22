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

    @Test
    public static void main(String[] args) throws IOException {
        input();
        solution();
    }

    private static void solution() {
        // 동전이 있는 곳에 쓰여 있는 숫자 X를 본다.
        // 위, 아래, 왼쪽, 오른쪽 방향 중에 한 가지를 고른다.
        // 동전을 위에서 고른 방향으로 X만큼 움직인다. 이때, 중간에 있는 구멍은 무시한다.

        System.out.println(bfs());
    }

    private static int bfs() {
        Stack<XY> stack = new Stack<>();
        stack.add(new XY(1, 1, 0));

        while (!stack.isEmpty()) {
            XY now = stack.pop();
            dist[now.y][now.x] = now.s;

            for (int d = 0; d < 4; d++) {
                int nx = now.x + dx[d] * map[now.y][now.x];
                int ny = now.y + dy[d] * map[now.y][now.x];
                int ns = now.s + 1;

                if (nx < 1 || nx > M || ny < 1 || ny > N) {
                    dist[now.y][now.x] = ns;
                    continue;
                }
                if (map[now.y][now.x] == map[ny][nx]) return -1;
                if (dist[ny][nx] >= ns) continue;
                if (map[ny][nx] == 0) {
                    dist[ny][nx] = ns;
                    continue;
                }
                stack.add(new XY(nx,ny, ns));
            }

        }

        int answer = 0;
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                answer = Math.max(dist[i][j], answer);
            }
        }
        return answer;
    }

    static class XY {
        int x, y, s;

        public XY(int x, int y, int s) {
            this.x = x;
            this.y = y;
            this.s = s;
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

