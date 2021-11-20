package 비트망고;

import org.junit.jupiter.api.Test;

public class _4 {
    public int solution(int[][] casted) {
        // 1 ~ 12 까지 점수 열두개 획득해야된다.

        // 1. 주사위 두개를 동시에 굴린다.
        // 2. 두 값 더한다
        // 3. 더한 값을 점수 1로 획득하거나 1 이상의 두  수로 나누어서 점수 2개를 획득할 수 있다.
        // 3. 점수를 획득안할 수도 있다.
        // 3-1. (2, 3) 일 떄 5점을 획득하거나 1점, 4점을 획득하거나, 2점 3점을 획득하거나 획득 안할 수도 있다.
        // 4. 이미 획득한 점수를 두번 획득할 수 없다.

        // 재귀로 들어간다.
        // 각 재귀 당 0 ~ 12 배열을 하나씩 준다...?

        go(0, 0, casted);
        return answer;
    }
    static int answer = Integer.MAX_VALUE;
    static boolean[] selected = new boolean[13];

    private static void go(int n, int count, int[][] casted) {

        if (count == 12) {
            // 12개일 때 지금까지 내려온 레벨을 체크
            // answer = Matn.min 하기
            answer = Math.min(n, answer);
        } else if (n == casted.length) {
            return;
        } else {
            int l = casted[n][0];
            int r = casted[n][1];

            // l + r
            if (!selected[l + r]) {
                selected[l + r] = true;
                go(n + 1, count + 1, casted);
                selected[l + r] = false;
            }

            // l, r
            if (!selected[l] && !selected[r] && l != r) {

                    selected[l] = true;
                    selected[r] = true;
                    go(n + 1, count + 2, casted);
                    selected[l] = false;
                    selected[r] = false;

            }

            // l + r - (r - i), i
            for (int i = 1; i < l; i++) {
                if (!selected[r + i] && !selected[i]) {
                    selected[r + i] = true;
                    selected[i] = true;
                    go(n + 1, count + 2, casted);
                    selected[r + i] = false;
                    selected[i] = false;
                }
            }

            go (n + 1, count, casted);
        }
    }

    @Test
    public void main() {
        System.out.println(
            solution(
                new int[][]{
                    {1, 1},
                    {5, 6},
                    {5, 1},
                    {5, 5},
                    {4, 1},
                    {6, 6},
                    {5, 6},
                    {5, 6},
                    {6, 5},
                    {3, 6},
                    {3, 4}
                }
            )
        );
    }


}
