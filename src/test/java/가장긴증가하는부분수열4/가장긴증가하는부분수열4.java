package 가장긴증가하는부분수열4;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

import org.junit.jupiter.api.Test;

public class 가장긴증가하는부분수열4 {
    @Test
    public static void main(String[] args) throws IOException {
        BufferedReader r = new BufferedReader(new FileReader("C:\\Users\\prayme\\workspace\\boj\\src\\test\\java\\가장긴증가하는부분수열4\\input.txt"));

        // 코딩하기 편하게 N + 1로 설정
        int N = parse(r.readLine()) + 1;
        int[] nums = new int[N];
        int[][] dp = new int[N][N];
        StringTokenizer st = new StringTokenizer(r.readLine());
        for (int i = 1; i < N; i++) {
            nums[i] = parse(st.nextToken());
        }

        // 큰 순서대로 정렬되는 Result 타입을 아이템으로 가지는 우선순위 큐 선언
        PriorityQueue<Result> pq = new PriorityQueue<>();
        for (int y = 1; y < N; y++) {
            // 최대 값 설정
            int max = nums[y];
            for (int x = y; x < N; x++) {
                // 자기 자신은 1로 설정
                if (x == y) dp[y][x] = 1;
                // 증가 했으면 왼쪽의 값 + 1 / max 값 재설정
                else if (nums[x] > max) { max = nums[x]; dp[y][x] = dp[y][x-1] + 1;}
                // 증가 안했으면 왼쪽의 값 그대로 쓰기
                else dp[y][x] = dp[y][x-1];
            }

            // 결과 값들 우선순위 큐에 넣어두기
            pq.add(new Result(dp[y][N-1], y));
        }

        List<Integer> answer = new ArrayList<>();
        Result result = pq.poll();
        int y = result.y;
        for (int x = y - 1; x < N - 1; x++) {
            if (dp[y][x] != dp[y][x+1]) answer.add(nums[x+1]);
        }

        System.out.println(result.count);
        StringBuilder sb = new StringBuilder();
        for (int i : answer) {
            sb.append(String.format("%d ", i));
        }
        System.out.println(sb);
    }

    private static class Result implements Comparable<Result> {
        int count, y;

        public Result(int count, int y) {
            this.count = count;
            this.y = y;
        }

        @Override
        public int compareTo(Result o) {
            if (count > o.count) return -1;
            else if (count == o.count) return 0;
            else return 1;
        }

        @Override
        public String toString() {
            return "Result{" +
                "count=" + count +
                ", y=" + y +
                '}';
        }
    }

    private static int parse(String s) {
        return Integer.parseInt(s);
    }
}
