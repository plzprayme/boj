package 네이버클로버;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.Test;

public class _3 {


    public int solution(String s) {

        int answer = s.length();
        for (int window = 1; window < s.length(); window++) {

            for (int i = 0; i + window < s.length(); i++ ) {
                Map<Character, Integer> counter = new HashMap<>();

                for (int j= i; j <= i + window; j++) {
                    char c = s.charAt(j);
                    int count = counter.getOrDefault(c , 0);
                    counter.put(c, count + 1);
                }

                int a = 0;
                for (int j : counter.values()) {
                    if (j == 1) a++;
                }
                answer = (a + answer) % 1_000_000_007;

            }

        }


        return answer;
    }

    @Test
    public void main() {
        System.out.println(
            solution("ACAX")
        );

        System.out.println(
            solution("CODILITY")
        );
        System.out.println(
            solution("A")
        );
        System.out.println(
            solution("AA")
        );


    }
}
