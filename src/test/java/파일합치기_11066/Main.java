package 파일합치기_11066;

import java.io.*;
import java.util.*;

import org.junit.jupiter.api.Test;

class Main {

    static InputReader r;

    static int N;
    static int[] files = new int[501];
    static int[][] sum = new int[501][501];
    static int[][] dp = new int[501][501];

    @Test
    public static void main(String[] args) throws IOException {
        r = new InputReader("C:\\Users\\workspace\\boj\\src\\test\\java\\파일합치기_11066\\input.txt");
        int t = r.nextInt();
        for (int i = 0; i < t; i++) {
            input();
            solution();
        }
    }

    private static void solution() {
        // 파일 합친 경우의 수를 모두 구해봐야겠다
        // 완전탐색 -> O(500!) 시간초과


        // l ~ r의 파일들을 합쳤을 때의 값
        for (int i = 1; i <= N; i++) {
            for (int j = i; j <= N; j++) {
                sum[i][j] = sum[i][j - 1] + files[j];
            }
        }


        // 합친 값들을 더 했을 때 최솟값 구하기
        // 결국엔 1 ~ N 까지를 더해야한다.
        // N = 4일 때의 경우의 수
        // 1, 2 ~ 4
        // 1 ~ 2, 3 ~4
        // 1 ~ 3, 4
        // N = 1
        for (int len = 2; len <= N; len++) {
            for (int i  = 1; i <= N - len + 1; i++) {
                int j = i + len - 1;
                dp[i][j] = Integer.MAX_VALUE;
                for (int k = i; k < j; k++) {
                    dp[i][j] = Math.min(dp[i][j], dp[i][k] + dp[k+1][j] + sum[i][j]);
                }
            }
        }


        System.out.println();
   }

    private static void input() throws IOException {
        N = r.nextInt();

        for (int i = 1; i <= N; i++) files[i] = r.nextInt();

        for (int i = 1; i <= N; i++) {
            sum[i][i] = files[i];
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

