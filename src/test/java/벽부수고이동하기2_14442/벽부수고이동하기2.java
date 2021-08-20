package 벽부수고이동하기2_14442;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

import org.junit.jupiter.api.Test;

public class 벽부수고이동하기2 {
    @Test
    public static void main(String[] args) throws IOException {
        BufferedReader r = new BufferedReader(
            new FileReader("C:\\Users\\prayme\\workspace\\boj\\src\\test\\java\\벽부수고이동하기2_14442\\input.txt"));

        StringTokenizer st = new StringTokenizer(r.readLine());
        int N = parse(st.nextToken());
        int M = parse(st.nextToken());
        int K = parse(st.nextToken());

        final boolean WALL = true;
        final boolean ROAD = false;

        boolean[][] map = new boolean[N + 1][M + 1];
        for (int i = 1; i <= N; i++) {
            String line = r.readLine();
            for (int j = 1; j <=M; j++) {
                map[i][j] = line.charAt(j - 1) == '1' ? WALL : ROAD;
            }
        }

        int[] dx = {0, 0, -1, 1};
        int[] dy = {-1, 1, 0, 0};

        PriorityQueue<State> pq = new PriorityQueue<>();
        pq.add(new State(1, 1, K, 1));

        while (!pq.isEmpty()) {
            State now = pq.poll();

            if (now.x == M && now.y == N) {
                System.out.println(now.count);
                return;
            }

            for (int i = 0; i < 4; i++) {
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];

                if (nx < 1 || ny < 1 || ny > N || nx > M )
                    continue;

                if (now.k > 0 && map[ny][nx] == WALL) {
                    pq.add(new State(nx, ny, now.k - 1, now.count + 1));
                } else if (map[ny][nx] == ROAD) {
                    pq.add(new State(nx, ny, now.k, now.count + 1));
                }

            }

        }
        System.out.println("-1");
    }

    private static int parse(String s) {
        return Integer.parseInt(s);
    }

    private static class State implements Comparable<State> {
        int x, y, k, count;

        public State(int x, int y, int k, int count) {
            this.x = x;
            this.y = y;
            this.k = k;
            this.count = count;
        }

        @Override
        public int compareTo(State o) {
            if (count > o.count)
                return 1;
            else if (count == o.count)
                return 0;
            else
                return -1;
        }
    }
}
