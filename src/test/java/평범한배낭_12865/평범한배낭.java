package 평범한배낭_12865;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;

import org.junit.jupiter.api.Test;

public class 평범한배낭 {
    @Test
    public static void main(String[] args) throws IOException {
        /**
         * 모든 경우의 수 탐색이 필요해보인다.
         * ex ) K=7 / (6, 100,000), (5, 10), (5, 20), (8, 50), (9, 15), (7, 0)
         *
         * V=0 인 것 제외, K > W인 것 제외외
         */

        BufferedReader r = new BufferedReader(new FileReader("C:\\Users\\prayme\\workspace\\boj\\src\\test\\java\\평범한배낭_12865\\input.txt"));
        BufferedWriter w = new BufferedWriter(new OutputStreamWriter(System.out));

        // N K 입력 받기
        String[] nk = r.readLine().split(" ");
        int N = parse(nk[0]);
        int K = parse(nk[1]);

        // 정렬된 상태의 Map
        SortedMap<Integer, Integer> map = new TreeMap<>();
        for (int i = 0; i < N; i++) {
            // W V 입력 받기
            String[] wv = r.readLine().split(" ");
            int W = parse(wv[0]);
            int V = parse(wv[1]);

            // 가치가 0이거나 무게가 배낭의 최대 용량보다 클 경우 스킵
            if (V == 0) continue;
            if (W > K) continue;

            // 최댓값만 저장
            int value = Math.max(map.getOrDefault(W, V), V);
            map.put(W, value);
        }


        //
        int answer = 0;
        Set<Integer> keys = map.keySet();
        for (int key : keys) {

            int tmp = key;
            int value = map.get(key);
            for (int next : keys) {
                tmp = key + next;
                if (tmp > K) break;
                if (key == next) continue;

                value += map.get(next);
            }
            answer = Math.max(answer, value);

        }

        w.write(String.valueOf(answer));
        w.flush();
    }

    private static int parse(String s) {
        return Integer.parseInt(s);
    }
}
