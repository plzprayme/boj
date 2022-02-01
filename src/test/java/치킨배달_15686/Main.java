package 치킨배달_15686;

import java.io.*;
import java.util.*;

import org.junit.jupiter.api.Test;

class Main {

    static int N, M;
    static int K;

    static int[][] map;

    static boolean[] selected;

    static List<Coordinate> chickens = new ArrayList<>();
    static List<Coordinate> houses = new ArrayList<>();

    static int answer = Integer.MAX_VALUE;

    static class Coordinate {
        int x, y;

        public Coordinate(int x, int y) {
            this.x = x;
            this.y = y;
        }

        private int distance(Coordinate c) {
            return Math.abs(x - c.x) + Math.abs(y - c.y);
        }

    }

    @Test
    public static void main(String[] args) throws IOException {
        input();
        solution();
    }

    private static void solution() {
        backtracking(0, 0);
        System.out.println(answer);
    }

    static void backtracking(int m, int s) {
        if (m == M) {

            int sum = 0;
            for (Coordinate h : houses) {
                int min = Integer.MAX_VALUE;
                for (int i = 0; i < chickens.size(); i++) {
                    if (selected[i]) {
                        min = Math.min(min, h.distance(chickens.get(i)));
                    }
                }
                sum += min;
            }
            answer = Math.min(answer, sum);

        } else {

            for (int start = s; start < K; start++) {
                selected[start] = true;
                backtracking(m + 1, start + 1);
                selected[start] = false;
            }

        }
    }

    private static void input() throws IOException {
        InputReader r = new InputReader("C:\\Users\\workspace\\boj\\src\\test\\java\\치킨배달_15686\\input.txt");
        N = r.nextInt(); M = r.nextInt();

        map = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                map[i][j] = r.nextInt();
                if (map[i][j] == 2) chickens.add(new Coordinate(j, i));
                else if (map[i][j] == 1) houses.add(new Coordinate(j, i));
            }
        }

        K = chickens.size();
        selected = new boolean[K];
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

