package 거울설치_2151;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Objects;
import java.util.PriorityQueue;

import org.junit.jupiter.api.Test;

public class 거울설치 {

    private static State start = null;

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
        BufferedWriter w = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(r.readLine());

        char[][] map = new char[N][N];
        for (int _x = 0; _x < N; _x++) {

            map[_x] = r.readLine().toCharArray();
            for (int _y = 0; _y < N; _y++) {

                // 아직 start가 없으면
                if (Objects.isNull(start)) {
                    // 시작 위치 저장
                    if (map[_y][_x] == '#') {
                        start = new State(_x, _y, 0, null);
                    }
                }

            }

        }

        // for (char c[] : map) {
        //     System.out.println(Arrays.toString(c));
        // }

        PriorityQueue<State> q = new PriorityQueue<>();
        for (Direction d : directions) {
            int nx = start.x + d.x;
            int ny = start.y + d.y;

            if (nx < N && ny < N && nx > -1 && ny > -1 && map[ny][nx] != '*') {
                q.add(new State(nx, ny, 0, d));
            }
        }

        while (!q.isEmpty()) {
            State state = q.poll();
            char now = map[state.y][state.x];
            if (now == '#') {
                w.write(state.mirror());
                w.flush();
                return;
            }

            if (now == '.') {
                q.add(new State(state.nextX(), state.nextY(), state.mirror, state.d));
            }

            if (now == '!') {

                for (Direction d : state.d.turn()) {
                    int nx = state.x + d.x;
                    int ny = state.y + d.y;

                    if (nx < N && ny < N && nx > -1 && ny > -1 && map[ny][nx] != '*') {
                        q.add(new State(nx, ny, state.mirror + 1, d));
                    }
                }
            }

            // System.out.printf("%c | %s\n", now, state);
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

        public Direction[] turn() {
            if (direction == 'L' || direction == 'R') {
                return new Direction[] {
                    new Direction(0, -1, 'U'),
                    new Direction(0, 1, 'D')
                };
            }

            return new Direction[] {
                new Direction(-1, 0, 'L'),
                new Direction(1, 0, 'R')
            };
        }
    }

    private static class State implements Comparable<State> {
        int x, y;
        int mirror;
        Direction d;

        public State(int x, int y, int mirror, Direction d) {
            this.x = x;
            this.y = y;
            this.mirror = mirror;
            this.d = d;
        }

        public int nextX() {
            return x + d.x;
        }

        public int nextY() {
            return y + d.y;
        }

        public String mirror() {
            return String.valueOf(mirror);
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
                "y=" + y +
                ", x=" + x +
                ", mirror=" + mirror +
                '}';
        }
    }

}
