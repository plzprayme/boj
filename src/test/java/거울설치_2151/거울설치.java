package 거울설치_2151;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Objects;
import java.util.PriorityQueue;

import org.junit.jupiter.api.Test;

public class 거울설치 {

    private static State start = null;
    private static State end = null;

    private static int[] dx = {-1, 1, 0, 0}; // 왼 오 외 아
    private static int[] dy = {0, 0, -1, 1};

    private static Direction[] directions = {
        new Direction(-1, 0, 'L'),
        new Direction(1, 0, 'R'),
        new Direction(0, -1, 'U'),
        new Direction(0, 1, 'D'),
    };

    @Test
    public static void main(String[] args) throws IOException {
        BufferedReader r = new BufferedReader(
            new FileReader("C:\\Users\\prayme\\workspace\\boj\\src\\test\\java\\거울설치_2151\\input.txt"));
        int N = Integer.parseInt(r.readLine());

        char[][] map = new char[N][N];
        for (int _x = 0; _x < N; _x++) {
            map[_x] = r.readLine().toCharArray();

            for (int _y = 0; _y < N; _y++) {

                if (map[_y][_x] == '#') {
                    if (Objects.isNull(start)) {
                        start = new State(_x, _y, 0);
                    } else {
                        end = new State(_x, _y, 0);
                    }
                }

            }

        }

        for (char c[] : map) {
            System.out.println(Arrays.toString(c));
        }

        PriorityQueue<State> q = new PriorityQueue<>();
        q.add(start);

        while (!q.isEmpty()) {
            State now = q.poll();

            if (map[now.y][now.x] == '#') {
                System.out.println(now.mirror);
                return;
            }

            for (Direction d : directions) {
                int nx = now.x + d.x;
                int ny = now.y + d.y;

                if (nx > N || nx < 0 || ny > N || ny < 0) continue;

                char next = map[ny][nx];
                // 막혀 있으면 다른 방향으로
                if (next == '*')
                    continue;

                // 전진 가능하면 다음 좌표로 이동
                if (next == '.')
                    q.add(new State(nx, ny, now.mirror));

                // 거울 설치 가능하면 거울 설치 or 설치하지 않고 직진
                if (next == '!') {

                    // 현재 방향이 위,아래라면 왼, 오 추가
                    if (d.direction == 'D' || d.direction == 'U') {

                        // 다음 좌표가 배열 안쪽, 벽이 아니라면 이동
                        if (nx + 1 < N && map[ny][nx+1] != '*') {
                            q.add(new State(nx + 1, ny, now.mirror + 1));
                        }

                        if (nx - 1 > -1 && map[ny][nx-1] != '*') {
                            q.add(new State(nx - 1, ny, now.mirror + 1));
                        }


                    }

                    // 현재 방향이 왼,오라면 위, 아래 추가
                    if (d.direction == 'L' || d.direction == 'R') {

                        if (ny + 1 < N && map[ny + 1][nx] != '*') {
                            q.add(new State(nx, ny + 1, now.mirror + 1));
                        }

                        if (ny - 1 > -1 && map[ny - 1][nx] != '*') {
                            q.add(new State(nx, ny - 1, now.mirror + 1));
                        }

                    }

                    // 그냥 직진
                    if (nx + d.x < N && nx + d.x < -1 && ny + d.y < N && ny + d.y > -1 && map[ny][nx] == '*') {
                        q.add(new State(nx + d.x, nx + d.y, now.mirror));
                    }

                }
            }
        }

    }

    private static class Direction {
        int x, y;
        char direction;

        public Direction(int x, int y, char direction) {
            this.x = x;
            this.y = y;
            this.direction = direction;
        }
    }

    private static class State implements Comparable<State> {
        int x, y;
        int mirror;

        public State(int x, int y, int mirror) {
            this.x = x;
            this.y = y;
            this.mirror = mirror;
        }

        @Override
        public int compareTo(State o) {
            if (this.mirror > o.mirror)
                return 1;
            else if (this.mirror == o.mirror)
                return 0;
            else
                return -1;
        }

        @Override
        public String toString() {
            return "State{" +
                "x=" + x +
                ", y=" + y +
                ", mirror=" + mirror +
                '}';
        }
    }

}
