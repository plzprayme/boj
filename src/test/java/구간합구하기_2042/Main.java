package 구간합구하기_2042;

import java.io.*;
import java.util.*;

import org.junit.jupiter.api.Test;

class Main {

    static int N, M, K;

    static int S;

    static int[] arr;

    static long[] tree;

    static Query[] query;

    static class Query {
        int a, b, c;

        public Query(int a, int b, int c) {
            this.a = a;
            this.b = b;
            this.c = c;
        }

        public boolean isUpdate() {
            return a == 1;
        }
    }

    @Test
    public static void main(String[] args) throws IOException {
        input();
        solution();
    }

    private static void solution() {
        initTree();

        StringBuilder sb = new StringBuilder();
        for (Query q : query) {
            if (q.isUpdate()) {
               update(q.b, q.c);
            } else {
               sb.append(sum(q.b, q.c)).append('\n');
            }
        }

        System.out.println(sb);
    }

    static void initTree() {
        // 리프 노드에 숫자들 추가
        for (int i = 0; i < N; i++) {
            tree[i + S] = arr[i];
        }

        for (int i = S - 1; i > 0; i--) {
            tree[i] = tree[i * 2] + tree[i * 2 + 1];
        }
    }

    static void update(int idx, int value) {
        // 바꿔치기한 부분이 영향을 주는 노드들 합을 변경
        update(1, S, 1, idx, value);
    }

    static long update(int left , int right, int idx, int target, int value) {
        if (target < left || right < target) return 0;

        if (left == right && left == target) {
            long tmp = value - tree[idx];
            tree[idx] = value;
            return tmp;
        }

        int mid = (left + right) / 2;
        long leftResult = update(left, mid, idx * 2, target, value);
        long rightResult = update(mid + 1, right, idx * 2 + 1, target, value);
        tree[idx] += leftResult + rightResult;
        return leftResult + rightResult;
    }

    // 바텀업
    static long sum(int queryLeft, int queryRight) {
        return query(1, S, 1, queryLeft, queryRight);
    }

    static long query(int left, int right, int idx, int queryLeft, int queryRight) {
        // 쿼리 구간이 지금 구간과 전혀 상관 없을 때 return 0;

        // -----------
        // - |    | --  일때
        // 쿼리 구간이랑 전혀 안겹칠 때
        if (queryLeft > right ||  queryRight < left) return 0;

        //   | -- |
        //   |----|
        // 쿼리 구간이 지금 구간에 딱 맞거나 쿼리 구간이 더 클 때
        if (queryLeft <= left && right <= queryRight) {
            return tree[idx];
        }

        // 자식에게 위임하거나 자식에서 올라온 값을 리턴할 떄

        int mid = (left + right) / 2;
        long leftResult = query(left, mid, idx * 2, queryLeft, queryRight);
        long rightResult = query(mid + 1, right, idx * 2 + 1, queryLeft, queryRight);
        return leftResult + rightResult;
    }

    static void replace(int idx, int value) {
        tree[idx] = value;
    }

    private static void input() throws IOException {
        InputReader r = new InputReader("C:\\Users\\workspace\\boj\\src\\test\\java\\구간합구하기_2042\\input.txt");
        N = r.nextInt();
        M = r.nextInt();
        K = r.nextInt();

        arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = r.nextInt();
        }

        S = (int) Math.pow(2, N - 2);
        tree = new long[S * 2];


        query = new Query[M + K];
        for (int i = 0; i < M + K; i++) {
            query[i] = new Query(r.nextInt(), r.nextInt(), r.nextInt());
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

