package 사촌_9489;

import java.io.*;
import java.util.*;

import org.junit.jupiter.api.Test;

class Main {

    static InputReader r;

    static int N, K;

    static int kParent;

    static int answer;

    static StringBuilder sb = new StringBuilder();

    static int[] nodes;
    static Map<Integer, List<Integer>> tree;

    private static void solution() throws IOException {
        nodes = new int[N];
        for (int i = 0; i < N; i++) nodes[i] = r.nextInt();

        tree = new HashMap<>();

        Queue<Integer> parentQueue = new LinkedList<>();
        parentQueue.add(nodes[0]);

        int nodeIndex = 1;
        while (nodeIndex < N - 1) {
            int parent = parentQueue.poll();

            List<Integer> child = new ArrayList<>();
            for (int i = nodeIndex; i < N - 1; i++) {
                int cur = nodes[i];
                int next = nodes[i + 1];

                // 현재를 일단 parent에 붙인다.
                child.add(cur);
                parentQueue.add(cur);

                if (cur == K) {
                    kParent = parent;
                }

                // 마지막일 때
                if (i == N - 2) {
                    if (cur + 1 == next) {
                        // 다음도 child에 포함일때
                        child.add(next);
                        tree.put(parent, child);
                    } else {
                        // child 포함 아닐 때
                        // 지금까지를 저장하고
                        tree.put(parent, child);

                        // 다음꺼도 저장해준다.
                        parent = parentQueue.poll();
                        tree.put(parent, List.of(next));
                    }

                    /// 가장 마지막 노드가 K의 Parent인 경우..
                    if (next == K) {
                        kParent = parent;
                    }
                    nodeIndex = N;
                    break;
                }

                if (cur + 1 != next) {
                    tree.put(parent, child);
                    nodeIndex = i + 1;
                    break;
                }
            }
        }

        if (kParent == nodes[0] && nodes[0] == K) {
            answer = 0;
        } else {
            dfs(nodes[0]);
        }

        sb.append(answer).append('\n');
    }

    private static void dfs(int node) {
        if (!tree.containsKey(node)) return;
        List<Integer> child = tree.get(node);
        if (Objects.isNull(child)) return;
        if (child.contains(kParent)) {
            int count = 0;
            for (Integer childNode : child) {
                if (childNode == kParent) continue;
                count += tree.get(childNode).size();
            }
            answer = count;
        } else {
            for (Integer childNode : child) {
                dfs(childNode);
            }
        }
    }

    private static void input() throws IOException {
        r = new InputReader("C:\\Users\\workspace\\boj\\src\\test\\java\\사촌_9489\\input.txt");
    }

    @Test
    public static void main(String[] args) throws IOException {
        input();
        while (true) {
            N = r.nextInt(); K = r.nextInt();
            if (N == 0 && K == 0) break;
            solution();
        }
        System.out.println(sb);
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

