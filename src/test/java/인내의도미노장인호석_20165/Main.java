package 인내의도미노장인호석_20165;

import java.io.*;
import java.util.*;

import org.junit.jupiter.api.Test;

class Main {

    static InputReader r;

    static int N, M, R;
    static int[][] map;
    static int[][] clone;

    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {-1, 0, 1, 0};

    static int score = 0;

    @Test
    public static void main(String[] args) throws IOException {
        input();
        solution();
    }

    private static void solution() throws IOException {
        // 공격수는 도미노를 넘어뜨린다. 수비수는 도미노를 세우려고 한다.

        // N * M 2차원 격자 게임판에 도미노를 세운다.
        // 도미노는 1이상 5 이하의 높이
        // 도미노를 동서남북 중 원하는 방향으로 넘어뜨린다.

        for (int i = 0; i < R; i++) {
            attackDomino(r.nextInt(), r.nextInt(), getDirection(r.nextChar()));
            healDomino(r.nextInt(), r.nextInt());
        }

        System.out.println(getAnswer());
    }

    private static StringBuilder getAnswer() {
        StringBuilder sb = new StringBuilder();
        sb.append(score).append('\n');
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                if (clone[i][j] == 0) sb.append('F');
                else sb.append('S');
                sb.append(' ');
            }
            sb.append('\n');
        }
        return sb;
    }

    private static void attackDomino(int y, int x, int d) {
        int nx = x;
        int ny = y;
        for (int h = clone[y][x]; h > 0; h--) {
            if (nx < 0 || nx > M || ny < 0 || ny > N) continue;
            h = Math.max(h, clone[ny][nx]);
            if (clone[ny][nx] > 0) {
                score++;
                clone[ny][nx] = 0;
            }
            nx += dx[d];
            ny += dy[d];
        }
    }

    private static void healDomino(int y, int x) {
        clone[y][x] = map[y][x];
    }


    private static int getDirection(char d) {
        switch (d) {
            case 'N':
                return 0;
            case 'E':
                return 1;
            case 'S':
                return 2;
            case 'W':
                return 3;
            default:
                return -1;
        }
    }

    private static void input() throws IOException {
        r = new InputReader("C:\\Users\\workspace\\boj\\src\\test\\java\\인내의도미노장인호석_20165\\input.txt");
        N = r.nextInt();
        M = r.nextInt();
        R = r.nextInt();

        clone = new int[N + 1][M + 1];
        map = new int[N + 1][M + 1];
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                map[i][j] = r.nextInt();
                clone[i][j] = map[i][j];
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

        public char nextChar() throws IOException {
            return st.nextToken().charAt(0);
        }

        public char[] nextCharArr() throws IOException {
            return r.readLine().toCharArray();
        }
    }


}

