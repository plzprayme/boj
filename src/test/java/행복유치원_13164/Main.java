package 행복유치원_13164;

import java.io.*;
import java.util.*;

import org.junit.jupiter.api.Test;

class Main {

    @Test
    public static void main(String[] args) throws IOException {
        input();
        solution();
    }

    private static void solution() {

        // N명의 원생들을 키 순서대로 일렬로 세운다.
        // 총 K개의 조로 나누자.

        // 조에는 적어도 한명을 포함한다.
        // 같은 조에 속한 원생은 인접해야한다.
        // 조의 인원수가 같을 필요 없다.

        // 티셔츠 비용은 tallest - smallest


        // 어떻게 해야할까?

        // 4 2
        // 1 100 101 102
        // [1], [100, 101, 102] = 2

        // 원생은 최대 300_000
        // 조는 최대 300_000

        for (int i = 1; i <= N - K + 1; i++) {
            backtracking(i + 1, 1, height[i] - height[1]);
        }

        if (K == 1) System.out.println(height[N] - height[1]);
        else System.out.println(answer);
    }

    static int K;
    static int N;
    static int[] height;
    static int answer = Integer.MAX_VALUE;

    static void backtracking(int start, int k, int sum) {
        if (k + 1 == K) {
            answer = Math.min(answer, sum + height[N] - height[start]);
        } else {

            for (int i = start; i < N; i++) {
                if (sum >= answer) return;
                backtracking(i + 1, k + 1, sum + height[i] - height[start]);
            }

        }

    }

    private static void input() throws IOException {
        InputReader r = new InputReader("C:\\Users\\workspace\\boj\\src\\test\\java\\행복유치원_13164\\input.txt");
        N = r.nextInt();
        K = r.nextInt();

        height = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            height[i] = r.nextInt();
        }

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

