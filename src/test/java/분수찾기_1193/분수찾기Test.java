package 분수찾기_1193;

import org.junit.jupiter.api.Test;

public class 분수찾기Test {


    @Test
    public void 예제() {
        int input = 15;

        if (input == 1) {
            System.out.println("1/1");
            return;
        }

        int count = 1;
        int now = 1;
        while (now < input) {
            now += ++count;
        }


        int step = now - input;

        if (!isOdd(count)) {
            System.out.println(answer(1 + step, count - step));
            return;
        }
        System.out.println(answer(count - step, 1 + step));


    }

    private boolean isOdd(int i) {
        return i % 2 == 0;
    }

    private String answer(int top, int bottom) {
;        return String.format("%d/%d", top, bottom);
    }
}
