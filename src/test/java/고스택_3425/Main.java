package 고스택_3425;

import java.io.*;
import java.util.*;

import org.junit.jupiter.api.Test;

class Main {

    static InputReader r;
    static Stack<Integer> stack = new Stack<>();

    @Test
    public static void main(String[] args) throws IOException {
        input();
        solution();
    }

    private static void solution() {
        // 고스택은 숫자만 저장할 수 있다.

        // NUM X = 스택의 가장 위에 저장
        // POP 스택 가장 위의 숫자를 제거
        // INV: 부호를 바꾼다.
        // DUP: 첫번째 숫자를 스택의 가장위에 저장
        // SWP 첫번째와 두번째 숫자의 위치를 서로 바꾼다.
        // ADD: 첫번쨰 숫자와 두번째 더한다.
        // SUB: 첫번째 두번째 뺀다.
        // MUL: 첫번쨰 두번쨰 곱한다.
        // DIV: 첫번째 두번쨰 나눈 몫 저장한다. 두번쨰가 피제수 첫째수가 제수
        // MOD: 첫번째 숫자로 두번째 숫자를 나눈 나머지 저장 두번째 숫자가 피제수, 첫번째 숫자가 제수


    }
    private static void input() throws IOException {
        r = new InputReader("C:\\Users\\workspace\\boj\\src\\test\\java\\고스택_3425\\input.txt");

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
