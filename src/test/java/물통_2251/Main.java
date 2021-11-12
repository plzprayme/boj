package 물통_2251;

import java.io.*;
import java.util.*;

import org.junit.jupiter.api.Test;

class Main {

    static int[] ABC = new int[3];
    static boolean[] answer = new boolean[201];
    static boolean[][][] visit = new boolean[201][201][201];;

    private static int[] from = {0, 0, 1, 1, 2, 2};
    private static int[] to = {1, 2, 0, 2, 0, 1};


    private static void solution() {
        // bfs(new Triple(0, 0, ABC[2]));
        dfs(new Triple(0, 0, ABC[2]));


        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 201; i++) if (answer[i]) sb.append(i).append(' ');
        System.out.println(sb);
    }
    private static void bfs(Triple start) {
        Stack<Triple> stack = new Stack<>();
        setVisit(start);
        answer[start.c()] = true;
        stack.add(start);

        while (!stack.isEmpty()) {
            Triple now = stack.pop();
            for (int i = 0; i < 6; i++) {
                if (now.get(from[i]) == 0) continue;
                if (now.get(to[i]) == ABC[to[i]]) continue;
                Triple next = now.move(from[i], to[i], ABC);
                if (isVisit(next)) continue;
                stack.add(next);
                setVisit(next);
                if (next.a() == 0) answer[next.c()] = true;
            }
        }

    }

    private static boolean isVisit(Triple now) {
        return visit[now.a()][now.b()][now.c()];
    }

    private static void setVisit(Triple now) {
        visit[now.a()][now.b()][now.c()] = true;
    }

    private static void dfs(Triple now) {
        if (now.isOK()) answer[now.c()] = true;

        for (int i = 0; i < 6; i++) {
            if (now.get(from[i]) == 0) continue;
            if (now.get(to[i]) == ABC[to[i]]) continue;
            Triple next = now.move(from[i], to[i], ABC);
            if (isVisit(next)) continue;
            setVisit(next);
            dfs(next);
        }


    }

    private static class Triple {
        int[] abc;

        public Triple(int a, int b, int c) {
            abc = new int[3];
            abc[0] = a;
            abc[1] = b;
            abc[2] = c;
        }

        public Triple(int[] abc) {
            this.abc = abc.clone();
        }

        public Triple move(int from, int to, int[] limit) {
            // 0 1
            // 0 0 10
            // limit[from] - abc[from] = 8
            //
            int[] next = abc.clone();

            int toLimit = limit[to] - next[to];
            if (toLimit < next[from]) {
                next[from] -= toLimit;
                next[to] += toLimit;
            } else {
                next[to] += next[from];
                next[from] = 0;
            }

            return new Triple(next);

            // from 의 값을 to로 옮겨도 문제가 없다
            // 8 9 10
            // 0 0 10 -> 4
            // t   f
            // 4 0 6 -> 4 < 6
            // 1. limit[from] - abc[from] < abc[to]
            //      -> abc[from] += abc[to] - limit[from] - abc[from]
            //      -> abc[to] -= limit[from] - abc[from]
            // 2. limit[from] - abc[from] >= abc[to]
            //      -> limit[from] += abc[to]
            //      -> abc[to] = 0;


            // 문제가 있다
            // - to 의 값이 limit이랑 같다.
            // - from의 값이 0이다.




        }

        public boolean isOK() {
            return get(0) == 0;
        }

        public int a() {
            return get(0);
        }

        public int b() {
            return get(1);
        }

        public int c() {
            return get(2);
        }

        public int get(int i) {
            return abc[i];
        }
    }

    private static void input() throws IOException {
        InputReader r = new InputReader("C:\\Users\\prayme\\workspace\\boj\\src\\test\\java\\물통_2251\\input.txt");
        ABC = new int[3];
        ABC[0] = r.nextInt();
        ABC[1] = r.nextInt();
        ABC[2] = r.nextInt();
    }

    @Test
    public static void main(String[] args) throws IOException {
        input();
        solution();
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

