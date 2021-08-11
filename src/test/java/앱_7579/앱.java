package 앱_7579;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

import org.junit.jupiter.api.Test;

public class 앱 {
    @Test
    public static void main(String[] args) throws IOException {
        BufferedReader r = new BufferedReader(
            new FileReader("C:\\Users\\prayme\\workspace\\boj\\src\\test\\java\\앱_7579\\input.txt"));
        BufferedWriter w = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(r.readLine());
        int N = parse(st.nextToken());
        int M = parse(st.nextToken());

        st = new StringTokenizer(r.readLine());
        int[] memories = new int[N];
        for (int i = 0; i < N; i++) {
            memories[i] = parse(st.nextToken());
        }

        st = new StringTokenizer(r.readLine());
        int[] costs = new int[N];
        for (int i = 0; i < N; i++) {
            costs[i] = parse(st.nextToken());
        }

        PriorityQueue<App> pq = new PriorityQueue<>();
        for (int i = 0; i < N; i++) {
            pq.add(new App(memories[i], costs[i]));
        }

        int answer = 0;
        while (M > 0) {
            App min = pq.poll();
            answer += min.cost;
            M -= min.memory;
        }

        w.write(String.valueOf(answer));
        w.flush();
    }

    private static class App implements Comparable<App> {
        int memory;
        int cost;

        public App(int memory, int cost) {
            this.memory = memory;
            this.cost = cost;
        }

        @Override
        public int compareTo(App left) {
            // 코스트 오름차순
            if (cost > left.cost)
                return 1;
            if (cost < left.cost)
                return -1;

            // 코스트가 같을때 메모리는 내림차순
            if (memory > left.memory)
                return -1;
            if (memory < left.memory)
                return 1;

            // 둘 다 같을 땐 안바꿈
            return 0;
        }
    }

    private static int parse(String s) {
        return Integer.parseInt(s);
    }
}
