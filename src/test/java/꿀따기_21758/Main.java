package 꿀따기_21758;

import java.io.*;
import java.util.*;

import org.junit.jupiter.api.Test;

class Main {

    static int N;
    static int[] honey;
    static int[] sum;

    @Test
    public static void main(String[] args) throws IOException {
        input();
        solution();
    }

    private static void solution() {

        // 일단 누적합을 구하자
        sum[0] = honey[0];
        for (int i = 1; i < N; i++) {
            sum[i] = honey[i] + sum[i - 1];
        }

        // 부분합은 어떻게 구할 수 있을까?

        // 좌우로 N개의 장소가 있다.

        // 장소들 중 서로 다른 두 곳을 골라서 벌을 둔다.
        // 벌통이 있는 장소와 벌이 있는 장소

        // 두 마리의 벌은 벌통으로 날아가며 모든 칸의 꿀을 딴다.

        // 1. 표시된 양만큼의 꿀을 딴다. 벌통까지 딴다.
        // 2. 벌이 시장한 장소에서는 꿀을 딸 수 없다.

        // 3 <= N <= 100_000

        // 벌통의 위치와 벌의 위치를 어떻게 정할까?

        // 최대한 많이 따려면 벌통이 양 끝에 있거나
        // 벌 둘이 양 끝에 있어야만한다.

        // 벌통이 양 끝에 있는 경우
        // 벌을 서로 다른

        // 세가지 경우의 수
        // 벌통 맨 오른쪽, 벌 맨 왼쪽 + 벌 이동 하는 경우의 수
        int answer = 0;

        int leftBee = sum[N - 1] - honey[0];
        for (int i = 1; i < N - 1; i++) {
            // 벌이 맨 왼쪽에 있는 경우
            int rightBee = sum[N - 1] - sum[i];
            int total = leftBee + rightBee - honey[i];
            answer = Math.max(answer, total);
        }

        // 벌통 맨 왼쪽, 벌 맨 오른쪽 + 벌 이동하는 경우의 수
        int rightBee = sum[N - 2];
        for (int i = N - 2; i > 0; i--) {
            leftBee = sum[N - 1] - sum[i];
            int total = leftBee + rightBee - honey[i];
            answer = Math.max(answer, total);
        }

        // 벌 맨 왼쪽, 벌 맨 오른쪽, 벌통이 가장 큰 값에 있는 경우
        int total = sum[N - 1] - honey[0] - honey[N - 1];
        for (int i = 1; i < N - 1; i++) {
            answer = Math.max(answer , total + honey[i]);
        }

        System.out.println(answer);
    }

    private static void input() throws IOException {
        InputReader r = new InputReader("C:\\Users\\workspace\\boj\\src\\test\\java\\꿀따기_21758\\input.txt");

        N = r.nextInt();

        honey = new int[N];

        for (int i = 0; i < N; i++) {
            honey[i] = r.nextInt();
        }

        sum = new int[N];
//        sum = new int[N][N];
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
