package 크게만들기_2812;

import java.io.*;
import java.util.*;

import org.junit.jupiter.api.Test;

class Main {

    static int K, N;
    static String number;

    @Test
    public static void main(String[] args) throws IOException {
        input();
        solution();
    }

    private static void solution() {
        // N자리 숫자가 주어졌을 때, 여기서 숫자 K개를 지워서 얻을 수 있는 가장 큰 수 구하는 프로그램을 작성

        // 현재 자리수가 오른쪽 자리 수보다 작으면 지운다.
        // 1924 -> 924 -> 94
        // 12924 -> 2924 -> 924 -> 94
        // 9321 -> 932 -> 93 -> 9


        while (K > 0) {
            for (int i = 0; i < number.length(); i++) {
                if (K == 0) break;

                if (i + 1 == number.length()) {
                    number = number.substring(0, i);
                    K--;
                    continue;
                }

                if (number.charAt(i) < number.charAt(i + 1)) {
                    number = number.substring(0, i) + number.substring(i + 1);
                    K--;
                    break;
                }
            }
        }


        System.out.println(number);

    }

    private static void input() throws IOException {
        InputReader r = new InputReader();

        N = r.nextInt();
        K = r.nextInt();

        number = r.nextLine();
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

