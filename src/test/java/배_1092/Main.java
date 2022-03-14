package 배_1092;

import java.io.*;
import java.util.*;

import org.junit.jupiter.api.Test;

class Main {

    static int N, M;
    static List<Integer> crain = new ArrayList<>();
    static List<Integer> box = new ArrayList<>();

    @Test
    public static void main(String[] args) throws IOException {
        input();
        solution();
    }

    private static void solution() {
        // 항구에 크레인이 N대 있다. 1분에 박스 한개씩 실을 수 있다.
        // 크레인의 무게 제한보다 무거운 박스는 크레인으로 움직일 수 없다.

        // 무게 제한 6 8 9
        // 박스 무게 2 2 4 5 7
        // 2

        // 무게 제한 19 20
        // 박스 무게 1 5 12 14 16 16 19
        // 4

        // 무게 제한 23 25 28 32
        // 박스 무게 2 5 7 10 16 18 20 24 27 32
        // 3

        // 무게 제한 2 5 5 5 7 7 11 17 20 20
        // 박스 무게 15 15 17 18 18
        // 2

        // 무게 제한 15 16
        // 박스 무게 15 16 16
        // 2



        // 크레인 숫자는 50 박스의 수는 10_000

        // 어차피 하나 싣는데에 1초 걸리기 때문에 꽉차게 싣는 것은 의미가 없다.
        // 관건은 최대한 많은 크레인에 동시에 하나의 박스를 담는 것.


        // 투 포인터?
        // 무게 제한과 박스 무게간의 투 포인터
        // 근데 이걸 여러번 해야된다. 안됨

        // 우선순위 큐?
        // 박스 무게 우선순위?
        // 무게 제한 우선순위?
        // 오름차순 우선순위 큐?
        // 내림차순 우선순위 큐?

        crain.sort(Collections.reverseOrder());
        box.sort(Collections.reverseOrder());

        if (crain.get(0) < box.get(0)) {
            System.out.println(-1);
            return;
        }

        int answer = 0;
        int ci = 0;
        int bi = 0;
        while (!box.isEmpty()) {

            if (crain.get(ci) >= box.get(bi)) {
                // 박스를 싣을 수 있는 경우
                box.remove(bi);
                // 다음 크레인으로 이동
                ci++;
            } else {
                // 박스를 적재할 수 없는 경우
                // 크레인 < 박스
                bi++;
            }


            // 크레인에 전부 담았다면?
            // 모든 박스를 옮겼다면?
            if (ci == N || bi == box.size()) {
                answer++;
                ci = 0;
                bi = 0;
            }
        }

        System.out.println(answer);


    }

    private static void input() throws IOException {
        InputReader r = new InputReader("C:\\Users\\workspace\\boj\\src\\test\\java\\배_1092\\input.txt");

        N = r.nextInt();
        for (int i = 0; i < N; i++) {
            crain.add(r.nextInt());
        }

        M = r.nextInt();
        for (int i = 0 ; i < M; i++) {
             box.add(r.nextInt());
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
