package 이진검색트리_5639;

import java.io.*;
import java.util.*;

import org.junit.jupiter.api.Test;


class Main {

    static BST bst;

    private static class BST {

        private final Node root;
        private StringBuilder sb = new StringBuilder();

        public BST(Node root) {
            this.root = root;
        }

        public void add(int val) {
            Node newNode = new Node(val, null, null);

            Node current = root;
            while (Objects.nonNull(current)) {
                if (current.value < newNode.value) {
                    if (Objects.isNull(current.right)) {
                        current.right = newNode;
                        return;
                    }
                    current = current.right;
                } else {
                    if (Objects.isNull(current.left)) {
                        current.left = newNode;
                        return;
                    }
                    current = current.left;
                }
            }
        }

        public String post() {
            post(root);
            return sb.toString();
        }

        public void post(Node node) {
            if (Objects.nonNull(node.left)) {
                post(node.left);
            }

            if (Objects.nonNull(node.right)) {
                post(node.right);
            }

            sb.append(node.value).append('\n');
        }


        static class Node {
            private final int value;
            private Node left;
            private Node right;

            public Node(int value, Node left, Node right) {
                this.value = value;
                this.left = left;
                this.right = right;
            }
        }
    }

    private static void solution() {
		// 전위 순회
		// 50 30 24 5 28 45 98 52 60

		// 후위 순회
		// 5 28 24 45 30 60 52 98

        // 트리 생성 N log N
        // 후위 순회 O(n)
        System.out.println(bst.post());
    }

    private static void input() throws IOException {
        InputReader r = new InputReader("C:\\Users\\prayme\\workspace\\boj\\src\\test\\java\\이진검색트리_5639\\input.txt");
        bst = new BST(new BST.Node(r.nextInt(), null, null));

        while (true) {
            bst.add(r.nextInt());
        }

    }

    @Test
    public static void main(String[] args) throws IOException {
        try {
            input();
        } catch (Exception e) {
            solution();
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
