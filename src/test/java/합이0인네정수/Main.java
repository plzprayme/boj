package 합이0인네정수;

import org.junit.jupiter.api.Test;

import java.io.*;
import java.util.*;

class Main {

    static int N;
    static int[][] arr;

    static int[] ab, cd;

    @Test
    public static void main(String[] args) throws IOException {
        input();
        solution();
    }

    private static void solution() {
        // 하나도 안겹치면?
        // 백트래킹

        // 부분합

        // 완전탐색
        // (배열 1 + 배열 2 + 배열 3) + (배열 4)
        // 4000 ^ 3 안됨

        // 이분탐색 쓰기
        // (배열 1 + 배열 2) + (배열 3 + 배열 4)
        // 부분합 구하기: 4000 ^ 2 + 4000 ^ 2 = 16_000_000 + 16_000_000
        // 이분 탐색으로 두 배열의 합이 0인지 판단하기:  4000 ^ 2 log 4000 ^ 2
        // 해시맵으로 판단하기: 4000 ^ 2


        // upper bound
        // lower bound

        // 투포인터


        int idx = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0 ; j < N; j++) {
                ab[idx] = arr[0][i] + arr[1][j];
                cd[idx++] = arr[2][i] + arr[3][j];
            }
        }

        Arrays.sort(ab);
        Arrays.sort(cd);

        int preNum = Integer.MIN_VALUE;
        int preVal = 0;
        long answer = 0;
        for (int i : ab) {
            if (preNum == i) {
                answer += preVal;
            }
            else {
                preVal = upper_bound(cd, -i) - lower_bound(cd, -i);
                preNum = i;
                answer += preVal;
            }
        }
        System.out.println(answer);
    }

    private static int upper_bound(int[] nums, int key) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;

            if (key >= nums[mid]) left = mid + 1;
            else right = mid - 1;
        }

        return left;
    }

    private static int lower_bound(int[] nums, int key) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;

            if (key <= nums[mid]) right = mid - 1;
            else left = mid + 1;
        }

        return left;
    }

    private static void input() throws IOException {
        InputReader r = new InputReader("C:\\Users\\workspace\\boj\\src\\test\\java\\합이0인네정수\\input.txt");

        N = r.nextInt();

        arr = new int[4][N];
        ab = new int[N * N];
        cd = new int[N * N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < 4; j++) {
                arr[j][i] = r.nextInt();
            }
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

