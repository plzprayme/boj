package 움직이는미로탈출_16954;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

import org.junit.jupiter.api.Test;

public class 움직이는미로탈출 {
    @Test
    public static void main(String[] args) throws IOException {
        BufferedReader r = new BufferedReader(
            new FileReader("C:\\Users\\prayme\\workspace\\boj\\src\\test\\java\\움직이는미로탈출_16954\\input.txt"));

        int N = 8;
        int[] dy = {-1, -1, -1, 0, 0, 0, 1, 1, 1};
        int[] dx = {-1, 0, 1, -1, 0, 1, -1, 0, 1};
        boolean[][][] dp = new boolean[N+1][N][N];
        char[][] map = new char[N][N];

        for (int i = 0; i < N; i++) {
            map[i] = r.readLine().toCharArray();
        }

        Stack<State> q = new Stack<>();
        // 출발점 셋팅
        q.add(new State(0, 7, 0));
        dp[0][7][0] = true;

        // int answer = 0;
        while (!q.isEmpty()) {
            State now = q.pop();

            if (now.time == 7 || now.y == 0) {
                System.out.println(1);
                return;
            }

            for (int i = 0; i < 9; i++) {
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];
                int nt = now.time + 1;

                if (nx < 0 || ny < 0 || nx >= N || ny >= N) continue;
                if (map[ny][nx] == '#') continue;
                if (ny - now.time >= 0 && map[ny - now.time][nx] == '#') continue;
                if (ny - nt >= 0 && map[ny - nt][nx] == '#') continue;

                if (!dp[nt][ny][nx]) {
                    dp[nt][ny][nx] = true;
                    q.add(new State(nt, ny,  nx));
                }

            }

        }

        System.out.println(0);

    }

    private static class State {
        int time, x, y;

        public State(int time, int y, int x) {
            this.time = time;
            this.x = x;
            this.y = y;
        }
    }
}
