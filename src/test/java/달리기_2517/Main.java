package 달리기_2517;

import java.io.*;
import java.util.*;

import org.junit.jupiter.api.Test;

class Main {

    static int N;
    static int[] nums;
    static int[] sorted;

    @Test
    public static void main(String[] args) throws IOException {
        input();
        solution();
    }

    private static void solution() {
//        StringBuilder ex = new StringBuilder();
//        for (int i = 1; i <= 500_000; i++) {
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
            // 정렬
            mergeSort(1, i);

            // 이분탐색
            int idx = Arrays.binarySearch(sorted, 1, i + 1, sorted[i]);

            sb.append(idx).append('\n');
        }

        System.out.println(sb);
    }

    static void mergeSort(int left, int right) {
        // right - left == 1
        if (right == left) return;

        int mid = (left + right) / 2;
        mergeSort(left, mid);
        mergeSort(mid + 1, right);

        merge(left, mid, right);
    }

    static void merge(int left, int mid, int right) {
        int l = left;
        int r = mid + 1;
        int idx = left;

        while (l <= mid && r <= right) {
            // r이 크면 r을 넣는다.
            if (nums[l] <= nums[r]) {
                sorted[idx++] = nums[r++];
            } else {
                sorted[idx++] = nums[l++];
            }
        }

        // r이 남았을 때
        if (l > mid) {
            while (r <= right) {
                sorted[idx++] = nums[r++];
            }
        } else {
            while (l <= mid) {
                sorted[idx++] = nums[l++];
            }
        }

        for (int i = left; i <= right; i++) {
            nums[i] = sorted[i];
        }

    }

    private static void input() throws IOException {

        InputReader r = new InputReader("C:\\Users\\workspace\\boj\\src\\test\\java\\달리기_2517\\dummy.txt");

        N = r.nextInt();

        nums = new int[N + 1];
        sorted = new int[N + 1];

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

