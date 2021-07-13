package 벌집_2292;

import org.junit.jupiter.api.Test;

public class 벌집Test {
    @Test
    public void 예제() {
        String input = "58";
        int destination = Integer.parseInt(input);
        int n = 6;

        int start = 2;
        int count = 1;
        do {
            if (destination == start) {
                break;
            }

            start += n * count++;
        } while(start <= destination);

        System.out.println(count);
    }
}
