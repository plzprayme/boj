package 수들의합2_2003;

import java.io.*;
import java.util.*;

import org.junit.jupiter.api.Test;

class Main {

    static int N, M;
    static int[] nums;

    private static void solution() {
        int l = 1, r = 1, sum = 0, count = 0;

        // 현재 l과 r이 가리키는 수열의 상태를 기준으로 코드를 작성하자
        s: while (r <= N) {
            // 수열의 가장 오른쪽을 더하고 시작한다.
            sum += nums[r];

            // 현재 수열이 M보다 크면
            while (sum > M) {
                // 왼쪽을 빼고 한칸 전진
                sum -= nums[l++];
                // 근데 한 엘리먼트가 M보다 클 수도 있다.
                // 예를들어서, M은 3인데 nums[3] = 5 일 수도 있다.
                // 그럴 때는 3번 인덱스를 건너 뛴다.
                if (l > r) {
                    r = l;
                    continue s;
                }
            }

            // SUM과 M이 같은데 현재 같은 위치를 가리키는 상황
            // 같은 위치를 가리키면 건너 뛰어줘야한다.
            // 그래서 r++; l = r; 로 건너뛴다.
            if (sum == M && l == r) {
                count++;
                l = ++r;
                sum = 0;
                continue;
            }

            // SUM과 M이 같은데 서로 다른 위치를 가리킨다.
            // 왼쪽 한칸 전진, 오른쪽도 한칸 전진
            if (sum == M) {
                count++;
                sum -= nums[l++];
                r++;
                continue;
            }

            // SUM이 M보다 작을 때는 그냥 오른쪽을 한칸 전진 (수열이 커진다)
            ++r;
        }

        System.out.println(count);
    }

    private static void input() throws IOException {
        BufferedReader r = new BufferedReader(new FileReader("C:\\Users\\prayme\\workspace\\boj\\src\\test\\java\\수들의합2_2003\\input.txt"));
        StringTokenizer st = new StringTokenizer(r.readLine());
        N = Integer.parseInt(st.nextToken()); M = Integer.parseInt(st.nextToken());
        nums = new int[N + 1];

        st = new StringTokenizer(r.readLine());
        for (int i = 1; i <= N; i++) nums[i] = Integer.parseInt(st.nextToken());
    }

    @Test
    public static void main(String[] args) throws IOException {
        input();
        solution();
    }

}

