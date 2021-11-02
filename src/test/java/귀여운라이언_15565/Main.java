package 귀여운라이언_15565;

import java.io.*;
import java.util.*;

import org.junit.jupiter.api.Test;

class Main {
    static int N, K;
    static int[] nums;

    private static void solution() {

        int answer = Integer.MAX_VALUE;
        int r = 0, count = 0;
        for (int l = 1; l <= N; l++) {
            while (r < N && count < K) {
                r++;
                if (nums[r] == 1) count++;
            }

            if (count == K) {
                answer = Math.min(r - l + 1, answer);
            }

            if (nums[l] == 1) count--;
        }

        if (answer == Integer.MAX_VALUE) answer = -1;
        System.out.println(answer);

    }

    private static void input() throws IOException {
        InputReader r = new InputReader("C:\\Users\\prayme\\workspace\\boj\\src\\test\\java\\귀여운라이언_15565\\input.txt");
        r.readLine();
        N = r.nextInt(); K = r.nextInt();

        nums = new int[N + 1];
        r.readLine();
        for (int i = 1; i <= N; i++) nums[i] = r.nextInt();
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
        }

        public void readLine() throws IOException {
            st = new StringTokenizer(r.readLine());
        }

        public int nextInt() {
            return Integer.parseInt(st.nextToken());
        }
    }

}
