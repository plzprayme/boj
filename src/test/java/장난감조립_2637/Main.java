package 장난감조립_2637;

import java.io.*;
import java.util.*;

import org.junit.jupiter.api.Test;

class Main {

    static int N, M;

    static int[][] need;
    static int[] outdegree;
    static int[] indegree;
    static List<Integer>[] out;

    @Test
    public static void main(String[] args) throws IOException {
        input();
        solution();
    }

    private static void solution() {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(N);

        int[] answer = new int[N + 1];
        answer[N] = 1;
        while (!queue.isEmpty()) {
            int now = queue.poll();

            for (int next : out[now]) {
                answer[next] += answer[now] * need[now][next];
                if (--outdegree[next] == 0) queue.add(next);

            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= N; i++) {
            if (indegree[i] == 0) {
                sb.append(i).append(' ').append(answer[i]).append('\n');
            }
        }
        System.out.println(sb);
    }

    private static void input() throws IOException {
        InputReader r = new InputReader("C:\\Users\\workspace\\boj\\src\\test\\java\\장난감조립_2637\\input.txt");
        N = r.nextInt();
        M = r.nextInt();

        indegree = new int[N + 1];
        need = new int[N + 1][N + 1];
        outdegree = new int[N + 1];
        out = new List[N + 1];
        for (int i = 1; i <= N; i++) {
            out[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            int dst = r.nextInt();
            int src = r.nextInt();
            int count = r.nextInt();
            need[dst][src] = count;
            out[dst].add(src);
            outdegree[src]++;
            indegree[dst]++;
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
