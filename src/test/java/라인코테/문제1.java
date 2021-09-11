package 라인코테;

import java.util.Stack;

import org.junit.jupiter.api.Test;

public class 문제1 {
    public int solution(int[] student, int k) {

        Stack<Position> stack = new Stack<>();
        for (int i = 0; i < student.length; i++) {
            if (student[i] == 1) {
                int count = student[i] == 1 ? 1 : 0;
                if (count == k) {
                    stack.add(new Position(i, i));
                    continue;
                }
                for (int j = i + 1; j < student.length; j++) {
                    if (student[j] == 1)
                        count++;
                    if (count == k) {
                        stack.add(new Position(i, j));
                        break;
                    }
                }
            }
        }



        int answer = stack.size();
        while(!stack.isEmpty()) {
            Position p = stack.pop();
            int left = p.left;
            int right = p.right;

            int _left = 0;
            while (true) {
                left--;
                if (left == -1) break;
                if (student[left] == 1) break;
                _left++;
            }
            int _right = 0;
            while (true) {
                right++;
                if (right == student.length) break;
                if (student[right] == 1) break;
                _right++;
            }

            answer +=_left * _right + _left + _right;
        }

        return answer;
    }

    class Position {
        int left, right;

        public Position(int left, int right) {
            this.left = left;
            this.right = right;
        }

    }

    @Test
    public void main() {
        System.out.println(
            solution(
                new int[] {0, 1, 0, 0}, 1
            )
        );

        System.out.println(
            solution(
                new int[] {0, 1, 0, 0, 1, 1, 0}, 2
            )
        );

        System.out.println(
            solution(
                new int[] {0, 1, 0}, 2
            )
        );
    }
}
