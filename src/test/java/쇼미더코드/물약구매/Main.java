package 쇼미더코드.물약구매;

import java.io.*;
import java.util.*;

import org.junit.jupiter.api.Test;

class Main {

    static int N;
    static Potion[] potions;
    static List<Sale>[] sale;

    static boolean[] selected;
    static int answer = Integer.MAX_VALUE;

    static class Potion implements Comparable<Potion> {
        int idx, cost, out;

        private int minusCost, plusCost;

        public Potion(int idx, int cost) {
            this.idx = idx;
            this.cost = cost;
            minusCost = cost;
        }

        public void setOut(int out) {
            this.out = out;
        }

        public void minus(int weight) {
            minusCost = minusCost - weight;
            plusCost = weight;
            cost = cost - weight;
            if (cost <= 0) cost = 1;
        }

        public void plus(int weight) {
            plusCost = plusCost - weight;
            minusCost = minusCost + weight;
            if (minusCost > 1) {
                cost = minusCost;
            }
        }


        @Override
        public int compareTo(Potion o) {
            int first = Integer.compare(cost, o.cost);
            if (first == 0) {
                return Integer.compare(o.out, out);
            }

            return first;
        }

        @Override
        public boolean equals(Object o) {
            return idx == ((Potion) o).idx;
        }
    }

    static class Sale {
        int idx, cost;

        public Sale(int idx, int cost) {
            this.idx = idx;
            this.cost = cost;
        }
    }


    @Test
    public static void main(String[] args) throws IOException {
        input();
        solution();
    }

    private static void solution() {
        // 모험을 떠나기 전 철저한 사전 준비
        // N 종류의 물약을 모두 구매
        // 특정 물약을 구매하면 다른 물약들 할인

        // i번째 물약이 ci 였으면 i번째 물약을 구매하면 pi 종류의 물약 가격이 내려간다.

        // 가장 싸게 물약을 사는 방법을 알려주자

        // 그리디 같다.

        // N 이 10이니까 꽤 적다
        // 완전탐색일 수도 있다.
        // 최대 91개의 경우의 수
        // 단순히 할인의 갯수가 많이 되는 순서로 살 수는 없는 노릇이다.

        // 할인의 총 합이 큰 순서로? 그렇지만 할인이 커도 할인의 대상이 이미 가격이 1일 수도 있다.
        // 가장 저렴한 순서로 산다?
        // 가장 저렴한 순서로 사보자

        // 우선 순위큐를 유지할 수 있나?


        // 그냥 부르트 포스?

        backtracking(0, 0);

        System.out.println(answer);

    }

    private static void backtracking(int n, int sum) {
        if (n == N) {
            answer = Math.min(answer , sum);
        } else {

            for (int i = 1; i <= N; i++) {
                if (selected[i]) continue;
                if (answer <= sum + potions[i].cost) continue;

                for (Sale s : sale[i]) {
                    potions[s.idx].minus(s.cost);
                }

                selected[i] = true;
                backtracking(n + 1, sum + potions[i].cost);
                selected[i] = false;

                for (Sale s : sale[i]) {
                    potions[s.idx].plus(s.cost);
                }
            }

        }

    }

    static int getCost(int cost, int weight) {
        if (cost - weight <= 0) return 1;
        return cost - weight;
    }

    private static void input() throws IOException {
        InputReader r = new InputReader("C:\\Users\\workspace\\boj\\src\\test\\java\\쇼미더코드\\물약구매\\input.txt");

        // 4 N
        // 10 15 20 25 cost
        // 2 sale
        // 3 10 3사면 10

        N = r.nextInt();
        potions = new Potion[N + 1];
        for (int i = 1; i <= N; i++) {
            Potion potion = new Potion(i, r.nextInt());
            potions[i] = potion;
        }

        sale = new List[N + 1];
        for (int i = 1; i <= N; i++) {
            sale[i] = new ArrayList<>();
            int out = r.nextInt();
            potions[i].setOut(out);
            for (int j = 0; j < out; j++) {
                sale[i].add(new Sale(r.nextInt(), r.nextInt()));
            }
        }

        selected = new boolean[N + 1];
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
