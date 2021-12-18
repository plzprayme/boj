package 사촌_9489;

import java.io.*;
import java.util.*;

import org.junit.jupiter.api.Test;

class Main {

    static InputReader r;

    static int N, K;
    static int[] node, parent;

    static StringBuilder sb = new StringBuilder();

    private static void solution() throws IOException {
        // 부모의 부모 의 자식 노드들 구한다. -> K의 부모의 사촌들
        // K의 부모의 사촌들의 자식들을 구한다. -> K의 사촌들

        // 예외. 부모의 부모가 없을 수도 있다. -> K가 루트의 자식
        // 예외. 부모가 없을 수도 있다. -> K가 루트

        // 부모를 저장하자.
        parent[0] = -1; // 0은 존재하지 않는 노드이다..
        parent[1] = 0; // 루트는 부모가 없다.

        // 부모를 구하자.
        // last의 자식 노드를 구해야한다.
        int last = 1;
        for (int i = 2; i <= N; i++, last++) {
            for (; i <= N; i++) {
                parent[i] = last;
                // i + 1이 가능하면서, cur과 next이 1 이상 차이날 때
               if (i < N && node[i] + 1 != node[i + 1]) {
                    break;
               }
            }
        }

        // K의 인덱스 찾기.
        // input에서 찾아도 되긴 함.
        int kIdx = 0;
        for (int i = 1; i <= N; i++) {
            if (node[i] == K) kIdx = i;
        }

        // 정답찾기
        int answer = 0;
        for (int i = 1; i <= N; i++) {
            // 부모의 부모는 같으면서 부모는 다른 정점 찾기
            if (parent[parent[i]] == parent[parent[kIdx]] && parent[i] != parent[kIdx]) {
                answer++;
            }
        }
        sb.append(answer).append('\n');
    }
    private static void input() throws IOException {
        N = r.nextInt(); K = r.nextInt();
        parent = new int[N + 1];
        node = new int[N + 1];
        for (int i = 1; i <= N; i++) node[i] = r.nextInt();
    }

    @Test
    public static void main(String[] args) throws IOException {
        r = new InputReader("C:\\Users\\workspace\\boj\\src\\test\\java\\사촌_9489\\input.txt");
        while (true) {
            input();
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

