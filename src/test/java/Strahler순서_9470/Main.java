package Strahler순서_9470;

import java.io.*;
import java.util.*;

import org.junit.jupiter.api.Test;

class Main {

    static int[] strahler;

    static int[] indegree;
    static List<Integer>[] in;
    static List<Integer>[] out;

    static int M, P;
    static InputReader r;

    static StringBuilder sb = new StringBuilder();

    @Test
    public static void main(String[] args) throws IOException {
        r = new InputReader("C:\\Users\\workspace\\boj\\src\\test\\java\\Strahler순서_9470\\input.txt");

        int T = r.nextInt();
        for (int t = 1; t <= T; t++) {
            input();
           int answer = solution();
           sb.append(t).append(' ').append(answer).append('\n');
        }

        System.out.println(sb);
    }

    private static int solution() {
        // TODO

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= M; i++) {
            if (indegree[i] == 0) queue.add(i);
        }

        while (!queue.isEmpty()) {
            int now = queue.poll();

            // Strahler 순서 계산
            if (out[now].isEmpty()) strahler[now] = 1;
            else {
                // 최대값 구하기
                int max = 1;
                for (int tmp : out[now]) {
                    max = Math.max(strahler[tmp], max);
                }

                // 최대값이 유일한지 확인
                int count = 0;
                for (int tmp : out[now]) {
                    if (strahler[tmp] == max) {
                        count++;
                    }
                }

                if (count == 1) strahler[now] = max;
                else strahler[now] = max + 1;
            }

            // 다음 탐색 노드 결정
            for (int next : in[now]) {
                if (--indegree[next] == 0) {
                    queue.add(next);
                }
            }
        }


        int max = 1;
        for (int i : strahler) {
            max = Math.max(max, i);
        }
        return max;
    }

    private static void input() throws IOException {
        r.nextInt();
        M = r.nextInt();
        P = r.nextInt();

        strahler = new int[M + 1];
        Arrays.fill(strahler, 1);

        indegree = new int[M + 1];

        in = new List[M + 1];
        out = new List[M + 1];
        for (int i = 1; i <= M; i++) {
            in[i] = new ArrayList<>();
            out[i] = new ArrayList<>();
        }

        for (int i = 0; i < P; i++) {
            int left = r.nextInt();
            int right = r.nextInt();
            in[left].add(right);
            out[right].add(left);
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

