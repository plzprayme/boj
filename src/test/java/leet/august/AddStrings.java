package leet.august;

import org.junit.jupiter.api.Test;

public class AddStrings {
    @Test
    public void main() {
        String longer= new StringBuilder("456").reverse().toString();
        String shorter = new StringBuilder("77").reverse().toString();

        if (longer.length() < shorter.length()) {
            String tmp = longer;
            longer = shorter;
            shorter = tmp;
        }

        int up = 0, now = 0;
        char[] answer = longer.toCharArray();
        for (int i = 0; i < longer.length(); i++) {
            //  짧은 수 보다 긴 인덱스일 때는 0리턴
            int shorterNum = i < shorter.length() ? shorter.charAt(i) - '0' : 0;
            int longerNum = longer.charAt(i) - '0';
            int sum = shorterNum + longerNum + up;

            now = sum % 10;
            up = sum / 10;

            answer[i] = (char) (now + '0');
        }

        StringBuilder sb = new StringBuilder();
        // '54' + '55' = 100이 되도록
        if (up == 1) sb.append(1);
        for (int i = answer.length - 1; i > -1; i--) {
            sb.append(answer[i]);
        }


        System.out.println(sb);
    }

    private static String  reverse(String s) {
        return new StringBuilder(s).reverse().toString();
    }
}
