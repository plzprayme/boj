package 우체국_2141;

import java.io.*;
import java.util.*;

import org.junit.jupiter.api.Test;

class Main {

    static int N;
    static int[] X, A;

    static int[] populationSum;
    static int[] positionSum;

    static City[] cities;
    static Info[] infos;

    static class Info {
        int popSum, diffSum;

        public Info(int popSum, int diffSum) {
            this.popSum = popSum;
            this.diffSum = diffSum;
        }
    }

    static class City implements Comparable<City> {
        int position, population;

        public City(int position, int population) {
            this.position = position;
            this.population = population;
        }


        @Override
        public int compareTo(City o) {
            return Integer.compare(position, o.population);
        }
    }

    @Test
    public static void main(String[] args) throws IOException {
        input();
        solution();
    }

    private static void solution() {
        // 일직선상에 N개의 마을
        // X[i]에 위치한 마을은 A[i] 명이 살고 있다.

        // 각 사람들 사이의 거리의 합이 최소가 되는 위치에 우체국 세우기
        // 각 사람까지의 거리의 합!

        // 양 옆의 거리의 합과 양 옆의 사람 수 누적합
        // 양 옆의 거리의 합. 양 옆의 사람 수 누적합

        // 제일 코스트가 작은 지점을 찾아보자


        // 양 옆의 거리의 차의 합이 최소, 양 옆의 누적합 최소
        Arrays.sort(cities);

        // 그러면 이분 탐색을 써보자
        // 좌표를 기준으로?
        //

       // 기준이 두개다..
        // 사람과 거리
        // 사람도 적어야하고

        // 사람 수 누적 합 구하기
        populationSum[0] = cities[0].population;
        for (int i = 1; i < N; i++) {
            populationSum[i] = cities[i].population + populationSum[i - 1];
        }

        // 좌표 누적 합 구하기
        positionSum[0] = cities[0].position;
        for (int i = 1; i < N; i++) {
            positionSum[i] = cities[i].position + positionSum[i - 1];
        }

        // 기준 구하기
        infos[0] = new Info(populationSum[N - 1] - populationSum[0], positionSum[N - 1] - positionSum[0]);
        infos[N - 1] = new Info(populationSum[N - 2], positionSum[N - 2]);
        for (int i = 1; i < N - 1; i++) {
            infos[i] = new Info(populationSum[i - 1] + populationSum[N - 1] - populationSum[i], positionSum[i - 1] + positionSum[N - 1] - positionSum[i]);
        }

        System.out.println("");
    }

    private static void input() throws IOException {
        InputReader r = new InputReader("C:\\Users\\workspace\\boj\\src\\test\\java\\우체국_2141\\input.txt");

        N = r.nextInt();

        cities = new City[N];
        for (int i = 0; i < N; i++) {
            cities[i] = new City(r.nextInt(), r.nextInt());
        }

        infos = new Info[N];
        populationSum = new int[N];
        positionSum = new int[N];
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
        }    }


}
