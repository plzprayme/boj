package 줄세우기_2252;

import java.io.*;
import java.util.*;

import org.junit.jupiter.api.Test;

class Main {

    static int N, M;

    static int[] indegree;
    static List<Integer>[] graph;

    @Test
    public static void main(String[] args) throws IOException {
        input();
        solution();
    }

    private static void solution() {
        Queue<Integer> q = new LinkedList<>();
        for (int i = 1; i <= N; i++) {
            if (indegree[i] == 0) q.add(i);
        }

        StringBuilder sb = new StringBuilder();
        while (!q.isEmpty()) {
            int now = q.poll();
            sb.append(now).append(' ');

            // indegree를 감소 시킨다. (graph에서 제거한다.)
            // indegree가 0인 노드를 추가한다.
            // O(V)
            for (int next : graph[now]) {
                if (--indegree[next] == 0) q.add(next);
            }

        }
        System.out.println(sb);
    }

    private static void input() throws IOException {
        InputReader r = new InputReader("C:\\Users\\workspace\\boj\\src\\test\\java\\줄세우기_2252\\input.txt");
        N = r.nextInt(); M = r.nextInt();
        indegree = new int[N + 1];

        graph = new List[N + 1];
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        // indegree 계산 O(E)
        // 그래프 구성 left:= 먼저 와야 하는 학생 right:= 늦게 와야 하는 학생
        for (int i = 0; i < M; i++) {
            int left = r.nextInt();
            int right = r.nextInt();
            graph[left].add(right);
            indegree[right]++;
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

