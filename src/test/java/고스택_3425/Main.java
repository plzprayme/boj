package 고스택_3425;

import java.io.*;
import java.util.*;

import org.junit.jupiter.api.Test;

class Main {

    static InputReader r;
    static Stack<Integer> stack = new Stack<>();

    static int N;
    static String[] operations = new String[100_000];

    @Test
    public static void main(String[] args) throws IOException {
        r = new InputReader("C:\\Users\\workspace\\boj\\src\\test\\java\\고스택_3425\\input.txt");

        while (readOperation()) {
            N = r.nextInt();
            for (int i = 0; i < N; i++) {
                process(r.nextInt());
            }
            System.out.println();
        }
    }

    private static void process(int start) {
        Stack<Integer> stack = new Stack<>();
        stack.add(start);

        f:
        for (int i = 0; i < 100_001; i++) {
            String op = operations[i];

            if (op.equals("END")) break;

            StringTokenizer st = new StringTokenizer(op);
            switch (st.nextToken()) {
                case "NUM": {
                    stack.add(Integer.parseInt(st.nextToken()));
                    break;
                }
                case "POP": {
                    if (stack.isEmpty()) {
                        System.out.println("ERROR");
                        break f;
                    }

                    stack.pop();
                    break;
                }
                case "INV": {
                    if (stack.isEmpty()) {
                        System.out.println("ERROR");
                        break f;
                    }

                    stack.add(-stack.pop());
                    break;
                }

                case "DUP": {
                    if (stack.isEmpty()) {
                        System.out.println("ERROR");
                        break f;
                    }

                    stack.add(stack.peek());
                    break;
                }

                case "SWP": {
                    if (stack.size() < 2) {
                        System.out.println("ERROR");
                        break f;
                    }

                    int first = stack.pop();
                    int second = stack.pop();
                    stack.add(first);
                    stack.add(second);
                    break;
                }

                case "ADD": {
                    if (stack.size() < 2) {
                        System.out.println("ERROR");
                        break f;
                    }

                    stack.add(stack.pop() + stack.pop());
                    break;
                }

                case "SUB": {
                    if (stack.size() < 2) {
                        System.out.println("ERROR");
                        break f;
                    }

                    int first = stack.pop();
                    int second = stack.pop();
                    stack.add(second - first);
                    break;
                }

                case "MUL": {
                    if (stack.size() < 2) {
                        System.out.println("ERROR");
                        break f;
                    }

                    stack.add(stack.pop() * stack.pop());
                    break;
                }

                case "DIV": {
                    if (stack.size() < 2) {
                        System.out.println("ERROR");
                        break f;
                    }

                    int first = stack.pop();
                    int second = stack.pop();
                    stack.add(second / first);
                    break;
                }

                case "MOD": {
                    if (stack.size() < 2) {
                        System.out.println("ERROR");
                        break f;
                    }

                    int first = stack.pop();
                    int second = stack.pop();
                    stack.add(second % first);
                    break;
                }


            }
        }


        if (stack.size() == 1) System.out.println(stack.pop());
        else System.out.println("ERROR");
    }

    private static boolean readOperation() throws IOException {
        int count = 0;
        while (true) {
            String op = r.nextLine();
            if (op.equals("")) continue;
            operations[count++] = op;
            if (op.equals("END")) return true;
            else if (op.equals("QUIT")) return false;
        }
    }

    private static void solution() throws IOException {
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

        Stack<Integer> stack = new Stack<>();
        stack.add(r.nextInt());

        w:
        while (true) {
            StringTokenizer st = new StringTokenizer(r.nextLine());
            String op = st.nextToken();

            switch (op) {

                case "DUP": {
                    stack.add(stack.peek());
                    break;
                }

                case "NUM": {
                    stack.add(Integer.parseInt(st.nextToken()));
                    break;
                }

                case "POP": {
                    if (stack.isEmpty()) {
                        System.out.println("ERROR");
                        break;
                    }
                    stack.pop();
                    break;
                }

                case "INT": {
                    if (stack.isEmpty()) {
                        System.out.println("ERROR");
                        break;
                    }
                    stack.add(-stack.pop());
                    break;
                }

                case "ADD":
                case "SWP":
                case "SUB":
                case "MUL":
                case "DIV":
                case "MOD": {
                    if (stack.size() < 2) {
                        System.out.println("ERROR");
                        break w;
                    }

                    int first = stack.pop();
                    int second = stack.pop();

                    if (op.equals("SWP")) {
                        stack.add(first);
                        stack.add(second);
                        break;
                    }


                    int result = 0;
                    switch (op) {
                        case "ADD": {
                            result = first + second;
                            break;
                        }
                        case "SUB": {
                            result = second - first;
                            break;
                        }
                        case "MUL": {
                            result = first * second;
                            break;
                        }
                        case "DIV": {
                            result = second / first;
                            break;
                        }
                        case "MOD": {
                            result = second % first;
                            break;
                        }
                    }

                    stack.add(result);
                }

                case "END": {
                    break w;
                }

            }

        }

        if (stack.size() != 1) System.out.println("ERROR");
        else System.out.println(stack.pop());


    }

    private static void input(String op) throws IOException {
        operations[0] = op;
        for (int i = 1; ; i++) {
            if (operations[i].equals("END")) return;
            operations[i] = r.nextLine();
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

        public String nextLine() throws IOException {
            return r.readLine();
        }
    }


}
