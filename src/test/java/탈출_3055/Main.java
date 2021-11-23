package 탈출_3055;

import java.io.*;
import java.util.*;

import org.junit.jupiter.api.Test;

class Main {

    static int R, C;
    static String[] map;
    static Queue<Coordinate> queue = new LinkedList<>();
    static Coordinate hog;

    static int[][] waterDist;

    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {-1, 0, 1, 0};

    static final char WATER = '*';
    static final char CAVE = 'D';
    static final char ROCK = 'X';
    static final char HOG = 'S';

    private static void solution() {
        waterBfs();
        int answer = hogBfs();
        if (answer == -1) {
            System.out.println("KAKTUS");
            return;
        }
        System.out.println(answer);
    }

    private static int hogBfs() {
        queue.add(hog);

        while (!queue.isEmpty()) {
            Coordinate cur = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];
                int nc = cur.c + 1;

                if (isOut(nx, ny) || isRock(nx, ny)) continue;

                if (isCave(nx,ny)) return nc;

                if (waterDist[ny][nx] > nc) {
                    queue.add(new Coordinate(nx, ny, nc));
                }
            }
        }

        return -1;
    }

    private static void waterBfs() {
        while (!queue.isEmpty()) {
            Coordinate cur = queue.poll();
            waterDist[cur.y][cur.x] = Math.min(waterDist[cur.y][cur.x], cur.c);

            for (int i = 0; i < 4; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];
                int nc = cur.c + 1;

                if (isOut(nx, ny) || isRock(nx, ny) || isCave(nx, ny)) continue;

                if (waterDist[ny][nx] > nc) {
                    queue.add(new Coordinate(nx, ny, nc));
                }
            }
        }

    }

    private static boolean isOut(int x, int y) {
        return check(x, C) || check(y, R);
    }

    private static boolean check(int p, int l) {
        return p < 0 || p > l - 1;
    }

    private static class Coordinate {
        int x, y, c;

        public Coordinate(int x, int y, int c) {
            this.x = x;
            this.y = y;
            this.c = c;
        }
    }

    private static void input() throws IOException {
        InputReader r = new InputReader("C:\\Users\\prayme\\workspace\\boj\\src\\test\\java\\탈출_3055\\input.txt");

        R = r.nextInt();
        C = r.nextInt();
        map= new String[R];

        waterDist = new int[R][C];
        for (int[] i :waterDist) {
            Arrays.fill(i, Integer.MAX_VALUE);
        }

        for (int y = 0; y < R; y++) {
            map[y] = r.nextLine();
            for (int x = 0; x < C; x++) {
                if (map[y].charAt(x) == 'S') {
                    hog = new Coordinate(x, y, 0);
                }

                if (map[y].charAt(x) == '*') {
                    queue.add(new Coordinate(x, y, 0));
                }
            }

        }
    }

    private static boolean isWater(int x, int y) {
        return check(x, y, WATER);
    }

    private static boolean isCave(int x, int y) {
        return check(x, y, CAVE);
    }

    private static boolean isRock(int x, int y) {
        return check(x, y, ROCK);
    }

    private static boolean check(int x, int y, char i) {
        return map[y].charAt(x) == i;
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
            if (!st.hasMoreTokens())
                st = new StringTokenizer(r.readLine());
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

