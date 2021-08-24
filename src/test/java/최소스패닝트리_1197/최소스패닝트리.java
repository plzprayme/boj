package 최소스패닝트리_1197;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

import org.junit.jupiter.api.Test;

public class 최소스패닝트리 {
    static int V;
    static int[] dp;
    @Test
    public static void main(String[] args) throws IOException {
        BufferedReader r = new BufferedReader(
            new FileReader("C:\\Users\\prayme\\workspace\\boj\\src\\test\\java\\최소스패닝트리_1197\\input.txt"));

        StringTokenizer st = new StringTokenizer(r.readLine());
        V = parse(st.nextToken());
        int E = parse(st.nextToken());

        PriorityQueue<Node> nodes = new PriorityQueue<>();
        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(r.readLine());
            int src = parse(st.nextToken());
            int dst = parse(st.nextToken());
            int w = parse(st.nextToken());
            nodes.add(new Node(src, dst, w));
        }

        dp = new int[V + 1];
        for (int i = 1; i <= V; i++) {
            dp[i] = i;
        }

        System.out.println(kruskal(nodes));
    }

    private static int kruskal(PriorityQueue<Node> nodes) {
        int  res = 0, cnt = 0;
        while (!nodes.isEmpty()) {
            Node now = nodes.poll();

            if (union(now.src, now.dst)) {
                res += now.w;
                if (++cnt == V - 1) return res;
            }
        }

        return res;
    }

    private static boolean union(int src, int dst) {
        int srcRoot = find(src);
        int dstRoot = find(dst);

        if (srcRoot == dstRoot) return false;
        dp[srcRoot] = dstRoot;
        return true;
    }

    private static int find(int src) {
        if (src == dp[src]) return src;
        return dp[src] = find(dp[src]);
    }

    private static int parse(String s) {
        return Integer.parseInt(s);
    }

    private static class Node implements Comparable<Node> {
        int src, dst, w;

        public Node(int src, int dst, int w) {
            this.src = src;
            this.dst = dst;
            this.w = w;
        }

        @Override
        public int compareTo(Node o) {
            return Integer.compare(w, o.w);
        }
    }
}
