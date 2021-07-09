package 셀프넘버_4673;

import org.junit.jupiter.api.Test;

public class 셀프넘버Test {
    @Test
    public void 예제() {
        boolean[] numbers = new boolean[10001];
        Answer answer = new Answer();
        answer.submit();
    }

    private static class Answer {
        boolean[] numbers = new boolean[10001];

        public Answer() {

            for (int i = 1; i < 10000; i++) {
                selfNumber(i);
            }

        }

        private void selfNumber(int constructor) {
            int number = construct(constructor);
            if (number > 10000) {
                return;
            }
            numbers[number] = true;
        }

        private int construct(int number) {
            return number + sum(number);
        }

        private int sum(int number) {
            int sum = 0;

            for (char c : String.valueOf(number).toCharArray()) {
                sum += c - 48;
            }

            return sum;
        }

        public void submit() {

            for (int i = 1; i <= 10000; i++) {
                if (!numbers[i]) {
                    System.out.println(i);
                }
            }

        }
    }
}
