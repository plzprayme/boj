package 카카오기출;

import java.util.Arrays;
import java.util.Stack;

import org.junit.jupiter.api.Test;

public class 거리두기확인하기 {
    @Test
    public void 예제() {
        System.out.println(Arrays.toString(new Solution().solution(
            new String[][] {
                {"POOOP", "OXXOX", "OPXPX", "OOXOX", "POXXP"},
                {"POOPX", "OXPXP", "PXXXO", "OXXXO", "OOOPP"},
                {"PXOPX", "OXOXP", "OXPOX", "OXXOP", "PXPOX"},
                {"OOOXX", "XOOOX", "OOOXX", "OXOOX", "OOOOO"},
                {"PXPXP", "XPXPX", "PXPXP", "XPXPX", "PXPXP"}
            }
        )));
    }

    private class Solution {

        private static final char PERSON = 'P';
        private static final char TABLE = 'O';

        private int[][] map;
        private Stack<Position> stack;

        public int[] solution(String[][] places) {
            int[] answer = new int[5];

            s:
            for (int t = 0; t < places.length; t++) {

                // 맵 그리기
                map = new int[5][5];
                stack = new Stack<>();
                drawMap(places[t]);

                while (!stack.isEmpty()) {
                    Position now = stack.pop();

                    // 상 하 좌 우
                    if (
                        validateUpDownRightLeft(now.x, now.y - 1) ||
                            validateUpDownRightLeft(now.x, now.y + 1) ||
                            validateUpDownRightLeft(now.x + 1, now.y) ||
                            validateUpDownRightLeft(now.x - 1, now.y)
                    ) {
                        answer[t] = 0;
                        continue s;
                    }

                    // 대각선
                    if (
                        isIllegal(now.x + 1, now.y - 1) &&
                            isPerson(now.x + 1, now.y - 1) &&
                            (isTable(now.x, now.y - 1) || isTable(now.x + 1, now.y))
                    ) {
                        answer[t] = 0;
                        continue s;
                    }

                    if (
                        isIllegal(now.x + 1, now.y + 1) &&
                            isPerson(now.x + 1, now.y + 1) &&
                            (isTable(now.x, now.y + 1) || isTable(now.x + 1, now.y))
                    ) {
                        answer[t] = 0;
                        continue s;
                    }

                    if (
                        isIllegal(now.x - 1, now.y + 1) &&
                            isPerson(now.x - 1, now.y + 1) &&
                            (isTable(now.x, now.y + 1) || isTable(now.x - 1, now.y))
                    ) {
                        answer[t] = 0;
                        continue s;
                    }

                    if (
                        isIllegal(now.x - 1, now.y - 1) &&
                            isPerson(now.x - 1, now.y - 1) &&
                            (isTable(now.x, now.y - 1) || isTable(now.x - 1, now.y))
                    ) {
                        answer[t] = 0;
                        continue s;
                    }


                    // 상 하 좌 우 2칸씩씩
                   if (
                        isIllegal(now.x, now.y - 2) &&
                            isPerson(now.x, now.y - 2) &&
                            isTable(now.x, now.y - 1)
                    ) {
                        answer[t] = 0;
                        continue s;
                    }

                    if (
                        isIllegal(now.x + 2, now.y) &&
                            isPerson(now.x + 2, now.y) &&
                            isTable(now.x + 1, now.y)
                    ) {
                        answer[t] = 0;
                        continue s;
                    }

                    if (
                        isIllegal(now.x, now.y + 2) &&
                            isPerson(now.x, now.y + 2) &&
                            isTable(now.x, now.y + 1)
                    ) {
                        answer[t] = 0;
                        continue s;
                    }


                    if (
                        isIllegal(now.x - 2, now.y) &&
                            isPerson(now.x - 2, now.y) &&
                            isTable(now.x - 1, now.y)
                    ) {
                        answer[t] = 0;
                        continue s;
                    }

                }

                answer[t] = 1;
            }

            return answer;
        }

        private void drawMap(String[] place) {
            for (int y = 0; y < 5; y++) {
                char[] row = place[y].toCharArray();
                for (int x = 0; x < 5; x++) {
                    map[y][x] = row[x];

                    // 사람 좌표 기억하기
                    if (map[y][x] == PERSON) {
                        stack.add(new Position(x, y));
                    }
                }
            }
        }

        private boolean isIllegal(int x, int y) {
            return 0 <= x && x < 5 && 0 <= y && y < 5;
        }

        private boolean isPerson(int x, int y) {
            return map[y][x] == PERSON;
        }

        private boolean validateUpDownRightLeft(int x, int y) {
            return isIllegal(x, y) && isPerson(x, y);
        }

        private boolean isTable(int x, int y) {
            return map[y][x] == TABLE;
        }

        private class Position {
            int x, y;

            public Position(int x, int y) {
                this.x = x;
                this.y = y;
            }
        }
    }
}
