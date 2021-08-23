package 작업;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

import org.junit.jupiter.api.Test;

public class 작업 {

    static BufferedReader r;

    @Test
    public static void main(String[] args) throws IOException {
        r = new BufferedReader(
            new FileReader("C:\\Users\\prayme\\workspace\\boj\\src\\test\\java\\작업\\input.txt"));

        int N = parse(r.readLine());
        int[] dp = new int[N + 1];

        int answer = 0;
        for (int i = 1; i < N + 1; i++) {
            StringTokenizer st = new StringTokenizer(r.readLine());
            int time = parse(st.nextToken());
            int pre = parse(st.nextToken());

            dp[i] = time;
            for (int j = 0; j < pre; j++) {
                int temp = parse(st.nextToken());
                // dp[temp] + time = 사전 작업까지의 소요 시간 + 지금 작업의 소요시간
                // dp[i] = 사전 작업들 중 가장 큰 값 (해당 루프에 들어오면 위에서 정의한 dp[i] 보다는 무조건 클 수 밖에 없음)
                dp[i] = Math.max(dp[i], dp[temp] + time);
            }

            // 전부 다 사전 작업이 없을 때를 대비
            answer = Math.max(answer, dp[i]);
        }

        System.out.println(answer);
    }

    @Test
    public void 사전작업_없음() throws IOException {
        r = new BufferedReader(new FileReader("C:\\Users\\prayme\\workspace\\boj\\src\\test\\java\\작업\\전부다사전작업없음.txt"));

        int N = parse(r.readLine());
        int[] dp = new int[N + 1];

        int max = 0;
        for (int i = 1; i < N + 1; i++) {
            StringTokenizer st = new StringTokenizer(r.readLine());
            int time = parse(st.nextToken());
            int pre = parse(st.nextToken());

            if (pre == 0) {
                dp[i] = time;
                max = Math.max(time, max);
            } else {
                int longest = 0;
                for (int j = 0; j < pre; j++) {
                    int index = parse(st.nextToken());
                    longest = Math.max(longest, dp[index]);
                }
                dp[i] = longest + time;
            }

        }

        System.out.println(Math.max(max, dp[N]));
    }


    @Test
    public void 위상정렬() throws IOException {
        BufferedReader r = new BufferedReader(
            new FileReader("C:\\Users\\prayme\\workspace\\boj\\src\\test\\java\\작업\\input.txt"));
        StringTokenizer st;

        int N = parse(r.readLine());
        List<List<Integer>> a = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            a.add(new ArrayList<>());
        }

        int[] indegree = new int[N + 1];
        int[] time = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(r.readLine());

            // i 번째 작업을 수행하는데에 걸리는 시간. (누적시간 아님)
            time[i] = parse(st.nextToken());

            int num = parse(st.nextToken());
            for (int j = 0; j < num; j++) {
                int temp = parse(st.nextToken());
                // i 번째 작업의 선행 작업들에 해당하는 인덱스에
                // i 번쨰 작업 넣기
                // ex) i-> 7 / 4 3 3 5 6 -> 3, 5, 6 에 7을 추가함
                a.get(temp).add(i);
                // i 번째 작업의 선행 작업 숫자 세기
                // indegree[i]++;
            }
            // indegree[i] = num; 으로 대체할 수도 있음
            indegree[i] = num;
        }

        System.out.println(topologicalSort(N, a, indegree, time));

    }

    private static int topologicalSort(int N, List<List<Integer>> a, int[] indegree, int[] time) {
        Queue<Integer> q = new LinkedList<>();

        int[] result = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            result[i] = time[i]; // 작업이 걸리는 시간들

            // 선행 작업이 0인 작업은
            if (indegree[i] == 0) {
                // 큐에 넣는다.
                q.offer(i);
            }
        }

        while (!q.isEmpty()) {
            // 선행 작업이 없는 것들부터 리턴이 된다.
            // 선행
            int now = q.poll();

            // 현재 작업은 누군가의 사전 작업이다.
            // next는 부모 작업
            for (int next : a.get(now)) {
                // 부모 작업의 사전 작업 카운트를 하나 낮춤
                indegree[next]--;

                // 부모 작업의의
               result[next] = Math.max(result[next], result[now] + time[next]);

               // 부모 작업의 사전 작업이 모두 완료 되었다면 큐에 넣음
               if (indegree[next] == 0) {
                   q.offer(next);
               }
            }
        }

        int answer = 0;
        for (int i = 1; i <= N; i++) {
            answer = Math.max(answer, result[i]);
        }
        return answer;
    }

    private static int parse(String s) {
        return Integer.parseInt(s);
    }
}
