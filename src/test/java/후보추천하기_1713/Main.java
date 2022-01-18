package 후보추천하기_1713;

import java.io.*;
import java.util.*;

import org.junit.jupiter.api.Test;

class Main {

    static int N, M;
    static List<Student> list;

    static int[] num;

    @Test
    public static void main(String[] args) throws IOException {
        input();
        for (int i : num) {
            solution(i);
        }
        printAnswer();
    }

    private static void printAnswer() {
        list.sort(Comparator.comparingInt(Student::getIdx));

        StringBuilder sb = new StringBuilder();
        for (Student s : list) {
            sb.append(s.idx).append(' ');
        }
        System.out.println(sb);
    }

    private static void solution(int n) {
        if (list.contains(new Student(n))) {

            for (Student s : list) {
                if (s.idx == n) {
                    s.cnt++;
                }
            }
        } else {
            if (list.size() == N) {
                list.remove(0);
            }
            list.add(new Student(n));
        }

        for (Student s : list) {
            s.age++;
        }

        Collections.sort(list);
    }

    private static class Student implements Comparable<Student> {
        int idx;
        int cnt;
        int age;

        public Integer getIdx() {
            return idx;
        }

        public Student(int idx) {
            this(idx, 1, 1);
        }

        public Student(int idx, int cnt, int age) {
            this.idx = idx;
            this.cnt = cnt;
            this.age = age;
        }

        @Override
        public int compareTo(Student o) {
            int c1 = Integer.compare(cnt, o.cnt);
            if (c1 == 0) return Integer.compare(o.age, age);
            return c1;
        }

        @Override
        public boolean equals(Object o) {
            return idx == ((Student) o).idx;
        }
    }

    private static void input() throws IOException {
        InputReader r = new InputReader("C:\\Users\\workspace\\boj\\src\\test\\java\\후보추천하기_1713\\input.txt");
        N = r.nextInt();
        M = r.nextInt();

        list = new ArrayList<>();

        num = new int[M];
        for (int i = 0; i < M; i++) {
            num[i] = r.nextInt();
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

