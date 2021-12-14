package sds.SET게임2;

import org.junit.jupiter.api.Test;

import java.io.*;
import java.util.*;

class Main {

    static InputReader r;

    static int T;


    @Test
    public static void main(String[] args) throws IOException {
        input();
        solution();
    }

    private static void solution() throws IOException {
        // 모양, 색깔, 그려진 수, 음영
        // 모양: 타원, 다이아몬드, 구불구불
        // 색깔: 빨간, 초록, 보라
        // 수: 1개, 2개, 3개
        // 음영: 완전, 테두리, 줄무늬

        // 조건: 3장의 카드의 4가지 속성이 모두 같거나 모두 달라야한다.


        // N은 3 이상 27이하
        // N 개의 카드는 모두 다르다.

        // x축: 색깔이 다르다. y축: 숫자가 다르다.
        // 1PEW 1REW 1GEW
        // 2PEW 2REW 2GEW
        // 3PEW 3REW 3GEW

        // 1P
        // 배열에 모두 저장하고 비교하기.
        // 3개 체크
        // 2개 체크
        // 1개 체크

        // 그래프로 볼 수 있겠다.
        // 그런데 어느 속성에 대한 그래프로 볼 것인가?

        // 정렬로 할 수 있지 않나?
        // 정렬을 잘 해버릴 수 없나?

        StringBuilder sb = new StringBuilder();
        Stack<Integer> selected = new Stack<>();
        for (int t = 1; t <= T; t++) {
            int N = r.nextInt();
            String[] cards = new String[N];

            for (int i = 0; i < N; i++) {
                cards[i] = r.nextLine();
            }

            int count = 0;

            count += go(3, selected, N, cards);
            count += go(2, selected, N, cards);
            count += go(1, selected, N, cards);
            count += go(0, selected, N, cards);


            sb.append('#').append(t).append(' ').append(count).append('\n');
        }

        System.out.println(sb);
    }

    private static int go(int num, Stack<Integer> selected, int N, String[] cards) {
        int count = 0;
        String pre = null;
        for (int i = 0; i < N; i++) {
            if (Objects.isNull(cards[i])) continue;

            String cur = cards[i];
            if (Objects.isNull(pre)) {
                pre = cur;
                selected.add(i);
                continue;
            } else {
                if (count(pre, cur) == num) {
                    selected.add(i);
                }

                if (selected.size() == 3) {
                    while (!selected.isEmpty()) {
                        cards[selected.pop()] = null;
                    }
                    pre = null;
                    count++;
                    continue;
                }
            }
        }

        selected.clear();

        return count;
    }

    private static int count(String pre, String cur) {
        int count = 0;
        for (int i = 0; i < 4; i++) {
            if (pre.charAt(i) == cur.charAt(i)) count++;
        }
        return count;
    }

    private static void input() throws IOException {
        r = new InputReader("C:\\Users\\workspace\\boj\\src\\test\\java\\sds\\SET게임2\\input.txt");
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

        public String nextLine() throws IOException {
            return r.readLine();
        }
    }

}