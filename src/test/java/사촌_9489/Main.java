package 사촌_9489;

import java.io.*;
import java.util.*;

import org.junit.jupiter.api.Test;

class Main {

    static InputReader r;

    static Map<Integer, Integer> nodeLevelCash = new HashMap<>();
//    static Set<Node> nodeLevelCash = new HashSet<>();
    static int[] nodeCount = new int[1_000];



    private static void solution() throws IOException {
        // level 1: 1
        // level 2: 3 4 5
        // level 3: 89 / 15 / 30 31 32

        // 해당 레벨의 노드 수를 알고 있는 배열
        // 노드와 레벨을 저장하는 Set
        // 레벨 별로 노드를 저장하는 로직
        StringBuilder sb = new StringBuilder();
        while (true) {
            int N = r.nextInt();
            int K = r.nextInt();

            if (N == 0 && K == 0) {
                System.out.println(sb);
                return;
            }

            int currentLevel = 0;
            int parentNodeCount = 1;
            int pre = r.nextInt();
            int childCount = 1;
            nodeLevelCash.put(pre, currentLevel);

            for (int i = 1; i < N; i++) {
                int cur = r.nextInt();
                nodeLevelCash.put(cur, currentLevel);
                if (pre + 1 == cur) {
                    // 연속된 수열일 때
                    childCount++;
                } else {
                    // 연속 수열이 아닐 때
                    parentNodeCount--;
                    if (parentNodeCount == 0) {
                        nodeCount[currentLevel] = childCount;
                        parentNodeCount = nodeCount[currentLevel];
                        currentLevel++;

                        childCount = 1;
                    } else {
                        childCount++;
                    }
                }

                if (i == N - 1) {
                    nodeCount[currentLevel] = childCount;
                }

                pre = cur;
            }


            int level = nodeLevelCash.get(K);
            sb.append(nodeCount[level] - 1).append('\n');
        }
    }

    static class Node {
        int n, v;

        public Node(int n, int v) {
            this.n = n;
            this.v = v;
        }

        @Override
        public boolean equals(Object o) {
            Node node = (Node) o;
            return n == node.n;
        }
    }

    private static void input() throws IOException {
        r = new InputReader("C:\\Users\\workspace\\boj\\src\\test\\java\\사촌_9489\\input.txt");
    }

    @Test
    public static void main(String[] args) throws IOException {
        input();
        solution();
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

