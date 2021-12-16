package sds.거점점령;

import java.io.*;
import java.util.*;

import org.junit.jupiter.api.Test;

class Main {

    @Test
    public static void main(String[] args) throws IOException {
        input();
        solution();
    }

    static InputReader r;

    static int T;
    static int N, M;
    static int aStart, bStart;

    static int[] weightTable;
    static List<Integer>[] graph;

    private static void solution() throws IOException {
        // 거점 중 과반 수를 차지하는 쪽이 S 지역을 통치하기로 했다.

        // S 지역은 N 개의 거점과 두 거점을 잇는 M 개의 양방향 도로.
        // 1개의 거점을 ㅓㅁ령한 상태에서 전쟁 시작

        // 2개 나라가 같은 날 점령을 시도하면 대치 거점. (누구의 소유도 안됨)

        // A 국가는 3개 거점, B 국가는 4개 거점.

        // 일단 A 국가에서 BFS 돌린다.
        // B 국가에서 BFS 돌린다.
        // 이때, 대치 거점을 센다. 그리고 중립 거점을 센다.

        StringBuilder sb = new StringBuilder();

        for (int t = 1; t <= T; t++) {
            N = r.nextInt(); M = r.nextInt();
            graph = new List[N + 1];
            for (int i = 1; i <= N; i++) graph[i] = new ArrayList<>();

            weightTable = new int[N + 1];

            aStart = r.nextInt(); bStart = r.nextInt();

            // 인접 리스트 만들기
            for (int i = 0; i < M; i++) {
                int left = r.nextInt();
                int right = r.nextInt();
                graph[left].add(right);
                graph[right].add(left);
            }


            int aSiteCount = N;

            // A 거점 BFS
            Queue<State> q = new LinkedList<>();
            q.add(new State(aStart, 1));
            weightTable[aStart] = 1;

            while (!q.isEmpty()) {
                State cur = q.poll();
                for (int next : graph[cur.n]) {
                    if (weightTable[next] == 0) {
                        weightTable[next] = cur.w + 1;
                        q.add(new State(next, weightTable[next]));
                    }
                }
            }

            q.add(new State(bStart, 1));
            weightTable[bStart] = 1;
            aSiteCount--;


            Queue<State> sq = new LinkedList<>();
            while (!q.isEmpty()) {
                State cur = q.poll();
                for (int next : graph[cur.n]) {
                    // B의 거점일 때
                    int nw = cur.w + 1;
                    if (weightTable[next] > nw) {
                        weightTable[next] = nw;
                        q.add(new State(next, nw));
                        aSiteCount--;
                    } else if (weightTable[next] == nw) {
                        // 대치 거점 판단을 어떻게??
                        // 처음 만나는 녀석들이 대치 거점이다.
                        sq.add(new State(next, nw));
                    }
                }
            }

            // 대치 거점의 숫자
            int standOffCount = sq.size();
            sb.append('#').append(t).append(' ').append(standOffCount).append(' ');

            // 여기서 중립 거점을 어떻게 센다?
            // 중립 거점은 반드시 이전 거점의 + 1씩 한다.

            int neuralPointCount = 0;
            while (!sq.isEmpty()) {
                State cur = sq.poll();
                for (int next : graph[cur.n]) {
                    if (weightTable[next] > cur.w) {
                        sq.add(new State(next, weightTable[next]));
                        neuralPointCount++;
                    }
                }
            }

            aSiteCount -= neuralPointCount + standOffCount;

            // 과반수 == N / 2 + 1
            int answer = N / 2 + 1 - aSiteCount;
            if (answer < 0) answer = 0;
            if (N / 2 + 1 > aSiteCount + neuralPointCount + standOffCount) answer = -1;
            sb.append(answer).append('\n');
        }
        System.out.println(sb);
    }

    static class State {
        int n, w;

        public State(int n, int w) {
            this.n = n;
            this.w = w;
        }
    }

    private static void input() throws IOException {
        r = new InputReader("C:\\Users\\workspace\\boj\\src\\test\\java\\sds\\거점점령\\input.txt");
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

