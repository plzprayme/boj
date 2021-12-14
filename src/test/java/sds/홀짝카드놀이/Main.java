package sds.홀짝카드놀이;
import java.io.*;
import java.util.*;

import org.junit.jupiter.api.Test;

class Main {

    static InputReader r;
    static boolean[] selected = new boolean[10_001];
    static int[] cards = new int[10_001];

    static int N;
    static int answer;

    @Test
    public static void main(String[] args) throws IOException {
        input();
        solution();
        // 1.5 초
        // 256 MB

        // 숫자가 적혀있는 짝수 장의 카드를 숫자가 보이도록 테이블 위에 올린다.
        // 카드를 2장을 선택한다.

        // 두 장의 합이 짝수인 경우, 두 장의 카드 중 한장을 고른다.
        // 두 장의 합이 홀수인 경우, 상대방이 먼저 한장을 고른다.

        // 모든 카드를 나눠 가진후, 카드의 합이 높으면 이긴다.
        //

        // 연아가 얻을 수 있는 최대 점수

        // 카드의 수는 4 ~ 10,000

        // 숫자는 10,000 * 50,000 -> int 가능

        // 짝수가 되는 최대 숫자 + 최소 숫자

        // 방법 1. 완전탐색
        // 조합 만들기? 시간 복잡도 너무 크다.. ㅠㅠ

        // 방법 2. 최대 숫자 + 최소 숫자를 짝수로 만들기
        // 홀 + 홀 = 짝
        // 짝 + 짝 = 짝
        // 홀 + 짝 = 홀
        // 짝수들은 두 수의 차이가 큰 조합!
        // 홀짝은 두 수의 차이가 작은 조합으로..
        // 어떻게 구현하지?
    }

    private static void solution() throws IOException {
        int T = r.nextInt();

        StringBuilder sb = new StringBuilder();
        for (int t = 1; t <= T; t++) {
            N = r.nextInt();
            answer = Integer.MIN_VALUE;

            for (int i = 1; i <= N; i++) {
                cards[i] = r.nextInt();
            }
            combination(1, 0, 0);
            // 방법 1. 완전탐색
            // 반복 횟수는 cards.length / 2
            // 반복할 때 봐야할 것들 selected, sum, n
            sb.append('#').append(t).append(' ').append(answer).append('\n');
        }
        System.out.println(sb);
    }

    static void combination(int n, int pre, int sum) {
        if (n == N + 1) {
            answer = Math.max(answer , sum);
        } else {
            for (int i = 1; i <= N; i++) {
                if (selected[i]) continue;
                selected[i] = true;
                combination(n + 1, cards[i], nextSum(n, pre, sum, i));
                selected[i] = false;
            }
        }

    }

    private static int nextSum(int n, int pre, int sum, int i) {
        if (n % 2 == 0) {
            int tmp = pre + cards[i];
            if (tmp % 2 == 0) {
                return sum + Math.max(pre, cards[i]);
            } else {
                return sum + Math.min(pre, cards[i]);
            }
        }
        return sum;
    }

    private static void input() throws IOException {
        r = new InputReader("C:\\Users\\workspace\\boj\\src\\test\\java\\sds\\홀짝카드놀이\\input.txt");
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
