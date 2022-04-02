package 쇼미더코드.물약구매;

import java.io.*;
import java.util.*;

import org.junit.jupiter.api.Test;

class Main {

    static int N;
    static Potion[] potions;
    static List<Sale>[] sale;
    static PriorityQueue<Potion> pq = new PriorityQueue<>();

    static class Potion implements Comparable<Potion> {
        int idx, cost, out;

        public Potion(int idx, int cost) {
            this.idx = idx;
            this.cost = cost;
        }

        public void setOut(int out) {
            this.out = out;
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

        int answer = 0;
        while (!pq.isEmpty()) {
            Potion p = pq.poll();
            answer += p.cost;

            for (Sale s : sale[p.idx]) {
                potions[s.idx].cost = getCost(potions[s.idx].cost, s.cost);
            }
        }

        System.out.println(answer);



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
            pq.add(potion);
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
