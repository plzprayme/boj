package 현명한나이트_18404;

import java.io.*;
import java.util.*;

import org.junit.jupiter.api.Test;

class Main {
    static int N, M;
    static int[][] map;
    static boolean[][] visit;
    static int Y, X;

    static int[] dx = {1, 2, 2, 1, -1, -2, -2, -1};
    static int[] dy = {-2, -1, 1, 2, 2, 1, -1, -2};

    static Queue<Integer> enemy = new LinkedList<>();

    private static void solution() {
        bfs();

        StringBuilder sb = new StringBuilder();
        while (!enemy.isEmpty())
            sb.append(map[enemy.poll()][enemy.poll()]).append(' ');
        System.out.println(sb);
    }

    private static void bfs() {
        int count = M;

        Queue<Integer> q = new LinkedList<>();
        q.add(X); q.add(Y); q.add(0);
        visit[Y][X] = true;

        while (!q.isEmpty()) {
            int x = q.poll();
            int y = q.poll();
            int C = q.poll();

            for (int i = 0; i < 8; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                int nc = C + 1;

                if (isOut(nx, ny) || visit[ny][nx]) continue;
                map[ny][nx] = nc;
                if (map[ny][nx] == -1) count--;
                if (count == 0) return;
                visit[ny][nx] = true;
                q.add(nx); q.add(ny); q.add(nc);
            }
        }
    }

    private static boolean isOut(int x, int y) {
        return check(x, N) || check(y, N);
    }

    private static boolean check(int p, int l) {
        return p < 1 || p > l;
    }

    private static void input() throws IOException {
        InputReader r = new InputReader("C:\\Users\\prayme\\workspace\\boj\\src\\test\\java\\현명한나이트_18404\\input.txt");
        N = r.nextInt(); M = r.nextInt();
        map = new int[N + 1][N + 1]; visit = new boolean[N + 1][N + 1];

        Y = r.nextInt(); X = r.nextInt();

        for (int i = 0; i < M; i++) {
            int y = r.nextInt();
            int x = r.nextInt();
            enemy.add(y); enemy.add(x);
            map[y][x] = -1;
        }
    }

    @Test
    public static void main(String[] args) throws IOException {
        input();
        solution();
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

