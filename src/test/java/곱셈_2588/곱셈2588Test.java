package 곱셈_2588;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.junit.jupiter.api.Test;

public class 곱셈2588Test {
    @Test
    public void 예제1() {
        String[] input = {"472", "385"};

        String first = input[0];
        String second = input[1];

        int result = 0;
        for (int i = 2; i >= 0 ; i--) {

            int temp = 0;
            for (int j = 0; j <= 2; j++) {
                int digit = (int) Math.pow(10, 2 - j);
                int s = Integer.parseInt(String.valueOf(second.charAt(i)));
                int f = Integer.parseInt(String.valueOf(first.charAt(j)));
                temp += digit * s * f;
            }
            System.out.println(temp);

            result += temp * (int) Math.pow(10, 2 - i);
        }

        System.out.println(result);
    }
}
