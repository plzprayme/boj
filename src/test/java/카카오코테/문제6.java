package 카카오코테;

import org.junit.jupiter.api.Test;

public class 문제6 {
    public int solution(int[][] board, int[][] skill) {

        // int answer = board[0].length * board.length;

        for (int[] s : skill) {
            if (s[0] == 1) {
                s[5] = -s[5];
            }

            int rmn = Math.min(s[1], s[3]);
            int rmx = Math.max(s[1], s[3]);
            int cmn = Math.min(s[2], s[4]);
            int cmx = Math.max(s[2], s[4]);
            for (int r = rmn; r <= rmx; r++) {
                for (int c = cmn; c <= cmx; c++) {
                    board[r][c] += s[5];
                }
            }
        }

        int answer = 0;
        for (int[] i : board) {
            for (int j : i) {
                if (j > 0) answer++;
            }
        }

        return answer;
    }

    @Test
    public void main() {
        System.out.println(
            solution(
                new int[][] {
                    { 5,5,5,5,5 },
                    { 5,5,5,5,5 },
                    { 5,5,5,5,5 },
                    { 5,5,5,5,5 }
                },

                new int[][] {
                    {1,0,0,3,4,4},{1,2,0,2,3,2},{2,1,0,3,1,2},{1,0,1,3,3,1}
                }
            )
        );

        System.out.println(
            solution(
                new int[][] {
                    {1,2,3},{4,5,6},{7,8,9}
                },

                new int[][] {
                    {1,1,1,2,2,4},{1,0,0,1,1,2},{2,2,0,2,0,100}
                }
            )
        );
    }
}
