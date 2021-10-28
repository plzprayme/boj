package 통계학_2108;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

import org.junit.jupiter.api.Test;

class Main {
    @Test
    public static void main(String[] args) throws IOException {
        BufferedReader r =new BufferedReader(new FileReader("C:\\Users\\prayme\\workspace\\boj\\src\\test\\java\\통계학_2108\\input.txt"));
        BufferedWriter w = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = parse(r.readLine());
        int[] arr = new int[N];
        Map<Integer, Integer> counter = new HashMap<>();
        for (int i = 0; i < N; i++) {
            int num = parse(r.readLine());
            arr[i] = num;
            counter.put(num, counter.getOrDefault(num, 0) + 1);
        }

        Map<Integer, Integer> sortedCounter = new LinkedHashMap<>(counter);
        Set<Map.Entry<Integer, Integer>> sortedEntry = sortedCounter.entrySet();
        int k = 0;
        int count = 0;
        for (Map.Entry<Integer, Integer> e : sortedCounter.entrySet()) {
            if (count == 0) {
                k = e.getKey();
                count = e.getValue();
                continue;
            }

            if (count == e.getValue()) {
                k = Math.min(k, e.getKey());
                break;
            }

            break;
        }
        Arrays.sort(arr);

        String template = "%d\n";
        System.out.printf("%.0f\n", Math.floor(Arrays.stream(arr).sum() / N));
        System.out.printf(template, arr[N/2]);
        System.out.printf(template, k);
        System.out.printf(template, Math.abs(arr[0]) + Math.abs(arr[arr.length - 1]));
        w.flush();
    }


    private static int parse(String s) {
        return Integer.parseInt(s);
    }

    private static String parseString(int i) {
        return String.valueOf(i);
    }
}
