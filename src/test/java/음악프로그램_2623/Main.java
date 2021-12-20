package 음악프로그램_2623;

import java.io.*;
import java.util.*;

import org.junit.jupiter.api.Test;

class Main {

    static int N, M;

    static int[] indegree;
    static List<Integer>[] graph;


    static StringBuilder sb = new StringBuilder();


    @Test
    public static void main(String[] args) throws IOException {
        input();
        solution();
    }

    private static void solution() {
        // 싸이클을 탐색하거나?
        // 어차피 0에 추가가 안되니까 (문제의 조건 N 줄) 에 위배됨을 판단하자.

        // indegree 0 인 녀석 찾기
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= N; i++) {
            if (indegree[i] == 0) queue.add(i);
        }


        List<Integer> answer = new ArrayList<>();
        while (!queue.isEmpty()) {
            int cur = queue.poll();
            answer.add(cur);

            for (int next : graph[cur]) {
                if (--indegree[next] == 0) queue.add(next);
            }
        }

        if (answer.size() == N) {
            for (int i : answer) sb.append(i).append('\n');
        } else sb.append(0);
        System.out.println(sb);
    }

    private static void input() throws IOException {
        InputReader r = new InputReader("C:\\Users\\workspace\\boj\\src\\test\\java\\음악프로그램_2623\\input.txt");
        N = r.nextInt(); M = r.nextInt();

        graph = new List[N + 1];
        for (int i = 1; i <= N; i++) graph[i] = new ArrayList<>();

        indegree = new int[N + 1];

        for (int i = 0; i < M; i++) {
            int k = r.nextInt();
            int pre = r.nextInt();
            for (int j = 1; j < k; j++) {
                int cur = r.nextInt();
                graph[pre].add(cur);
                indegree[cur]++;
                pre = cur;
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

