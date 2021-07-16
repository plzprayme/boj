package 큰수AB_10757;

import java.math.BigInteger;

import org.junit.jupiter.api.Test;

public class 큰수ABTest {
    @Test
    public void 예제() {
        String A = reverse("100");
        String B = reverse("100");

        String longNum = longest(A,B);
        String shortNum = shortest(A, B);

        int[] answer = new int[longNum.length()+1];
        for (int i = 0; i < shortNum.length(); i++) {
            int sum = answer[i] + shortNum.charAt(i) + longNum.charAt(i) - 96;
            answer[i] = sum % 10;
            answer[i+1] = sum / 10;
        }

        for (int i = shortNum.length(); i < longNum.length(); i++) {
            int sum = answer[i] + longNum.charAt(i) - 48;
            answer[i] = sum % 10;
            answer[i+1] = sum / 10;
        }

        int len = answer.length;
        for (int i = len - 1; i >= 0; i--) {
            if (i == len-1 && answer[i] == 0) {
                continue;
            }
            System.out.print(answer[i]);
        }


        System.out.println("");
    }

    private String reverse(String s) {
        return new StringBuilder(s).reverse().toString();
    }

    private String longest(String a, String b) {
        return a.length() > b.length() ? a : b;
    }

    private String shortest(String a, String b) {
        return a.length() > b.length() ? b : a;
    }
}
