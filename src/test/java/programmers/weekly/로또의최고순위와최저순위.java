package programmers.weekly;

import org.junit.jupiter.api.Test;

public class 로또의최고순위와최저순위 {
    @Test
    public void main() {
        System.out.println(
            solution(
                new int[] {44, 1, 0, 0, 31, 25},
                new int[] {31, 10, 45, 1, 6, 19}
            )
        );
    }

    public int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = {7, 7};

        int cz = 0;
        int a = 0;
        for (int i : lottos) {
            if (i == 0) {
                cz++;
                continue;
            }
            for (int j : win_nums)
                if (i == j)
                    a++;

        }

        if (a == 0 && cz != 6)
            a = 1;
        answer[0] -= cz + a;
        if (a == 0)
            a = 1;
        answer[1] -= a;

        return answer;
    }
}
