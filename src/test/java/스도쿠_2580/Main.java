package 스도쿠_2580;

import java.io.*;
import java.util.*;

import org.junit.jupiter.api.Test;

class Main {

    static int N;

    static int[][] map = new int[10][10];

    static List<XY> empty = new ArrayList<>();

    static Set<Integer>[] row = new Set[10];
    static Set<Integer>[] col = new Set[10];
    static Set<Integer>[] area = new Set[10];

    static StringBuilder answer;

    static class XY {
        int x, y;

        public XY(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    @Test
    public static void main(String[] args) throws IOException {
        input();
        solution();
    }

    private static void solution() {
        // 9 * 9 의 스도쿠 판

        // 가로줄과 세로줄에는 1부터 9까지의 숫자가 한번씩만.
        // 3 * 3 에도 1부터 9까지의 숫자가 한번씩만
        // 완전탐색? 매번 행, 열, 사각형을 검증해야한다. 절대 불가능.

        // 열, 행, 사각형을 캐싱하고 있는 Set을 유지하면 어떨까?


        // 0 인 부분의 좌표를 기억하고 있자.
        // 각 좌표에 0 ~ 9 를 반복하자.

        N = empty.size();
        backtracking(0);
//        String result = "1 3 5 4 6 9 2 7 8 " +
//                "7 8 2 1 3 5 6 4 9 " +
//                "4 6 9 2 7 8 1 3 5 " +
//                "3 2 1 5 4 6 8 9 7 " +
//                "8 7 4 9 1 3 5 2 6 " +
//                "5 9 6 8 2 7 4 1 3 " +
//                "9 1 7 6 5 2 3 8 4 " +
//                "6 4 3 7 8 1 9 5 2 " +
//                "2 5 8 3 9 4 7 6 1 ";
        System.out.println(answer);
    }

    private static void backtracking(int n) {
        if (n == N) {
            answer = new StringBuilder();
            for (int i = 1; i < 10; i++) {
                for (int j = 1; j < 10; j++) {
                    answer.append(map[i][j]).append(' ');
                }
                answer.append('\n');
            }
        } else {
            XY xy = empty.get(n);
            int x = xy.x;
            int y = xy.y;
            for (int i = 1; i < 10; i++) {
                if (Objects.nonNull(answer)) return;
                if (getArea(y, x).contains(i)) continue;
                if (row[y].contains(i)) continue;
                if (col[x].contains(i)) continue;

                map[y][x] = i;
                getArea(y, x).add(i);
                row[y].add(i);
                col[x].add(i);

                backtracking(n + 1);

                map[y][x] = 0;
                getArea(y, x).remove(i);
                row[y].remove(i);
                col[x].remove(i);
            }
        }
    }

    private static void input() throws IOException {
        InputReader r = new InputReader("C:\\Users\\workspace\\boj\\src\\test\\java\\스도쿠_2580\\input.txt");
        for (int i = 1; i < 10; i++) {
            row[i] = new HashSet<>();
            col[i] = new HashSet<>();
            area[i] = new HashSet<>();
        }

        for (int i = 1; i < 10; i++) {
            for (int j = 1; j < 10; j++) {
                map[i][j] = r.nextInt();
                if (map[i][j] == 0) empty.add(new XY(j, i));
                else {
                    row[i].add(map[i][j]);
                    col[j].add(map[i][j]);
                    getArea(i, j).add(map[i][j]);
                }
            }
        }
    }

    static Set<Integer> getArea(int y, int x) {
        Set<Integer> result;
        if (y <= 3) {
            int idx = -1;
            if (x <= 3) {
                idx = 1;
            } else if (x <= 6) {
                idx = 2;
            } else {
                idx = 3;
            }
            result = area[idx];
        } else if (y <= 6) {
            int idx = -1;
            if (x <= 3) {
                idx = 4;
            } else if (x <= 6) {
                idx = 5;
            } else {
                idx = 6;
            }
            result = area[idx];
        } else {
            int idx = -1;
            if (x <= 3) {
                idx = 7;
            } else if (x <= 6) {
                idx = 8;
            } else {
                idx = 9;
            }
            result = area[idx];
        }

        return result;
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

