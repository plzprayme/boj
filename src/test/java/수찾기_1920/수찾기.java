package 수찾기_1920;

import java.io.*;
import java.util.*;

import org.junit.jupiter.api.Test;

class 수찾기 {

    static int N, M;
    static int[] A, B;

    private static void solution() {
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= M; i++) {
            sb.append(binarySearch(1, N, B[i])).append('\n');
        }
        System.out.println(sb);
    }

    private static int binarySearch(int l, int r, int v) {

        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (A[mid] == v) return 1;
            else if (A[mid] > v) r = mid - 1;
            else l = mid + 1;
        }

        return 0;
    }

    private static void input() throws IOException {
        InputReader r = new InputReader("C:\\Users\\prayme\\workspace\\boj\\src\\test\\java\\수찾기_1920\\input.txt");
        N = r.nextInt(); A = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            A[i] = r.nextInt();
        }
        Arrays.sort(A, 1, N + 1);

        M = r.nextInt(); B = new int[M + 1];
        for (int i = 1; i <= M; i++) {
            B[i] = r.nextInt();
        }
    }

    @Test
    public static void main(String[] args) throws IOException {
        input();
        solution();
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

