package sds.캠핑클럽;

import java.io.*;
import java.util.*;

import org.junit.jupiter.api.Test;

class Main {

    static InputReader r;

    static int T;
    static int[] road;
    static int dst;

    @Test
    public static void main(String[] args) throws IOException {
        input();
        solution();
    }

    private static void solution() throws IOException {
        StringBuilder sb = new StringBuilder();
        // TODO

        // 캠핑카를 타고 이동하는 시간은 6시간을 넘지 않는다.
        // 6시간 이내에 휴게소나 캠핑장을 방문하여 휴식한다.
        // 휴게소에 방문하면 1시간을 휴식한다.
        // 캠핑장에 도착하면 무조건 숙박한다.
        // 캠핑장에서 다음 캠핑장까지 이동시간은 15시간을 넘지 않는다.

        // 당일 방문할 수 있는 가장 멀리 있는 캠핑장 방문
        // 휴게소는 최소로 방문문

        for (int t = 0; t < T; t++) {

            // 1. 캠핑카를 타고 이동하는 시간은 6시간을 넘지 않는다. 6시간 이내에 휴게소 or 캠핑장을 방문 해야 한다.
            // 2. 휴게소에 방문하면 1시간을 휴식한다.
            // 3. 캠핑장에 도착하면 무조건 숙박한다.
            // 4. 캠핑장에서 다음 캠핑장까지 15시간을 넘지 말자.
            // 5. 당일 방문할 수 있는 가장 멀리 있는 캠핑장 방문하자.
            // 6. 휴게소는 최소로 방문하자.

            // 한칸씩 전진해서는 답이 없다.
            // 6시간 or 15시간 을 기준으로 보자.

            int N = r.nextInt();
            int time = 0;
            for (int i = 0; i < N; i++) {

                // 6칸 이내에 휴게소 캠핑장을 방문하자.
                // 6칸 이내에 무조건 휴게소나 캠핑장을 방문해야한다.


                // 15칸 이내에 캠핑장을 결정하자.

                // (15시간 이내에) 15칸 만큼 볼꺼다.
                // (6시간 이내에) 6칸 내에 휴게소 or 캠핑장을 방문한다.
                // 마지막 휴게소가 -1 , 마지막 캠핑장이 -1
                // 마지막 휴게소가 -1이면서 캠핑장이 i일 때 -> 캠핑장 간다.
                // 마지막 휴게속 i이면 무조건 휴게소

                // (6시간 이내에) 다음 6칸 간다.

                // 만약 캠핑장을 방문 했으면 다음날이라고 생각한다.


                // 0 1 2 3 1 3 2
                // 0 1 2 3 4 5 6

                // end - start = 6

                // start: 0
                // tollGate: 2, 6

                // tollGate:

            }




            sb.append('#').append(t).append(' ').append(time);
        }
    }

    private static void input() throws IOException {
        r = new InputReader("C:\\Users\\workspace\\boj\\src\\test\\java\\sds\\캠핑클럽\\input.txt");
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
