package siliconvallery;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Queue;

import org.junit.jupiter.api.Test;

public class _1 {
    public int[] solution(int rows, int columns, int[][] connections, int[][] queries) {
        int[] answer = {};
        // 그래프 만들기
        Map<Position, List<Position>> graph = getGraph(connections);

        // 자르기
        for (int[] query : queries) {
            int r1 = query[0]; int c1 = query[1];
            int r2 = query[2]; int c2 = query[3];

            int maxR = Math.max(r1, r2);
            int minR = Math.min(r1, r2);
            int maxC = Math.max(c1, c2);
            int minC = Math.min(c1, c2);

            int count = 0;
            // 위 테두리
            for (int x = minC; x <= maxC; x++) {
                List<Position> next = graph.getOrDefault(new Position(maxR, x), new ArrayList<>());
                Queue<Integer> index = new LinkedList<>();
                for (int i = 0; i < next.size(); i++) {
                    int _x = next.get(i).x;
                    int _y = next.get(i).y;

                    if (isOut(_x, _y, minC, maxC, maxR, minR)) {
                        index.add(i);
                        count++;
                    }

                    while(!index.isEmpty()) {
                        next.remove(index.poll());
                    }

                }
            }

            System.out.println(count);
        }

        return answer;
    }

    private boolean isOut(int x, int y, int minC, int maxC, int maxR, int minR) {
        return x < minC || x > maxC || y > maxR || y < minR;
    }

    private Map<Position, List<Position>> getGraph(int[][] connections) {
        Map<Position, List<Position>> graph = new HashMap<>();
        for (int i = 0; i < connections.length; i++) {
            int[] row = connections[i];
            int r1 = row[0]; int c1 = row[1];
            int r2 = row[2]; int c2 = row[3];

            Position R1 = new Position(r1, c1);
            Position R2 = new Position(r2, c2);

            if (graph.containsKey(R1)) {
                graph.get(R1).add(R2);
            } else {
                List<Position> tmp = new ArrayList<>();
                tmp.add(R2);
                graph.put(R1, tmp);
            }

            if (graph.containsKey(R2)) {
                graph.get(R2).add(R1);
            } else {
                List<Position> tmp = new ArrayList<>();
                tmp.add(R1);
                graph.put(R2, tmp);
            }
        }

        return graph;
    }

    private static class Position {
        int y, x;

        public Position(int y, int x) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Position)) return false;
            Position position = (Position)o;
            return x == position.x && y == position.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }

    @Test
    public void main() {
        System.out.println(
            Arrays.toString(
                solution(
                    4, 3,
                    new int[][] {
                        {1,1,2,1},
                        {1,2,1,3},
                        {1,3,2,3},
                        {2,2,2,3},
                        {2,2,3,2},
                        {2,3,3,3},
                        {3,2,3,3},
                        {3,2,4,2},
                        {4,1,4,2}
                    },
                    new int[][] {
                        {2,2,3,1},{1,2,4,2}
                    }
                    )
            )
        );
    }
}
