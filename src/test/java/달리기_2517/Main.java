package 달리기_2517;

import java.io.*;
import java.util.*;

import org.junit.jupiter.api.Test;

class Main {

    static int N;
    static int[] nums;

    @Test
    public static void main(String[] args) throws IOException {
        input();
        solution();
    }

    private static void solution() {
//        StringBuilder ex = new StringBuilder();
//        for (int i = 500_000; i > 0; i--) {
//            ex.append(i).append('\n');
//        }
//
//        File file = new File("C:\\Users\\workspace\\boj\\src\\test\\java\\달리기_2517\\dummy.txt");
//        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
//            writer.append(ex);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
        // 나보다 큰 수가 앞에 몇개가 있는지 확인하자.

        // 시간 복잡도는?
        // 완전탐색 = O(500_000^2) = 2500억


        // i - 1까지의 최대 값이 i보다 작으면 무조건 1
        // 최대 값의 인덱스를 기억하고 있자
        // 최솟 값 ~ 최대 값의 인덱스 까지만 탐색한다.
        // 최악은? 매번 최대 값이라면?
        // 500_000 1 499_998 5 4 6 3 2
        //             max
        //             idx

        // 항상 1 1 1 1 1 1 이 가능하다면??

        // 1 2 3 4 5 6 7 8 9 ...
        // 500,000만?

        // 10 8 7 2 1

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= N; i++) {
            int right = i;
            int left = i - 1;
            while (nums[left] < nums[right]) {
                swap(left, right);
                left--;
                right--;
            }
            sb.append(right).append('\n');
        }

    }

    private static void swap(int left, int right) {
        int tmp = nums[left];
        nums[left] = nums[right];
        nums[right] = tmp;
    }

    private static void input() throws IOException {

        InputReader r = new InputReader("C:\\Users\\workspace\\boj\\src\\test\\java\\달리기_2517\\dummy.txt");

        N = r.nextInt();

        nums = new int[N + 1];
        nums[0] = Integer.MAX_VALUE;

        for (int i = 1; i <= N; i++) {
            nums[i] = r.nextInt();
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

