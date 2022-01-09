package 트리의순회_2263;

import java.io.*;
import java.util.*;

import org.junit.jupiter.api.Test;

class Main {

    static int N;
    static int[] in, post;

    static StringBuilder sb = new StringBuilder();

    @Test
    public static void main(String[] args) throws IOException {
        input();
        solution();
    }

    private static void solution() {
        // TODO

        // 인오더 포스트오더 프리오더
        // 분할 정복 중앙 값은 append 한다.
        // 왼쪽 값과 오른쪽 값을 차례대로 append 한다.

        divide(0, N - 1);
        System.out.println(sb);

        // 포스트 오더
        // 0 ~ N/2

        // 프리 오더
        // N/2 ~ N
    }

    private static void divide(int from, int to) {
        int mid = (from + to) / 2;

        if (to - from == 2) {
            appendAnswer(in[mid]);
            appendAnswer(in[from]);
            appendAnswer(in[to]);
            return;
        }


        divide(from, mid);
        divide(mid, to);
    }

    private static void appendAnswer(int n) {
        sb.append(n).append(' ');
    }

    private static void input() throws IOException {
        InputReader r = new InputReader("C:\\Users\\workspace\\boj\\src\\test\\java\\트리의순회_2263\\input.txt");
        N = r.nextInt();

        in = new int[N];
        for (int i = 0; i < N; i++) {
            in[i] = r.nextInt();
        }

        post = new int[N];
        for (int i = 0; i < N; i++) {
            post[i] = r.nextInt();
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

