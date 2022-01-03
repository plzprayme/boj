package 동물원_1309;

import java.io.*;
import java.util.*;

import org.junit.jupiter.api.Test;

class Main {

    static int N;
    static int[][] zoo;

    @Test
    public static void main(String[] args) throws IOException {
        input();
        solution();
    }

    private static void solution() {
        // 시도 1.(실패) 1 x 1 단위로 생각하자.
        // 행의 왼쪽 엘리먼트 부터 살펴보자
        // 윗 엘리먼트가 1일 땐 0
        // 윗 엘리먼트가 0일 땐 1이다.

        // 행의 오른쪽 엘리먼트를 살펴보자
        // 행의 왼쪽 엘리먼트가 1이며 윗 엘리먼트가 1이면 행의 오른쪽 엘리먼트는 무조건 0이어야 한다.
        // 행의 왼쪽 엘리먼트가 0이면서 행의 윗 엘리멘트가 1 이거나 그 반대여도 반드시 0이어야 한다.
        // 행의 왼쪽 엘리먼트가 0이며 윗 엘리먼트가 0이면 행의 오른쪽 엘리먼트는 0이어도 되고 1이어도 된다.
        // 오른쪽 위가 1이면 세번째의 위가 0인 것이 보장 된다.

        // 왼쪽만 보면서 전진해도 되나?

        // 시도 2.(성공) 행 단위로 생각하자
        // 하나의 행에는 세 가지 경우의 수가 존재한다.

        // 0 0 | 0 1 | 1 0

        // 위의 행이 0 0 일 때
        // 아래 행은 0 0 | 0 1 | 1 0 모두 가능

        // 윗 행이 0 1 일 떄
        // 아래 행은 0 0 | 1 0 가능

        // 윗 행이 1 0 일 때
        // 아래 행은 0 0 | 0 1 가능능

        // i = 1 | 3
        // i = 2 | 3 + 2 + 2
        // i = 3 |

        // 초기식
        // 0 = 00
        // 1 = 10
        // 2 = 01
        zoo[1][0] = 1;
        zoo[1][1] = 1;
        zoo[1][2] = 1;

        for (int i = 2; i <= N; i++) {
            zoo[i][0] = (zoo[i-1][0] + zoo[i-1][1] + zoo[i-1][2]) % 9901;
            zoo[i][1] = (zoo[i-1][0] + zoo[i-1][2]) % 9901;
            zoo[i][2] = (zoo[i-1][0] + zoo[i-1][1]) % 9901;
        }

        System.out.println((zoo[N][0] + zoo[N][1] + zoo[N][2]) % 9901);
    }

    private static void input() throws IOException {
        InputReader r = new InputReader();
        N = r.nextInt();

        zoo = new int[N + 1][3];
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

