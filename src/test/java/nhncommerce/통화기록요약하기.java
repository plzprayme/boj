package nhncommerce;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Objects;

import org.junit.jupiter.api.Test;

public class 통화기록요약하기 {
    @Test
    public void main() {

        solution(
            "SMS 010-1234-5678",
            "CALL 010-1234-5678",
            "CALL 010-1234-5678",
            "SMS 010-1111-1111",
            "SMS 010-5555-5555",
            "CALL 010-5555-5555",
            "CALL 010-5555-5555",
            "CALL 010-4444-4444",
            "SMS 010-5555-5555",
            "CALL 010-5555-5555"
        );
    }

    private void solution(String... logs) {
        String pre = "NONE";
        int length = logs.length;
        int count = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < logs.length; i++) {
            String now = logs[i];
            if (pre.equals("NONE")) {
                pre = now;
                count = 1;
                continue;
            }

            if (pre.equals(now)) {
                count++; length--;

                if (i == logs.length - 1) {
                    sb.append(now)
                        .append(' ')
                        .append('(').append(count).append(')')
                        .append('\n');
                }
            } else {
                if (count == 1) {
                    sb.append(pre)
                        .append('\n');
                } else {
                    sb.append(pre)
                        .append(' ')
                        .append('(').append(count).append(')')
                        .append('\n');
                    count = 1;
                }

                if (i == logs.length - 1) {
                    sb.append(now)
                        .append('\n');
                }
                pre = now;
            }
        }

        StringBuilder sb2 = new StringBuilder();
        sb2.append(length).append('\n').append(sb);
        System.out.println(sb2);
    }

}
