package 계단수_1562;

import java.io.*;
import java.util.*;

import org.junit.jupiter.api.Test;

class Main {

    static int N;
    static int[][][][] dp;

    @Test
    public static void main(String[] args) throws IOException {
        input();
        solution();
    }

    private static void solution() {

        // 0 ~ 9 를 모두 사용해야하는게 너무 어렵다.
        // 0 으로도 시작할 수 없다.

        if (N < 10) {
            System.out.println(0);
            return;
        }

//        dp[10][9] = 1;
//
//        dp[11][8] = 1;
//        dp[11][9] = 1;
//        dp[11][1] = 1;

        // 시도 1. 시작 숫자에 따라서 결정하자 (실패)
        // 시도 2. i 번째 숫자가 K일 때 K +- 1 로 시작하는 N-i 길이의 경우의 수를 더하자 (실패)
        // 시도 3.
        // 시도 4. 0 ~ 9가 모두 등장 한 후와 전..?

        // 시작과 끝?



        // 0 ~ 9 가 모두 있으면서 계단 수
        // N = 10
        // 98 76 54 32 10

        // N = 11
        // 98 76 54 32 10 1
        // 89 87 65 43 21 0
        // 10 12 34 56 78 9

        // N = 12
        // 98 76 54 32 10 10
        // 98 76 54 32 10 12

        // 98 76 54 32 32 10
        // 98 76 54 54 32 10
        // 98 76 76 54 32 10
        // 98 98 76 54 32 10
        // 98 78 76 54 32 10

        // 89 87 65 43 21 01

        // 78 98 76 54 32 10



        // i 번째 숫자가 시작하는 부분과
        // N - i 길이의 경우의 수를 더한다.



        // N이 11일 때

        // 필요한 정보 다시 생각해보자.
        // 1. 지금 계단의 높이
        // 2. 0 ~ 9 를 모두 사용 했는지 (비트 마스킹)
        // 3. 계단의 시작 숫자 (0으로 시작하는지 체크 가능)
        // 4. 이전 계단과의 연관성?
        // 5. 내려갈 수도 있고 올라갈 수도 있다.

        dp = new int[N + 1][10][10][10];

        // 초기값
        for (int num = 1; num < 10; num++) {
            dp[1][num][num][num] = 1;
        }

        for (int len = 2; len <= N; len++) {
            for (int prev = 0; prev < 10; prev++) {
                for (int low = 0; low < 10; low++) {
                    for (int high = 0; high < 10; high++) {
                        for (int cur : new int[] {prev - 1, prev + 1}) {
                            if (cur < 0 || cur > 9) continue;
                            dp[len][cur][Math.min(low, cur)][Math.max(high, cur)] += dp[len -1][prev][low][high];
                            dp[len][cur][Math.min(low, cur)][Math.max(high, cur)] %= 1_000_000_000;
                        }
                    }
                }
            }
        }

        int answer = 0;
        for (int num = 0; num < 10; num++) {
            answer += dp[N][num][0][9];
            answer %= 1_000_000_000;
        }

        System.out.println(answer);
    }

    private static void input() throws IOException {
        InputReader r = new InputReader();
        N = r.nextInt();
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

