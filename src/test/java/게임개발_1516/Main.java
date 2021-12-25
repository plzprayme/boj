package 게임개발_1516;

import java.io.*;
import java.util.*;

import org.junit.jupiter.api.Test;

class Main {

    static int N;
    static int[] time;
    static int[] indegree;

    static List<Integer>[] out;

    @Test
    public static void main(String[] args) throws IOException {
        input();
        solution();
    }

    private static void solution() {
        int[] currentTime = new int[N + 1];

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= N; i++) {
            if (indegree[i] == 0) {
                queue.add(i);
                currentTime[i] = time[i];
            }
        }

        while (!queue.isEmpty()) {
            int now = queue.poll();

            for (int next : out[now]) {
                currentTime[next] = Math.max(currentTime[next], currentTime[now] + time[next]);
                if (--indegree[next] == 0) queue.add(next);
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= N; i++) {
            sb.append(currentTime[i]).append('\n');
        }
        System.out.println(sb);
    }

    private static void input() throws IOException {
        InputReader r = new InputReader("C:\\Users\\workspace\\boj\\src\\test\\java\\게임개발_1516\\input.txt");

        N = r.nextInt();
        time = new int[N + 1];

        out = new List[N + 1];
        for (int i = 1; i <= N; i++) {
            out[i] = new ArrayList<>();
        }

        indegree = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            int t = r.nextInt();
            time[i] = t;

            while (true) {
                int n = r.nextInt();
                if (n == -1) break;
                out[n].add(i);
                indegree[i]++;
            }

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

