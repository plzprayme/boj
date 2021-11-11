package 리모컨_1107;

import java.io.*;
import java.util.*;

import org.junit.jupiter.api.Test;

class Main {

    static int N, M;
    static int[] nums;
    static Set<Integer> buttons;

    static int startChannel = 100;
    static int count;

    private static void solution() {
        if (M == 10) {
            System.out.println(Math.abs(N - startChannel));
            return;
        }

        if (M == 0) {
            int a = Math.abs(N - startChannel);
            int b = String.valueOf(N).length();
            System.out.println(Math.min(a, b));
            return;
        }

        count = Math.abs(N - startChannel);
        int limit = N * 2;
        if (N < 100) limit = 100 * 2;
        s: for (int i = 0; i < limit; i++) {

            String s = String.valueOf(i);
            for (int j = 0; j < s.length(); j++) {
                if (!buttons.contains(s.charAt(j) - '0')) continue s;
            }

            count = Math.min(count, s.length() + Math.abs(i - N));
        }

        System.out.println(count);

    }

    private static void input() throws IOException {
        InputReader r = new InputReader("C:\\Users\\prayme\\workspace\\boj\\src\\test\\java\\리모컨_1107\\input.txt");
        N = r.nextInt();
        M = r.nextInt();
        nums = new int[M];
        buttons = new HashSet<>();

        if (M == 0)
            return;

        for (int i = 0; i < 10; i++)
            buttons.add(i);
        for (int i = 0; i < M; i++)
            buttons.remove(r.nextInt());
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

