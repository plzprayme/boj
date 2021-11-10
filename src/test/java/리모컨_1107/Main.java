package 리모컨_1107;

import java.io.*;
import java.util.*;

import org.junit.jupiter.api.Test;

class Main {

    static int N, M;
    static int[] nums;
    static Set<Integer> buttons;

    static int count = Integer.MAX_VALUE;

    private static void solution() {
        if (N == 100) {
            System.out.println(0);
            return;
        }

        if (M == 10) {
            System.out.println(N - 100);
            return;
        }

        for (int i = 0; i < 10; i++) buttons.add(i);
        for (int i : nums) buttons.remove(i);


        for (int i = 0; i <= N * 2; i++) {

            String s = String.valueOf(i);
            boolean flag = true;
            for (char c : s.toCharArray()) {
                if (buttons.contains(c - '0')) continue;
                flag = false;
            }

            if (flag) {
                if (i > N) {
                    count = Math.min(count, s.length() + i - N);
                }
                else {
                    count = Math.min(count, s.length() + N - i);
                }
            }

        }

        System.out.println(count);


    }

    private static void input() throws IOException {
        InputReader r = new InputReader("C:\\Users\\prayme\\workspace\\boj\\src\\test\\java\\리모컨_1107\\input.txt");
        N = r.nextInt(); M = r.nextInt();
        nums = new int[M];
        buttons = new HashSet<>();

        if (M == 0) return;
        for (int i = 0; i < M; i++) {
            nums[i] = r.nextInt();
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

