package 달팽이는_올라가고_싶다_2869;

import org.junit.jupiter.api.Test;

public class 달팽이는올라가고싶다Test {

    private static String template = "A: %d, B: %d, V: %d, ANSWER: %s, ITER: %s";

    @Test
    public void 예제() {
        String answer = solution(2, 1, 5);
        System.out.println(answer);
    }

    @Test
    public void 예제2() {
        String answer = solution(5, 1, 6);
        System.out.println(answer);
    }

    @Test
    public void 예제3() {
        int A = 100;
        int B = 99;
        int V = 1000000000;
        String answer = solution(A, B, V);
        String iterAnswer = iterSolution(A, B, V);
        System.out.println(String.format(template, A, B, V, answer, iterAnswer));
    }

    // @Test
    // public void 전체테스트() {
    //     int max = 1_000_000_000;
    //
    //     for (int V = 2; V < max; V++) {
    //         for (int A = 2; A <= V; A++) {
    //             for (int B = 1; B < A; B++) {
    //                 String answer = solution(A, B, V);
    //                 String iterAnswer = iterSolution(A, B, V);
    //                 if (!answer.equals(iterAnswer)) {
    //                     System.out.println(String.format(template, A, B, V, answer, iterAnswer));
    //                 }
    //             }
    //         }
    //     }
    //
    // }

    private String solution(int A, int B, int V) {
        int left = V - B;
        int right = A - B;

        if (left % right != 0) {
            return String.valueOf(left / right + 1);
        }

        return String.valueOf(left / right);
    }

    private String iterSolution(int A, int B, int V) {
        int now = A;
        int count = 1;
        while (true) {
            if (now >= V)
                return String.valueOf(count);

            now = now - B + A;
            ++count;
        }
    }
}
