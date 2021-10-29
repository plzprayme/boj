package 부분합_1806;

import java.io.*;
import java.util.*;

import org.junit.jupiter.api.Test;

class Main {
    static int N, S;
    static int[] nums;

    private static void solution() {

        int length = Integer.MAX_VALUE; // 최댓값으로 초기화
        int l = 1, r = 1, sum = 0;      // l은 수열의 왼쪽 끝, r은 수열의 오른쪽 끝, sum은 수열의 합
        while (r <= N) {                // 반복조건: r이 수열 내부를 가리킬 때
            sum += nums[r];             // r을 항상 수열의 합에 더한다.

            while (sum >= S) {          // 반복조건: 수열의 합이 S보다 크거나 같을 때 (수열의 합이 작으면 while 패스)
                length = Math.min(length, r - l + 1); // 현재 수열의 길이와 지금까지의 수열의 길이 중 최소 값을 저장
                sum -= nums[l];         // 수열의 왼쪽 끝을 수열에서 뺀다.
                l++;                    // 수열의 왼쪽 끝을 한칸 전진시킨다.
            }

            r++;                        // 오른쪽 끝을 한 칸 전진시킨다. (수열의 합이 S보다 작다는 것이 보장됨)
        }

        if (length == Integer.MAX_VALUE) length = 0; // 수열의 합이 S보다 크지 않으면 0
        System.out.println(length);
    }

    private static void input() throws IOException {
        BufferedReader r = new BufferedReader(new FileReader("C:\\Users\\prayme\\workspace\\boj\\src\\test\\java\\부분합_1806\\input.txt"));
        StringTokenizer st = new StringTokenizer(r.readLine());
        N = Integer.parseInt(st.nextToken()); S = Integer.parseInt(st.nextToken());
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

