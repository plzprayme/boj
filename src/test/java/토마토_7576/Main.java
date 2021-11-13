package 토마토_7576;

import java.io.*;
import java.util.*;

import javax.swing.text.Position;

import org.junit.jupiter.api.Test;

class Main {

    static boolean already = true;
    static int X, Y;
    static int[][] map;
    static boolean[][] visit;
    static Stack<Position> stack = new Stack<>();

    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {-1, 0, 1, 0};

    private static void solution() {
        if (already) {
            System.out.println(0);
            return;
        }

        int count = -1;
        while (!stack.isEmpty()) {

            Position[] tomato = new Position[stack.size()];
            for (int i = 0; i < tomato.length; i++) tomato[i] = stack.pop();
            for (Position t : tomato) {
                if (Objects.isNull(t)) break;
                visit[t.y][t.x] = true;
                bfs(t);
            }
            count++;
        }

        for (int[] row : map) {
            for (int col : row) {
                if (col == 0) {
                    System.out.println(-1);
                    return;
                }
            }
        }

        System.out.println(count);
    }


    private static void bfs(Position now) {
        for (int i = 0; i < 4; i++) {
            int nx = now.x + dx[i];
            int ny = now.y + dy[i];
            if (isOut(nx, ny) || visit[ny][nx] || map[ny][nx] == -1) continue;
            map[ny][nx] = 1;
            visit[ny][nx] = true;
            stack.add(new Position(nx, ny));
        }

    }

    private static boolean isOut(int x, int y) {
        return out(x, X) || out(y, Y);
    }

    private static boolean out(int p, int limit) {
        return p < 0 || p > limit - 1;
    }

    private static void input() throws IOException {
        InputReader r = new InputReader("C:\\Users\\prayme\\workspace\\boj\\src\\test\\java\\토마토_7576\\input.txt");
        X = r.nextInt(); Y = r.nextInt();
        map = new int[Y][X];
        visit = new boolean[Y][X];

        for (int y = 0; y < Y; y++) {
            for (int x = 0; x < X; x++) {
                int num = r.nextInt();
                if (already && num == 0) already = false;
                if (num == 1) stack.add(new Position(x, y));
                map[y][x] = num;
            }
        }

    }

    private static class Position {
        int x, y;

        public Position(int x, int y) {
            this.x = x;
            this.y = y;
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

