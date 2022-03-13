package 최소회의실개수_19598;

import java.io.*;
import java.util.*;

import org.junit.jupiter.api.Test;

class Main {

    static int N;
    static Meet[] meets;

    static class Meet implements Comparable<Meet> {
        int start, end;

        public Meet(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Meet o) {
            return Integer.compare(start, o.start);
        }
    }


    @Test
    public static void main(String[] args) throws IOException {
        input();
        solution();
    }

    private static void solution() {
        // 최소 회의실 개수 구하라

        Arrays.sort(meets);

        PriorityQueue<Integer> pq = new PriorityQueue<>(); // 진행 중인 수업의 종료시간
        pq.add(meets[0].end);

        for (int i = 1; i < N; i++) {
            if (pq.peek() <= meets[i].start) {
                pq.poll();
            }

            pq.add(meets[i].end);
        }

        System.out.println(pq.size());
    }

    private static void input() throws IOException {
        InputReader r = new InputReader("C:\\Users\\workspace\\boj\\src\\test\\java\\최소회의실개수_19598\\input.txt");

        N = r.nextInt();

        meets = new Meet[N];
        for (int i = 0; i < N; i++) {
            meets[i] = new Meet(r.nextInt(), r.nextInt());
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

