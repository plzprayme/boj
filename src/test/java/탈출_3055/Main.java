package 탈출_3055;

import java.io.*;
import java.util.*;

import org.junit.jupiter.api.Test;

class Main {

    static int R, C;
    static String[] map;

    static int[][] waterDist, hogDist;
    static boolean[][] visited;

    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {-1, 0, 1, 0};

    private static void solution() {
        waterBfs();
        hogBfs();
        printAnswer();
    }

    private static void waterBfs() {
        Queue<Coordinate> queue = new LinkedList<>();
        for (int y = 0; y < R; y++) {
            for (int x = 0; x < C; x++) {
                waterDist[y][x] = -1;
                if (map[y].charAt(x) == '*') {
                    queue.add(new Coordinate(x, y));
                    waterDist[y][x] = 0;
                    visited[y][x] = true;
                }
            }
        }

        while (!queue.isEmpty()) {
            Coordinate cur = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];

                if (isOut(nx, ny)) continue;
                if (visited[ny][nx]) continue;
                if (map[ny].charAt(nx) != '.') continue;

                visited[ny][nx] = true;
                waterDist[ny][nx] = waterDist[cur.y][cur.x] + 1;
                queue.add(new Coordinate(nx, ny));
            }
        }

    }

    private static void hogBfs() {
        Queue<Coordinate> queue = new LinkedList<>();
        for (int y = 0; y < R; y++) {
            for (int x = 0; x < C; x++) {
                hogDist[y][x] = -1;
                visited[y][x] = false;
                if (map[y].charAt(x) == 'S') {
                    queue.add(new Coordinate(x, y));
                    hogDist[y][x] = 0;
                    visited[y][x] = true;
                }
            }
        }

        while (!queue.isEmpty()) {
            Coordinate cur = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];

                if (isOut(nx, ny)) continue;
                if (visited[ny][nx]) continue;
                if (map[ny].charAt(nx) != '.' && map[ny].charAt(nx) != 'D') continue;
                if (waterDist[ny][nx] != -1 && waterDist[ny][nx] <= hogDist[cur.y][cur.x] + 1) continue;

                visited[ny][nx] = true;
                hogDist[ny][nx] = hogDist[cur.y][cur.x] + 1;
                queue.add(new Coordinate(nx, ny));
            }
        }
    }

    private static void printAnswer() {
        for (int y = 0; y < R; y++) {
            for (int x = 0; x < C; x++) {
                if (map[y].charAt(x) == 'D') {
                    if (hogDist[y][x] == -1) System.out.println("KAKTUS");
                    else System.out.println(hogDist[y][x]);
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
        int x, y;

        public Coordinate(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    private static void input() throws IOException {
        InputReader r = new InputReader("C:\\Users\\prayme\\workspace\\boj\\src\\test\\java\\탈출_3055\\input.txt");

        R = r.nextInt();
        C = r.nextInt();
        map= new String[R];

        hogDist = new int[R][C];
        waterDist = new int[R][C];
        visited = new boolean[R][C];

        for (int y = 0; y < R; y++) {
            map[y] = r.nextLine();
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

