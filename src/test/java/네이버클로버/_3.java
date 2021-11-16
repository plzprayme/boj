package 네이버클로버;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.Test;

public class _3 {

    public int solution2(String s) {
        int[][] pair = new int[s.length()][2];

        int[] idx = new int[26];
        Arrays.fill(idx, -1);
        for (int cur = 0; cur < s.length(); cur++) {
            int i = s.charAt(cur) - 'A';
            if (idx[i] == -1) {
                pair[cur][0] = cur + 1;
            } else {
                pair[cur][0] = cur - idx[i];
            }
            idx[i] = cur;
        }

        Arrays.fill(idx, -1);
        int cur = 0;
        for (int j = s.length() - 1; j >= 0; j--) {
            int i = s.charAt(j) - 'A';
            if (idx[i] == -1) {
                pair[j][1] = cur + 1;
            } else {
                pair[j][1] = cur - idx[i];
            }
            idx[i] = cur;
            cur ++;
        }

        int answer = 0;
        for (int[] lr : pair) {
            answer += lr[0] * lr[1];
        }
        return answer;
    }

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
            solution2("ACAX")
        );

        System.out.println(
            solution2("CODILITY")
        );

        System.out.println(
            solution2("A")
        );

        System.out.println(
            solution2("AA")
        );
    }

}
