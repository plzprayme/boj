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
    static int[][] dist;
    static int[] dx = {0, 0, 1, -1}, dy = {1, -1, 0, 0};

    static class State {
        int x, y;

        public State(int x, int y) {
            this.x = x;
            this.y = y;
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
        // 지도 정보 입력
        for (int i = 0; i < H; i++) {
            map[i] = r.readLine().toCharArray();
            for (int j = 0; j < W; j++) {
                // 레이저가 있다면
                if (map[i][j] == 'C') {
                    // 시작점이 정해지지 않았다면
                    if (!isStart) {
                        start = new State(i, j);
                        isStart = true;
                    } else
                        end = new State(i, j);
                }
            }
        }


        go(start, end);
        System.out.println(dist[end.x][end.y] - 1);
    }

    private static void go(State start, State end) {

        Queue<State> q = new LinkedList<>();
        dist = new int[H][W];
        // 시작점부터 출발
        q.add(start);

        while (!q.isEmpty()) {
            State now = q.poll();
            // 도착
            if(dist[end.x][end.y] != 0) return;

            // 4방 탐색
            for (int d = 0; d < 4; d++) {
                int xx = now.x + dx[d];
                int yy = now.y + dy[d];

                // 범위를 벗어나지 않고, 벽이 나오지 않았을 때 계속 반복
                while (xx >= 0 && yy >= 0 && xx < H && yy < W && map[xx][yy] != '*') {
                    // 방문하지 않았을 때
                    if (dist[xx][yy] == 0) {
                        // 이전의 거울 개수를 저장
                        dist[xx][yy] = dist[now.x][now.y] + 1;
                        // 다음 좌표 담기 9같은 방향으로)
                        q.add(new State(xx, yy));
                    }

                    // 다음칸으로 이동
                    xx += dx[d];
                    yy += dy[d];
                }
            }
        }


    }


}
