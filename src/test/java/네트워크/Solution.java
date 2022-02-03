package 네트워크;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Solution {

    boolean[] visited;
    static List<Integer>[] graph;
    static Queue<Integer> queue = new LinkedList<>();

    static int answer = 0;

    public int solution(int n, int[][] computers) {
        // 입력
        initGraph(n, computers);
        visited = new boolean[n];

        for (int startNode = 0; startNode < n; startNode++) {
            if (visited[startNode]) continue;
            answer += bfs(startNode);
        }

        return answer;
    }

    private void initGraph(int n, int[][] computers) {
        graph = new List[n];
        for (int i = 0; i < n; i++) graph[i] = new ArrayList<>();

        for (int parent = 0; parent < n; parent++) {
            for (int child = 0; child < n; child++) {
                if (computers[parent][child] == 0) continue;
                graph[parent].add(child);
            }
        }
    }

    private int bfs(int startNode) {
        queue.add(startNode);
        visited[startNode] = true;

        while (!queue.isEmpty()) {
            int cur = queue.poll();

            for (int next : graph[cur]) {
                if (visited[next]) continue;
                queue.add(next);
                visited[next] = true;
            }
        }

        return 1;
    }

    @Test
    public void asd() {
        int[][] input = new int[][]{
                {1, 1, 0},
                {1, 1, 0},
                {0, 0, 1}
        };

        int[][] input2 = new int[][]{
                {1, 1, 0},
                {1, 1, 1},
                {0, 1, 1}
        };
        assertEquals(2, solution(3, input));
        assertEquals(1, solution(3, input2));
    }

}
