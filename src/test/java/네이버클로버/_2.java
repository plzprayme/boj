package 네이버클로버;

import org.junit.jupiter.api.Test;

public class _2 {

    public int solution(int[] A) {
        if (A.length == 1 || A.length == 2) return A.length;
        return solve(A);
    }

    private int solve(int[] A) {
        int distance = 2;
        int start = 0;
        int nowL = 0, nowR = 1;
        while (nowL < A.length) {
            int nl = nowL + 2;
            int nr = nowR + 2;

            // 둘 다 범위 안이면서
            if (nl < A.length && nr < A.length) {
                // 왼 오 모두 같을 때
                if (A[nowL] == A[nl] && A[nowR] == A[nr]) {
                    distance = Math.max(distance, nr - start + 1);
                    nowL += 2;
                    nowR += 2;
                }
                // 왼 다르다
                else if (A[nowL] != A[nl]) {
                    start = ++nowL;
                    nowR = nowL + 1;
                }
                // 왼 같은데 오 다를 때
                else if (A[nowL] == A[nl] && A[nowR] != A[nr]) {
                    distance = Math.max(distance, nl - start + 1);
                    start = nl;
                    nowL = nl;
                    nowR = nl + 1;
                }

            }
            // 왼쪽은 범위 안인데 오른쪽은 범위 밖일 떄
            else if (nl < A.length && nr > A.length - 1) {
                if (A[nowL] == A[nl]) {
                    distance = Math.max(distance, nl - start + 1);
                    nowL = nl;
                    nowR = nowL + 1;
                } else {
                    start = ++nowL;
                    nowR = nowL + 1;
                }
            }
            else {
                break;
            }
        }
        return distance;
    }

    @Test
    public void main() {
        // System.out.println(solution(new int[] {3, 2, 3, 2, 3}));
        // System.out.println(solution(new int[] {7, 4, -2, 4, -2, 9}));
        // System.out.println(solution(new int[] {7, -5, -5, -5, 7, -1, 7}));
        // System.out.println(solution(new int[] {3, 3, 3}));
        // System.out.println(solution(new int[] {3, 3, 3, 3}));
        System.out.println(solution(new int[] {3, 1, 1, 3}));
        System.out.println(solution(new int[] {5, 1, 3, 1, 5}));
        // System.out.println(solution(new int[] {3, 3}));
        // System.out.println(solution(new int[] {3, 1}));

    }
}
