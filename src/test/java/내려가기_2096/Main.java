package 내려가기_2096;

import java.io.*;
import java.util.*;

import org.junit.jupiter.api.Test;

class Main {

    @Test
    public static void main(String[] args) throws IOException {
        solution();
    }

    private static void solution() throws IOException {
        InputReader r = new InputReader("C:\\Users\\workspace\\boj\\src\\test\\java\\내려가기_2096\\input.txt");
        int N = r.nextInt();

        int[] max = new int[3];
        int[] min = new int[3];

        // 초기식
        max[0] = r.nextInt();
        max[1] = r.nextInt();
        max[2] = r.nextInt();

        min[0] = max[0];
        min[1] = max[1];
        min[2] = max[2];

        // 점화식
        int L, R, M;
        int tmp1, tmp2, tmp3, tmp4, tmp5, tmp6;
        for (int i = 1; i < N; i++) {
            L = r.nextInt();
            M = r.nextInt();
            R = r.nextInt();

            tmp1 = Math.max(max[0], max[1]) + L;
            tmp2 = Math.min(min[0], min[1]) + L;

            tmp3 = Math.max(max[0], Math.max(max[1], max[2])) + M;
            tmp4 = Math.min(min[0], Math.min(min[1], min[2])) + M;

            tmp5 = Math.max(max[1], max[2]) + R;
            tmp6 = Math.min(min[1], min[2]) + R;

            max[0] = tmp1;
            min[0] = tmp2;

            max[1] = tmp3;
            min[1] = tmp4;

            max[2] = tmp5;
            min[2] = tmp6;
        }

        System.out.printf("%d %d", Math.max(max[0], Math.max(max[1], max[2])), Math.min(min[0], Math.min(min[1], min[2])));
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

