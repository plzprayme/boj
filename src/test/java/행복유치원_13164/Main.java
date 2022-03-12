package 행복유치원_13164;

import java.io.*;
import java.util.*;

import org.junit.jupiter.api.Test;

class Main {

    static int N, K;
    static int[] height;
    static int[] diff;

    @Test
    public static void main(String[] args) throws IOException {
        input();
        solution();
    }

    private static void solution() {

        for (int i = 1; i < N; i++) {
            diff[i] = height[i + 1] - height[i];
        }

        Arrays.sort(diff);

        int answer = 0;
        for (int i = 1; i <= N - K; i++) {
            answer += diff[i];
        }
        System.out.println(answer);
    }



    private static void input() throws IOException {
        InputReader r = new InputReader("C:\\Users\\workspace\\boj\\src\\test\\java\\행복유치원_13164\\input.txt");

        N = r.nextInt();
        K = r.nextInt();

        height = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            height[i] = r.nextInt();
        }

        diff = new int[N];
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

