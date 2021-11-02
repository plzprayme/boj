package 네웹;

import java.util.Stack;

public class 스택 {

    private class Queue {
        Stack<Integer> in = new Stack<>();
        Stack<Integer> out = new Stack<>();

        private void push(int i) {
            in.add(i);
        }

        private int pop() {
            if (out.isEmpty()) {
                while (!in.isEmpty()) {
                    out.add(in.pop());
                }
            }

            return out.pop();
        }
    }
}
