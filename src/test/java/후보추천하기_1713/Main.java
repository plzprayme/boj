package 후보추천하기_1713;

import java.io.*;
import java.util.*;

import org.junit.jupiter.api.Test;

class Main {

    static int N, M;
    static SortedMap<Integer, Integer> counter;

    static int[] num;
    static int[] age;

    @Test
    public static void main(String[] args) throws IOException {
        input();
        solution();
    }

    private static void solution() {
        // 추천하기 전 사진틀 비어있다.
        // 추천 받은 학생의 사진이 사진틀에 게시


        for (int i : num) {
            if (counter.containsKey(i)) {
                counter.put(i, counter.getOrDefault(i, 0) + 1);
            } else {
                if (counter.size() == N) {

                    int maxKey = 0;
                    int minValue = Integer.MAX_VALUE;
                    int maxAge = -1;
                    for (var entry : counter.entrySet()) {
                        if (minValue >= entry.getValue() && maxAge < age[entry.getKey()]) {
                            maxKey = entry.getKey();
                            minValue = entry.getValue();
                            maxAge = age[entry.getKey()];
                        }
                    }

                    counter.remove(maxKey);
                    counter.put(i, 1);
                    age[maxKey] = 0;
                } else {
                    counter.put(i, counter.getOrDefault(i, 0) + 1);
                }
            }
        }

        for (var key : counter.keySet()) {
            age[key]++;
        }


        StringBuilder sb = new StringBuilder();
        int[] answer = new int[N];
        int count = 0;
        for (int i : counter.keySet()) {
            answer[count++] = i;
        }
        Arrays.sort(answer);
        for (int i : answer) {
            sb.append(i).append(' ');
        }
        System.out.println(sb);

    }

    private static void input() throws IOException {
        InputReader r = new InputReader("C:\\Users\\workspace\\boj\\src\\test\\java\\후보추천하기_1713\\input.txt");
        N = r.nextInt();
        M = r.nextInt();

        counter = new TreeMap<>();

        num = new int[M];
        for (int i = 0; i < M; i++) {
            num[i] = r.nextInt();
        }

        age = new int[101];
    }

    private static class InputReader {
        StringTokenizer st;
        BufferedReader r;

        public InputReader(String filePath) throws FileNotFoundException {
            this(new FileReader(filePath));
        }

        public InputReader() {
            this(new InputStreamReader(System.in));
        }

        private InputReader(InputStreamReader reader) {
            r = new BufferedReader(reader);
            st = new StringTokenizer("");
        }

        public int nextInt() throws IOException {
            if (!st.hasMoreTokens()) st = new StringTokenizer(r.readLine());
            return Integer.parseInt(st.nextToken());
        }

        public char[] nextCharArr() throws IOException {
            return r.readLine().toCharArray();
        }
    }


}

