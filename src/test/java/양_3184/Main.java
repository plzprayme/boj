package 양_3184;

import java.io.*;
import java.util.*;

import org.junit.jupiter.api.Test;

class Main {
    static int X, Y;
    static char[][] map;
    static boolean[][] visit;
    static int answerWolf = 0, answerSheep = 0;
    static int areaWolf = 0, areaSheep = 0;

    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {-1, 0, 1, 0};

    static final char WOLF = 'v';
    static final char SHEEP = 'o';
    static final char WALL = '#';
    static final char EMPTY = '.';

    private static void solution() {
        for (int y = 0; y < Y; y++) {
            for (int x = 0; x < X; x++) {
                if (visit[y][x] || isWall(x, y) || isEmpty(x, y))
                    continue;
                areaWolf = 0;
                areaSheep = 0;

                // dfs(x, y);
                bfs(x, y);

                if (areaWolf >= areaSheep)
                    answerWolf += areaWolf;
                else
                    answerSheep += areaSheep;
            }
        }

        System.out.printf("%d %d", answerSheep, answerWolf);
    }

    private static void dfs(int x, int y) {
        visit[y][x] = true;
        if (map[y][x] == WOLF)
            areaWolf++;
        if (map[y][x] == SHEEP)
            areaSheep++;

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (isOut(nx, ny) || visit[ny][nx] || isWall(nx, ny))
                continue;
            dfs(nx, ny);
        }
    }

    private static void bfs(int x, int y) {
        Stack<XY> stack = new Stack<>();
        stack.add(new XY(x, y));
        visit[y][x] = true;


        while (!stack.isEmpty()) {
            XY now = stack.pop();
            if (map[now.y][now.x] == WOLF) areaWolf++;
            if (map[now.y][now.x] == SHEEP) areaSheep++;

            for (int i = 0; i < 4; i++) {
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];

                if (isOut(nx, ny) || visit[ny][nx] || isWall(nx, ny)) continue;
                stack.add(new XY(nx, ny));
                visit[ny][nx] = true;
            }
        }
    }

    private static class XY {
        int x, y;

        public XY(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    private static boolean isWall(int x, int y) {
        return is(x, y, WALL);
    }

    private static boolean isEmpty(int x, int y) {
        return is(x, y, EMPTY);
    }

    private static boolean is(int x, int y, char c) {
        return map[y][x] == c;
    }

    private static boolean isOut(int x, int y) {
        return x < 0 || y < 0 || x > X - 1 || y > Y - 1;
    }

    private static void input() throws IOException {
        InputReader r = new InputReader("C:\\Users\\prayme\\workspace\\boj\\src\\test\\java\\양_3184\\input.txt");
        r.tokenizeLine();
        Y = r.nextInt();
        X = r.nextInt();
        map = new char[Y][X];
        visit = new boolean[Y][X];

        for (int y = 0; y < Y; y++) {
            map[y] = r.readCharArr();
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
        }

        public void tokenizeLine() throws IOException {
            st = new StringTokenizer(r.readLine());
        }

        public int nextInt() {
            return Integer.parseInt(st.nextToken());
        }

        public char[] readCharArr() throws IOException {
            return r.readLine().toCharArray();
        }

    }

}

