package 레이저통신_6087;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Objects;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;
import java.util.StringTokenizer;

import org.junit.jupiter.api.Test;

public class 레이저통신 {

    static int W, H;
    static char map[][];
    static int[] dx = {0, 0, 1, -1}, dy = {1, -1, 0, 0};
    static class State implements Comparable<State> {
        int x, y;
        int dir;
        int count;

        public State(int x, int y, int dir, int count) {
            this.x = x;
            this.y = y;
            this.dir = dir;
            this.count = count;
        }

        // 우선순위 큐에 카운트가 적은 순으로 정렬되도록
        @Override
        public int compareTo(State o) {
            // 왼쪽이 작으면 -1 같으면 0 크면 1
            return Integer.compare(count, o.count);
        }
    }

    @Test
    public static void main(String[] args) throws IOException {
        BufferedReader r = new BufferedReader(new FileReader("C:\\Users\\prayme\\workspace\\boj\\src\\test\\java\\레이저통신_6087\\input.txt"));
        StringTokenizer st = new StringTokenizer(r.readLine());

        W = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());
        map = new char[H][W];

        boolean isStart = false;
        State start = null, end = null;
        for (int i = 0; i < H; i++) {
            map[i] = r.readLine().toCharArray();
            for (int j = 0; j < W; j++) {

                if (map[i][j] == 'C') {
                    if (!isStart) {
                        start = new State(i, j, 0, 0);
                        isStart = true;
                    } else {
                        end = new State(i, j, 0, 0);
                    }
                }

            }
        }

        System.out.println(go(start, end));
    }

    private static int go(State start, State end) {
        PriorityQueue<State> pQ = new PriorityQueue<>();
        // 방향별 visit 확인
        boolean[][][] visited = new boolean[4][H][W];

        // 시작점으로부터 4방향을 pq에 먼저 넣기
        for (int d = 0; d < 4; d++) {
            int xx = start.x + dx[d];
            int yy = start.y + dy[d];

            // 범위 벗어남
            if (xx < 0 || yy < 0 || xx >= H || yy >= W) continue;

            // 벽일 때
            if (map[xx][yy] == '*') continue;
            pQ.add(new State(xx, yy, d, 0));
        }

        while (!pQ.isEmpty()) {
            State now = pQ.poll();

            // 도착 지점 도달
            if (now.x == end.x && now.y == end.y) return now.count;
            // 이미 방문한 곳은 패스
            if (visited[now.dir][now.x][now.y]) continue;
            visited[now.dir][now.x][now.y] = true;

            // 동서남북 탐색
            for (int d = 0; d < 4; d++) {
                int xx = now.x + dx[d];
                int yy = now.y + dy[d];
                // 범위 벗어남
                if (xx < 0 || yy < 0 || xx >= H || yy >= W) continue;
                if (map[xx][yy] == '*') continue;

                if (now.dir == d) pQ.add(new State(xx, yy, d, now.count));
                else pQ.add(new State(xx, yy, d, now.count + 1)); // 180도 도는건 왜 카운트가 1 증가?
            }

        }

        return 0;
    }
}
