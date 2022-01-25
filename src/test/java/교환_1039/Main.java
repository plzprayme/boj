package 교환_1039;

import java.io.*;
import java.util.*;

import org.junit.jupiter.api.Test;

class Main {

    static int N, M;
    static char[] K;

    static int answer = -1;

    @Test
    public static void main(String[] args) throws IOException {
        input();
        solution();
    }

    private static void solution() {
        // i랑 j랑 바꾼다.
        // i < j 이다.

        // 7 자리의 모든 숫자를 바꿔본다면? 완전탐색의 시간 복잡도는?
        // O(M-1! * K) = O(6! * K) = O(6 * 5 * 4 * 3 * 2 * 10) = 7200 가능.

        backtracking(0, K);
        System.out.println(answer);
    }

    private static void backtracking(int m, char[] k) {
        if (M == m) {
            answer = Math.max(Integer.parseInt(String.valueOf(k)), answer);
        } else {
            for (int i = 0; i < K.length; i++) {
                for (int j = i + 1; j < K.length; j++) {
                    swap(k, i, j);
                    if (k[0] == '0') {
                        swap(k, j, i);
                        continue;
                    }
                    backtracking(m + 1, k);
                    swap(k, j, i);
                }
            }
        }
    }

    private static char[] swap(char[] s, int left, int right) {
        char tmp = s[left];
        s[left] = s[right];
        s[right] = tmp;
        return s;
    }

    private static void input() throws IOException {
        InputReader r = new InputReader("C:\\Users\\workspace\\boj\\src\\test\\java\\교환_1039\\input.txt");
        N = r.nextInt(); M = r.nextInt();
        K = String.valueOf(N).toCharArray();
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

