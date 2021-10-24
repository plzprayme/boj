package cafe24;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

public class _2 {

    @Test
    public void 메인() {
        long start = System.currentTimeMillis();
        System.out.println(
            solution(
                Integer.MAX_VALUE
            )
        );
        System.out.println(System.currentTimeMillis() - start);
    }

    public int solution(int param) {
        int answer = 0;

        for (int i = 0 ; i <= param; i++) {
            String s = String.valueOf(param);

            for (char c : s.toCharArray()) {
                if (c == '3' || c == '6' || c == '9') answer++;
            }

        }

        return answer;
    }
}
