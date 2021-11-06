package uteco;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import org.junit.jupiter.api.Test;

public class _4 {
    @Test
    public void main() {
        // solution(
        //     "aaabbaaa"
        // );

        solution(
            "wowwow"
        );
    }

    public int[] solution(String s) {
        Deque<String> dq = new ArrayDeque<>();
        StringBuilder sb = new StringBuilder();
        char pre = s.charAt(0);
        sb.append(pre);
        for (int i = 1; i < s.length(); i++) {
            char now = s.charAt(i);
            if (pre == now) {
                sb.append(now);
                if (i == s.length() - 1) {
                    dq.offer(sb.toString());
                }
            } else {
                dq.offer(sb.toString());
                sb = new StringBuilder();
                pre = now;
                sb.append(pre);

                if (i == s.length() - 1) {
                    dq.offer(sb.toString());
                }
            }
        }


        List<Integer> list = new ArrayList<>();
        if (dq.size() > 1) {
            String first = dq.pollFirst();
            String last = dq.pollLast();

            if (first.charAt(0) == last.charAt(0)) {
                list.add(first.length() + last.length());
            } else {
                list.add(first.length());
                list.add(last.length());
            }
        }

        while (!dq.isEmpty()) {
            list.add(dq.poll().length());
        }

        int[] answer = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }
        Arrays.sort(answer);
        return answer;
    }
}
