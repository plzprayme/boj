package 리모컨_1107;

import java.io.*;
import java.util.*;

import org.junit.jupiter.api.Test;

class Main {

    static int N, M;
    static Set<Integer> broken;
    static int count;

    private static void solution() {
        count = Math.abs(N - 100);
        rec(1, 0);
        System.out.println(count);
    }

    private static void rec(int n, int now) {
        if (n == 7) return;
        for (int i = 0; i < 10; i++) {
            if (broken.contains(i)) continue;
            int next = now * 10 + i;
            count = Math.min(count, Math.abs(N - next) + n);
            rec(n + 1, next);
        }
    }

    private static void input() throws IOException {
        InputReader r = new InputReader("C:\\Users\\prayme\\workspace\\boj\\src\\test\\java\\리모컨_1107\\input.txt");
        N = r.nextInt();
        M = r.nextInt();

        broken = new HashSet<>();
        for (int i = 0; i < M; i++) broken.add(r.nextInt());
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
            if (!st.hasMoreTokens())
                st = new StringTokenizer(r.readLine());
            return Integer.parseInt(st.nextToken());
        }

        public char[] nextCharArr() throws IOException {
            return r.readLine().toCharArray();
        }
    }

}

