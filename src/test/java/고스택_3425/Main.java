package 고스택_3425;

import java.io.*;
import java.math.BigInteger;
import java.util.*;

import org.junit.jupiter.api.Test;

class Main {

    static InputReader r;

    static int N;
    static String[] operations = new String[100_000];

    static int LIMIT = 1_000_000_000;
    static BigInteger LIMIT_BIG_INTEGER = new BigInteger("1000000000");
    static String ERROR = "ERROR";

    static StringBuilder sb = new StringBuilder();

    @Test
    public static void main(String[] args) throws IOException {
        r = new InputReader("C:\\Users\\workspace\\boj\\src\\test\\java\\고스택_3425\\input.txt");

        while (readOperation()) {
            N = r.nextInt();
            for (int i = 0; i < N; i++) {
                process(r.nextInt());
                sb.append('\n');
            }
            sb.append('\n');
        }

        System.out.println(sb);
    }

    private static void process(int start) {
        Stack<Integer> stack = new Stack<>();
        stack.add(start);


        int first;
        int second;
        int result;
        int count;

        BigInteger bigFirst;
        BigInteger bigSecond;
        BigInteger bigResult;
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
                        sb.append(ERROR);
                        return;
                    }

                    stack.pop();
                    break;
                }
                case "INV": {
                    if (stack.isEmpty()) {
                        sb.append(ERROR);
                        return;
                    }

                    stack.add(-stack.pop());
                    break;
                }

                case "DUP": {
                    if (stack.isEmpty()) {
                        sb.append(ERROR);
                        return;
                    }

                    stack.add(stack.peek());
                    break;
                }

                case "SWP": {
                    if (stack.size() < 2) {
                        sb.append(ERROR);
                        return;
                    }

                    first = stack.pop();
                    second = stack.pop();
                    stack.add(first);
                    stack.add(second);
                    break;
                }

                case "ADD": {
                    if (stack.size() < 2) {
                        sb.append(ERROR);
                        return;
                    }

                    first = stack.pop();
                    second = stack.pop();
                    result = first + second;
                    if (result > LIMIT) {
                        sb.append(ERROR);
                        return;
                    }

                    stack.add(result);
                    break;
                }

                case "SUB": {
                    if (stack.size() < 2) {
                        sb.append(ERROR);
                        return;
                    }

                    first = stack.pop();
                    second = stack.pop();
                    result = second - first;
                    if (result < -LIMIT) {
                        sb.append(ERROR);
                        return;
                    }
                    stack.add(result);
                    break;
                }

                case "MUL": {
                    if (stack.size() < 2) {
                        sb.append(ERROR);
                        return;
                    }

                    bigFirst = new BigInteger(String.valueOf(stack.pop()));
                    bigSecond = new BigInteger(String.valueOf(stack.pop()));
                    bigResult = bigFirst.multiply(bigSecond);
                    if (bigResult.compareTo(LIMIT_BIG_INTEGER) > 0) {
                        sb.append(ERROR);
                        return;
                    }

                    stack.add(bigResult.intValue());
                    break;
                }

                case "DIV": {
                    if (stack.size() < 2) {
                        sb.append(ERROR);
                        return;
                    }

                    first = stack.pop();
                    second = stack.pop();

                    if (first == 0) {
                        sb.append(ERROR);
                        return;
                    }

                    count = 0;
                    if (second < 0) count++;
                    if (first < 0) count++;
                    result = Math.abs(second) / Math.abs(first);

                    if (count == 1) {
                        stack.add(-result);
                    } else {
                        stack.add(result);
                    }
                    break;
                }

                case "MOD": {
                    if (stack.size() < 2) {
                        sb.append(ERROR);
                        return;
                    }

                    first = stack.pop();
                    second = stack.pop();

                    if (first == 0) {
                        sb.append(ERROR);
                        return;
                    }

                    result = Math.abs(second) % Math.abs(first);
                    if (second < 0) {
                        stack.add(-result);
                    } else {
                        stack.add(result);
                    }
                    break;
                }


            }
        }

        if (stack.size() == 1) sb.append(stack.pop());
        else sb.append(ERROR);
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
