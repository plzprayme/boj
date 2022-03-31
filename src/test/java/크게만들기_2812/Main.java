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


        // 지워졌는가에 대한 배열
        // 마지막 왼쪽 인덱스를 기억하고 있다.
        // 한칸을 지웠으면 지운 칸의 왼쪽 칸과 지운 칸의 오른쪽 칸을 비교할 수 있다.


        // 엣지 케이스
        // 500_000 499_999
        // 1 2222 .... 9

        // 엣지 케이스 2
        // 500_000 499_999
        // 1 2 3 2 3 2 3 2 3 9

        // 1회 순회하며 스택을 유지한다.
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < N; i++) {
            while (K > 0 && !stack.isEmpty() && stack.peek() < number.charAt(i)) {
                stack.pop();
                K--;
            }
            stack.push(number.charAt(i));
        }

        while (K-- > 0) {
            stack.pop();
        }

        StringBuilder answer = new StringBuilder();
        while (!stack.isEmpty()) {
            answer.append(stack.pop());
        }
        System.out.println(answer.reverse());
    }

    private static void input() throws IOException {
        InputReader r = new InputReader("C:\\Users\\workspace\\boj\\src\\test\\java\\크게만들기_2812\\input.txt");

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

