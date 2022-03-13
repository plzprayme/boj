package 센서_2212;

import java.io.*;
import java.util.*;

import org.junit.jupiter.api.Test;

class Main {

    static int N, K;
    static int[] sensors;
    static int[] diff;

    @Test
    public static void main(String[] args) throws IOException {
        input();
        solution();
    }

    private static void solution() {

        Arrays.sort(sensors);

        for (int i = 0; i < N - 1; i++) {
            diff[i] = sensors[i + 1] - sensors[i];
        }
        Arrays.sort(diff);

        long answer = 0;
        for (int i = 0; i < N - K; i++) {
            answer += diff[i];
        }
        System.out.println(answer);
    }

    private static void input() throws IOException {
        InputReader r = new InputReader("C:\\Users\\workspace\\boj\\src\\test\\java\\센서_2212\\input.txt");

        N = r.nextInt();
        K = r.nextInt();

        sensors = new int[N];
        for (int i = 0; i < N; i++) {
            sensors[i] = r.nextInt();
        }

        diff = new int[N - 1];
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
