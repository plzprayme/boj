package 교환_1039;

import java.io.*;
import java.util.*;

import org.junit.jupiter.api.Test;

class Main {

    static int N, M;
    static String K;

    static int answer = -1;

    static Set<String>[] dp;

    @Test
    public static void main(String[] args) throws IOException {
        input();
        solution();
    }

    private static void solution() {
        // i랑 j랑 바꾼다.
        // i < j 이다.

        // 7 자리의 모든 숫자를 바꿔본다면? 완전탐색의 시간 복잡도는?
        // O(M-1! ^ K) = O(6! ^ K) = O(6 * 5 * 4 * 3 * 2 ^ 10) = 불가능.

        // 1_111_111

        dfs(0, K);
        System.out.println(answer);
    }

    private static void dfs(int m, String k) {
        if (M == m) {
            answer = Math.max(Integer.parseInt(k), answer);
        } else {
            for (int i = 0; i < K.length(); i++) {
                for (int j = i + 1; j < K.length(); j++) {
                    String next = swap(k, i, j);
                    if (next.charAt(0) == '0') continue;
                    if (dp[m].contains(next)) continue;
                    dp[m].add(next);
                    dfs(m + 1, next);
                }
            }
        }
    }

    private static String swap(String s, int left, int right) {
        char[] arr = s.toCharArray();
        char tmp = arr[left];
        arr[left] = arr[right];
        arr[right] = tmp;
        return String.valueOf(arr);
    }

    private static void input() throws IOException {
        InputReader r = new InputReader("C:\\Users\\workspace\\boj\\src\\test\\java\\교환_1039\\input.txt");
        N = r.nextInt(); M = r.nextInt();
        K = String.valueOf(N);

        dp = new Set[M];
        for (int i = 0; i < M; i++) {
            dp[i] = new HashSet<>();
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

