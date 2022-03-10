package 강의실배정_11000;

import java.io.*;
import java.util.*;

import org.junit.jupiter.api.Test;

class Main {

    static int N;
    static PriorityQueue<Lecture> startTimeQueue = new PriorityQueue<>();

    static class Lecture implements Comparable<Lecture> {
        int start, end;

        public Lecture(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Lecture o) {
            return start - o.start;
        }
    }

    @Test
    public static void main(String[] args) throws IOException {
        input();
        solution();
    }

    private static void solution() {
        // Si에 시작해서 Ti에 끝나는 N개의 수업

        // 최소 강의실을 사용해서 모든 수업을 가능하게 하자.

        // 수업 끝난 직후 다음 수업 시작 가능

        // Ti <= Sj인 경우 i수업과 j 수업 동시 수강 가능

        // N = 200_000
        // 1_000_000_000

        // 최소의 강의실을 사용해서 모든 수업 가능!
        // 완전 나올만한것


        // 완전탐색
        // 시간을 1씩 증가시키며 강의실을 카운트한다.
        // 최악의 경우 시간을 10억번 증가시켜야한다. 당연히 안되잖아~



        // 시작 값 우선순위 큐(입력값) 과 종료 값 우선순위 큐를 운영한다.
        // log200_000 + (log200_000 + 1) / 2 하면.. 15...? 말이 되나?

        // 혹은 입력 값을 배열에 담은 후 sort하고 종료 시간은 우선순위 큐를 유지한다?
        // 입력의 연산이 200_000 log200_000 으로 증가함.. 일단 짜봐

        int answer = 0;
        PriorityQueue<Integer> endTimeQueue = new PriorityQueue<>();
        while (!startTimeQueue.isEmpty()) {
            Lecture lecture = startTimeQueue.poll();

            if (endTimeQueue.isEmpty()) {
                endTimeQueue.add(lecture.end);
                answer = Math.max(answer, endTimeQueue.size());
                continue;
            }


            int endTime = endTimeQueue.peek();

            // |-------|
            //           |----|
            // |---|
            //     |--|
            if (lecture.start >= endTime) {
                endTimeQueue.poll();
                continue;
            }

            // |-------|
            //   |---|
            if (lecture.end < endTime) {
                endTimeQueue.add(lecture.end);
                answer = Math.max(answer, endTimeQueue.size());
                continue;
            }

            // |-------|
            //      |-----|
            // |-------|
            //     |---|
            if (lecture.start < endTime && lecture.end >= endTime) {
                endTimeQueue.add(lecture.end);
                answer = Math.max(answer, endTimeQueue.size());
                continue;
            }


            //
            // 만약 시작 시간이 endTime 보다 작다 -> 강의실이 더 필요하다
//            int endTime = endTimeQueue.peek();
//            if (lecture.start < endTime) {
//                classRoom++;
//                answer = Math.max(answer, classRoom);
//
//                // lecture.end를 넣을까 말까?
//                // lecture.end가 endTime보다 작으면 넣지 말자.
//                if (lecture.end > endTime) {
//                    endTimeQueue.add(lecture.end);
//                }
//
//                continue;
//            }

//            1 5
//            1 3
//            4 5

            // classRoom 을 줄여야한다.
            // endTime 보다 lecture.start < endTime 이면 classRoom을
//            endTime은 변하지 않았는데
//            lectureEnd가 여러번 등장할 때..?

            // lecture.start > endTime  -> endTime을 다음으로 이동한다.
        }

        System.out.println(answer);
    }

    private static void input() throws IOException {
        InputReader r = new InputReader("C:\\Users\\workspace\\boj\\src\\test\\java\\강의실배정_11000\\input.txt");
        N = r.nextInt();

        for (int i = 0; i < N; i++) {
            startTimeQueue.add(new Lecture(r.nextInt(), r.nextInt()));
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
