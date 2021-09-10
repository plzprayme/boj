package 카카오기출;

import java.util.Stack;
import java.util.StringTokenizer;

import org.junit.jupiter.api.Test;

public class 표편집 {

    @Test
    public void main1() {
        solution(
            8, 2,
            new String[] {
                "D 2",
                "C",
                "U 3",
                "C",
                "D 4",
                "C",
                "U 2",
                "Z",
                "Z"
            }
        );

        solution(
            8, 2,
            new String[] {
                "D 2",
                "C",
                "U 3",
                "C",
                "D 4",
                "C",
                "U 2",
                "Z",
                "Z",
                "U 1",
                "C"
            }
        );
    }

    public String solution(int n, int k, String[] cmd) {
        int[] pre = new int[n];
        int[] next = new int[n];

        for (int i = 0; i < n; i++) {
            pre[i] = i - 1;
            next[i] = i + 1;
        }
        next[n - 1] = -1;

        Stack<Node> stack = new Stack<>();
        StringBuilder sb = new StringBuilder("O".repeat(n));
        for (int i = 0; i < cmd.length; i++) {
            StringTokenizer st = new StringTokenizer(cmd[i]);
            String action = st.nextToken();

            if (action.equals("U")) {
                int step = Integer.parseInt(st.nextToken());
                while (step-- > 0) {
                    k = pre[k];
                }
            } else if (action.equals("D")) {
                int step = Integer.parseInt(st.nextToken());
                while (step-- > 0) {
                    k = next[k];
                }
            } else if (action.equals("C")) {
                stack.add(new Node(pre[k], k, next[k]));
                if (pre[k] != -1) next[pre[k]] = next[k];
                if (next[k] != -1) pre[next[k]] = pre[k];
                sb.setCharAt(k, 'X');

                if (next[k] != -1) k = next[k];
                else k = pre[k];
            } else if (action.equals("Z")) {
                Node node = stack.pop();
                if (node.pre != -1) next[node.pre] = node.cur;
                if (node.next != -1) pre[node.next] = node.cur;
                sb.setCharAt(node.cur, 'O');
            }
        }
        return sb.toString();
    }

    public class Node {
        int pre, cur, next;

        public Node(int pre, int cur, int next) {
            this.pre = pre;
            this.cur = cur;
            this.next = next;
        }
    }

}
