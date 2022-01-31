package 치킨배달_15686;

import java.io.*;
import java.util.*;

import org.junit.jupiter.api.Test;

class Main {

    static int N, M;
    static int K;

    static int[][] map;

    static Chicken[] chickens = new Chicken[13];
//    static List<Chicken> chickens = new ArrayList<>();
    static List<House> houses = new ArrayList<>();
//    static int[] count = new int[13];

    static class Chicken implements Comparable<Chicken> {
        int x, y, c;

        public Chicken(int x, int y) {
            this.x = x;
            this.y = y;
            this.c = 0;
        }

        public int distance(House h) {
            return Math.abs(x - h.x) + Math.abs(y - h.y);
        }


        @Override
        public int compareTo(Chicken o) {
            return c - o.c;
        }
    }

    static class House {
        int x, y, d;

        public House(int x, int y, int d) {
            this.x = x;
            this.y = y;
            this.d = d;
        }

        public void distance(int hx, int hy) {
            d = Math.min(d, Math.abs(x - hx) + Math.abs(y - hy));
        }

    }

    @Test
    public static void main(String[] args) throws IOException {
        input();
        solution();
    }

    private static void solution() {
        // 정사각형의 도시가 주어진다.

        // 빈칸, 치킨집, 집 중 하나다.
        // 치킨 거리는 집과 가장 가까운 치킨집 사이의 거리
        // 도시의 치킨 거리는 모든 집의 치킨거리의 합

        // 모든 치킨집의 치킨 거리를 구한다.
        // M개가 될 때 까지 치킨집을 폐업시킨다.

        // 모든 치킨 거리 구하기의 시간 복잡도는..?
        // 집의 개수 최대 100개
        // 치킨 집의 개수 13개
        // 모든 집에 대해 거리 검사 = 1300번

        // 집, 치킨 집 찾기
        for (House h : houses) {

            int idx = -1;
            int value = Integer.MAX_VALUE;
            for (int i = 0; i < K; i++) {
                int distance = chickens[i].distance(h);
                if (distance < value)  {
                    idx = i;
                    value = distance;
                }
            }

            chickens[idx].c++;
//            count[idx]++;
//            h.d = value;
        }

        // 브루트포스 가능하냐?
        // 최악의 경우는 집이 100개 곱하기
        // 치킨 집 13개 중 (13 - M)개를 선택하는 경우의 수
        // 13개 중 8 개를 선택하는 경우의 수

        // 13 * 12 * 11 * 10 * 9 * 8 * 7 * 6 * 100 = 5,189,184,000
        // 짜증남

        // 치킨 거리 카운트가 제일 작은 친구들을 삭제하자.

        PriorityQueue<Chicken> pq = new PriorityQueue<>();
        for (int i = 0; i < K; i++) {
            pq.add(chickens[i]);
        }

        while (pq.size() > M) {
            pq.poll();
        }

        while (!pq.isEmpty()) {

            Chicken c = pq.poll();
            for (House h : houses) {
                h.distance(c.x, c.y);
            }

        }

        //

        int answer = 0;
        for (House h : houses) {
            answer += h.d;
        }
        System.out.println(answer);

    }

    private static void input() throws IOException {
        InputReader r = new InputReader("C:\\Users\\workspace\\boj\\src\\test\\java\\치킨배달_15686\\input.txt");
        N = r.nextInt(); M = r.nextInt();

        int count = 0;
        map = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                map[i][j] = r.nextInt();
                if (map[i][j] == 2) chickens[count++] = new Chicken(j, i);
                else if (map[i][j] == 1) houses.add(new House(j, i, Integer.MAX_VALUE));
            }
        }

        K = count;
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

