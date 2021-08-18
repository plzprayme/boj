package 로또_2758;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;

import org.junit.jupiter.api.Test;

public class 로또 {
    @Test
    public static void main(String[] args) throws IOException {
        BufferedReader r = new BufferedReader(
            new FileReader("C:\\Users\\prayme\\workspace\\boj\\src\\test\\java\\로또_2758\\input.txt"));

        int C = parse(r.readLine());
        for (int K = 0; K < C; K++) {
            StringTokenizer st = new StringTokenizer(r.readLine());
            int N = parse(st.nextToken());
            int M = parse(st.nextToken());

            Stack<State> answer = new Stack<>();
            for (int i = 1; i * pow(N - 1) <= M; i++) {
                answer.add(new State(i, N - 1));
            }

            int count = 0;
            while (!answer.isEmpty()) {
                State s = answer.pop();
                int currentN = s.N;
                if (currentN == 0) {
                    count++;
                } else {
                    for (int i = s.nextNumber(); i * pow(currentN - 1) <= M; i++) {
                        answer.add(s.get(i));
                    }
                }
            }
            System.out.println(count);
        }

    }

    private static int pow(int N) {
        return (int)Math.pow(2, N);
    }

    private static int parse(String s) {
        return Integer.parseInt(s);
    }

    private static class State {
        Stack<Integer> numbers = new Stack<>();
        int N;

        public State(int start, int n) {
            numbers.add(start);
            N = n;
        }

        private State(Stack<Integer> numbers, int n) {
            this.numbers = numbers;
            N = n;
        }

        public int nextNumber() {
            return numbers.peek() * 2;
        }

        public State get(int next) {
            Stack<Integer> stack = new Stack<>();
            for (int i : numbers)
                stack.add(i);
            stack.add(next);
            return new State(stack, N - 1);
        }

        @Override
        public String toString() {
            return "State{" +
                "numbers=" + numbers +
                ", N=" + N +
                '}';
        }
    }
}
