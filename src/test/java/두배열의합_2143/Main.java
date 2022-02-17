package 두배열의합_2143;

import org.junit.jupiter.api.Test;

import java.io.*;
import java.util.*;

class Main {

    static int T, N, M;
    static int[] A, B;

    static int[] aSum, bSum;

    @Test
    public static void main(String[] args) throws IOException {
        input();
        solution();
    }

    private static void solution() {
        // TODO

        // A의 부분합을 모두 구하면?
        int idx = 0;
        for (int i = 0; i < N; i++) { // 1_000^2
            int sum = A[i];
            aSum[idx++] = sum;
            for (int j = i + 1; j < N; j++) {
                sum += A[j];
                aSum[idx++] = sum;
            }
        }

        // B의 부분합 모두 구하면?
        idx = 0;
        for (int i = 0; i < M; i++) {
            int sum = B[i];
            bSum[idx++] = sum;
            for (int j = i + 1; j < M; j++) {
                sum += B[j];
                bSum[idx++] = sum;
            }
        }

        Arrays.sort(aSum);
        Arrays.sort(bSum);

        long answer = 0;
        for (int i : bSum) {
            // 같은 숫자가 있을 수 있다.
            answer += upper_bound(T - i, aSum) - lower_bound(T - i, aSum);
        }
        System.out.println(answer);
    }

    private static int upper_bound(int n, int[] data) {
        int left = 0;
        int right = data.length;

        while (left < right) {
            int mid = (left + right) / 2;

            if (data[mid] <= n) left = mid + 1;
            else right = mid;
        }

        return right;
    }

    private static int lower_bound(int n, int[] data) {
        int left = 0;
        int right = data.length;

        while (left < right) {
            int mid = (left + right) / 2;

            if (data[mid] >= n) right = mid;
            else left = mid + 1;
        }

        return right;
    }

    private static void input() throws IOException {
        InputReader r = new InputReader("C:\\Users\\workspace\\boj\\src\\test\\java\\두배열의합_2143\\input.txt");

        T = r.nextInt();

        N = r.nextInt();
        A = new int[N];
        aSum = new int[(N * (N + 1)) / 2];
        for (int i = 0; i < N; i++) {
            A[i] = r.nextInt();
        }

        M = r.nextInt();
        B = new int[M];
        bSum = new int[(M * (M + 1)) / 2];
        for (int i = 0; i < M; i++) {
            B[i] = r.nextInt();
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
