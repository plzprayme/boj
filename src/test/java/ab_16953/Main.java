package ab_16953;

import java.io.*;
import java.util.*;

import org.junit.jupiter.api.Test;

class Main {

    static int A, B;
    static int answer = Integer.MAX_VALUE;

    @Test
    public static void main(String[] args) throws IOException {
        input();
        solution();
    }

    private static void solution() {
        // 2를 곱한다.
        // 1을 수의 가장 오른쪽에 추가한다.. (N * 10) + 1

        // case 1. 그냥 2배씩
        // 2 16
        // 2 4 8 16

        // case 2. 2배하다가 1추가
        // 2 162
        // 2 4 8 81 162

        // case 3.
        // 4 42
        // 4 8 16 32 64X
        // 41 82X
        // 4 8 81X

        // case 4.
        // 100 40021
        // 100 200 400 800 1600 3200 6400 12800 25600 51200X
        // 100 200 400 800 1600 3200 6400 12800 256001X
        // 100 200 400 800 1600 3200 6400 128001X
        // 100 200 400 800 1600 3200 64001X
        // 100 200 400 800 1600 32001 64002X
        // 100 200 400 800 16001 32002 64003X
        // 100 200 400 8001 16002 32004 64008X
        // 100 200 4001 8002 16004 32008 64016X
        // 100 2001 4002 8004 16016 32032 64064X

        // 42에서 반대로 간다? 42 -> 4
        // 42 21 2X
        // 42 21X

        reverseTracking(B, 1);

        if (answer == Integer.MAX_VALUE) System.out.println(-1);
        else System.out.println(answer);
    }

    static void reverseTracking(int n, int depth) {
        if (n == A) {
            answer = Math.min(answer, depth);
        } else if (n > A) {
            if (n % 10 == 1) {
                // 1로 끝나는 경우 1을 뗀다.
                // 한자리 수 일때는?
                reverseTracking(n / 10, depth + 1);
            } else if (n % 2 == 0) {
                // 2로 나누어 떨어지는 경우 2로 나눈다.
                reverseTracking(n / 2, depth + 1);
            }
        }
    }

    private static void input() throws IOException {
        InputReader r = new InputReader("C:\\Users\\workspace\\boj\\src\\test\\java\\ab_16953\\input.txt");

        A = r.nextInt();
        B = r.nextInt();
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
