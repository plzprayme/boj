package 수고르기_2230;

import java.io.*;
import java.util.*;

import org.junit.jupiter.api.Test;

class Main {

    static int N, M;
    static int[] nums;

    private static void solution() {
        Arrays.sort(nums, 1, N + 1);
        int r = 1, answer = Integer.MAX_VALUE;

        for (int l = 1; l <= N; l++) {
            int distance = nums[r] - nums[l];
            while (r + 1 <= N && distance < M) ++r;

            if (distance >= M) answer = Math.min(answer, distance);
        }

        System.out.println(answer);
    }



    private static void input() throws IOException {
        InputReader r = new InputReader("C:\\Users\\prayme\\workspace\\boj\\src\\test\\java\\수고르기_2230\\input.txt");
        r.readLine();
        N = r.nextInt(); M = r.nextInt();

        nums = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            r.readLine();
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
        }

        public void readLine() throws IOException {
            st = new StringTokenizer(r.readLine());
        }

        public int nextInt() {
            return Integer.parseInt(st.nextToken());
        }
    }

}

