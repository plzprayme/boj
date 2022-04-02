package 쇼미더코드.나는정말휘파람을못불어;

import java.io.*;
import java.util.*;

import org.junit.jupiter.api.Test;

class Main {

    static int N;
    static String S;
    static int[] W, WH, WHE, WHEE;

    @Test
    public static void main(String[] args) throws IOException {
        input();
        solution();
    }

    private static void solution() {
        // 대문자로 구성된 문자열 S로 나타낼 수 있다.
        // WHEE -> 유사 휘파람 문자열
        // 유사 휘파람 문자열 뒤에 E 붙이면 무조건 유사 휘파람 문자열
        // 유사 휘파람 문자열의 부분 수열의 개수 구하라

        // N이 200_000
        // W H E E의 순서는 지켜져야 한다.
        // W H E E E 는 상관 없다.
        // DP 이고 N의 인덱스 까지의 W의 숫자, WH의 숫자, WHE의 숫자, WHEE의 숫자, WHEEE ... 의 숫자를 구하면 될 것 같다.

        if (S.charAt(0) == 'W') {
            W[0] = 1;
        }

        for (int i = 1; i < N; i++) {
            char now = S.charAt(i);

            if (now == 'W') {
                W[i] = W[i - 1] + 1;

                WH[i] = WH[i - 1];
                WHE[i] = WHE[i - 1];
                WHEE[i] = WHEE[i - 1];
            } else if (now == 'H') {
                WH[i] = WH[i - 1] + W[i - 1];

                W[i] = W[i - 1];
                WHE[i] = WHE[i - 1];
                WHEE[i] = WHEE[i - 1];
            } else if (now == 'E') {
                WHE[i] = WHE[i - 1] +  WH[i - 1];
                WHEE[i] = (WHEE[i - 1] + WHEE[i - 1]) % 1_000_000_007 + WHE[i - 1];

                W[i] = W[i - 1];
                WH[i] = WH[i - 1];
            } else {
                W[i] = W[i - 1];
                WH[i] = WH[i - 1];
                WHE[i] = WHE[i - 1];
                WHEE[i] = WHEE[i - 1];
            }

            W[i] %= 1_000_000_007;
            WH[i] %= 1_000_000_007;
            WHE[i] %= 1_000_000_007;
            WHEE[i] %= 1_000_000_007;
        }

        System.out.println(WHEE[N - 1]);
    }

    private static void input() throws IOException {
        InputReader r = new InputReader("C:\\Users\\workspace\\boj\\src\\test\\java\\쇼미더코드\\나는정말휘파람을못불어\\input.txt");

        N = r.nextInt();
        S = r.nextLine();

        W = new int[N];
        WH = new int[N];
        WHE = new int[N];
        WHEE = new int[N];
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

        public String nextLine() throws IOException {
            return r.readLine();
        }
    }


}
