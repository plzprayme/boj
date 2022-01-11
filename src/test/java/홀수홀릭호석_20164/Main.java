package 홀수홀릭호석_20164;

import java.io.*;
import java.util.*;

import org.junit.jupiter.api.Test;

class Main {

    static int MAX = Integer.MIN_VALUE, MIN = Integer.MAX_VALUE;

    @Test
    public static void main(String[] args) throws IOException {
        input();
        solution();
    }

    private static void solution() throws IOException {
        // 1. 숫자 N에 존재하는 홀수의 개수를 적는다.
        // 2. 숫자 N이 9이하면 종료한다.
        // 3. N이 두 자리면 각 자리 수를 합해서 새로운 수를 만든다.
        // 4. 수가 세자리 이상이면 임의의 위치에서 3개의 수로 분할하,고 3개를 더한 값을 새로운 수로 생각한다.

        // N = 10^9 - 1 | 999_999_999
        // 3부분으로 자르는 경우의 수: N의 자릿 수 K
        // 최악의 경우: 최악의 경우에 5번. 9 + 9 + 9_999_999 = 10_000_017 | 100_000 + 1 + 7 = 100_008 | 1_000 + 0 + 8 = 1_008 | 10 + 0 + 8 = 18 | 1 + 8 = 9

        // 최대한 많이 잘라도 5번으로 예상
        //

        // 기능 구현
        // 1. 3개의 조합을 구하는 백트래킹
        // 2. 홀수 카운팅
        // 3. 3자리 이상 숫자 처리 로직
        // 4. 2자리 숫자 처리 로직
        // 5. 한자리면 종료
        InputReader r = new InputReader();
        recursion(0, r.nextLine());
        System.out.printf("%d %d", MIN, MAX);
    }

    private static void recursion(int count, String num) {
        // 홀 수 카운팅
        for (int i = 0; i < num.length(); i++) {
            if (num.charAt(i) % 2 == 1) count++;
        }

        if (num.length() == 1) {
            // 최댓값, 최솟값 갱신
            MAX = Math.max(MAX, count);
            MIN = Math.min(MIN, count);
        } else if (num.length() == 2) {
            // 첫째 둘째 더한 후 다음으로
            String nextNumber = String.valueOf(num.charAt(0) + num.charAt(1) - '0' - '0') ;
            recursion(count, nextNumber);
        } else {
            // 3개로 자르는 경우의 수
            for (int i = 0; i < num.length() - 2; i++) {
                for (int j = i + 1; j < num.length() - 1; j++) {
                    for (int k = j + 1; k < num.length(); k++) {
                        // 다음 숫자 구하기
                        String next = nextNumber(i, j, k, num);
                        recursion(count, next);
                    }
                }
            }

        }

    }

    private static String nextNumber(int S, int M, int E, String old) {
        int newInt = 0;
        newInt += Integer.parseInt(old.substring(0, M));
        newInt += Integer.parseInt(old.substring(M, E));
        newInt += Integer.parseInt(old.substring(E));
        return String.valueOf(newInt);
    }

    private static void input() throws IOException {
        InputReader r = new InputReader();
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

