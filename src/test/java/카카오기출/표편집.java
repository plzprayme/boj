package 카카오기출;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;
import java.util.StringTokenizer;

import org.junit.jupiter.api.Test;

public class 표편집 {

    @Test
    public void main1() {
        solution(
            8, 2,
            new String[] {
                "D 2",
                "C",
                "U 3",
                "C",
                "D 4",
                "C",
                "U 2",
                "Z",
                "Z"
            }
        );

        solution(
            8, 2,
            new String[] {
                "D 2",
                "C",
                "U 3",
                "C",
                "D 4",
                "C",
                "U 2",
                "Z",
                "Z",
                "U 1",
                "C"
            }
        );
    }

    public String solution(int n, int k, String[] cmd) {
        LinkedList<Row> list = new LinkedList<>();
        Stack<Row> undo = new Stack<>();
        for (int i = 0; i < n; i++) {
            list.add(new Row(i, i));
        }

        int cursor = k;
        for (String c : cmd) {
            StringTokenizer st = new StringTokenizer(c);

            String action = st.nextToken();
            if (action.equals("U")) {
                cursor -= Integer.parseInt(st.nextToken());
            } else if (action.equals("D")) {
                cursor += Integer.parseInt(st.nextToken());
            } else if (action.equals("C")) {
                Row now = list.get(cursor);
                undo.add(new Row(cursor, now.num));
                list.remove(cursor);

                // 맨 마지막을 지웠을 떄 커서 한칸 내리기
                if (list.size() <= cursor) cursor--;
            } else if (action.equals("Z")) {
                Row pre = undo.pop();
                list.add(pre.cursor, pre);

                // 커서보다 앞에 추가했을 때 커서 한칸 위로
                if (pre.cursor <= cursor) cursor++;
            }
        }

        boolean[] isSame = new boolean[n];
        Deque<Row> dq = new LinkedList<>(list);
        while (!dq.isEmpty()) {
            isSame[dq.poll().num] = true;
        }

        StringBuilder sb = new StringBuilder();
        for (boolean b : isSame) {
            if (b) sb.append('O');
            else sb.append('X');
        }

        return sb.toString();
    }

    class Row {
        int cursor;
        int num;

        public Row(int cursor, int num) {
            this.cursor = cursor;
            this.num = num;
        }

        @Override
        public String toString() {
            return "Row{" +
                "cursor=" + cursor +
                ", num=" + num +
                '}';
        }
    }
}
