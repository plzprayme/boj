package sds.오락실;

import java.io.*;
import java.util.*;

import org.junit.jupiter.api.Test;

class Main {

    static int answer;

    static InputReader r;
    static int T;

    static int[][] weight;
    static int[] weightTable;
    static List<Integer>[] graph;

    @Test
    public static void main(String[] args) throws IOException {
        input();
        solution();
    }

    private static void solution() throws IOException {
        StringBuilder sb = new StringBuilder();
        for (int t = 1; t <= T; t++) {
            int N = r.nextInt();

            weight = new int[N + 1][N + 1];
            weightTable = new int[N + 1];

            graph = new List[N + 1];
            for (int i = 1; i <= N; i++) {
                graph[i] = new ArrayList<>();
            }

            for (int i = 1; i < N; i++) {
                int left = r.nextInt();
                int right = r.nextInt();
                int w = r.nextInt();
                graph[left].add(right);
                graph[right].add(left);
                weight[left][right] = w;
                weight[right][left] = w;
            }

            // 1번 weight 구하기
            answer = Integer.MAX_VALUE;
            for (int i = 1; i <= N; i++) {
                dfs(0, i, i, 0);
                answer = Math.min(weightTable[i], answer);
            }


            Arrays.sort(weightTable);
            int count = 1;
            for (int i = 2; i <= N; i++) {
                if (weightTable[i - 1] == weightTable[i]) count++;
                else {
                    sb.append('#').append(t).append(' ')
                            .append(count).append(' ')
                            .append(weightTable[i - 1]).append('\n');
                    break;
                }
            }



            // E = N, V = E - 1 --> 트리!!


            // E 20_000
            // V 19_999

            // 100_000 * 20_000
            // DFS로 한다.
            // 리프 노드일 때 더해준다.
            // 탐색 1회에 O(V)
            // 모든 정점에 대해서 탐색 1회씩 O(E * V) == O(20_000^2)

            // 브루트 포스 -> 20_000 ^ 2 = 4억 ==> 시간 초과

            // 중복을 어떻게 최소화 할까?
            // 생각이 안난다. 일단 부분 점수라도??


        }
        System.out.println(sb);
    }

    private static void dfs(int pre, int cur, int start, int sum) {
        weightTable[start] += sum;

        if (weightTable[start] > answer) return;

        for (int next : graph[cur]) {
            if (next == pre) continue;
            dfs(cur, next, start, sum + weight[cur][next]);
        }
    }


    private static void input() throws IOException {
        r = new InputReader("C:\\Users\\workspace\\boj\\src\\test\\java\\sds\\오락실\\input.txt");
        T = r.nextInt();

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
