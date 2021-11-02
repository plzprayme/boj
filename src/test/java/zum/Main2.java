package zum;

import java.io.*;
import java.util.*;

import org.junit.jupiter.api.Test;

class Main2 {

    private static int[] solution(int[][] data) {
        int[] answer = new int[data.length];

        int currentJobId = -1;
        long currentTime = 0;
        int remainTime = 0;
        Stack<Job> processingJob = new Stack<>();

        int answerIndex = 0;
        int nextJobIndex = 0;
        PriorityQueue<Job> waitingJob = new PriorityQueue<>();
        while (true) {
            if (answerIndex >= data.length) break;

            int nextId = 0;
            int nextRequestTime = 0;
            int nextPages = 0;

            if (nextJobIndex < data.length) {
                nextId = data[nextJobIndex][0];
                nextRequestTime = data[nextJobIndex][1];
                nextPages = data[nextJobIndex][2];
            }

            Job nextJob = new Job(nextId, nextRequestTime, nextPages);

            // 다음 작업이 시작할 시간인데 지금 실행중인 작업이 있을 때
            if (currentTime == nextRequestTime && !processingJob.isEmpty()) {
                waitingJob.add(nextJob);
                nextJobIndex++;
            }

            // 진행 중인 작업이 있다.
            if (remainTime == 0 && !processingJob.isEmpty()) {
                Job a = processingJob.pop();
                answer[answerIndex++] = a.id;

            }

            // 진행 중인 작업도 없고 대기중인 작업도 없다 -> 바로 시작한다.
            if (processingJob.isEmpty() && waitingJob.isEmpty()) {
                processingJob.add(nextJob);
                currentJobId = nextId;
                currentTime = nextRequestTime;
                remainTime = nextPages;
                nextJobIndex++;
            }

            // 진행 중인 작업은 없는데 대기 중인 작업은 있다. -> 대기 큐에서 꺼낸다.
            if (processingJob.isEmpty() && !waitingJob.isEmpty()) {
                Job a = waitingJob.poll();
                processingJob.add(a);
                remainTime = a.pages;
                currentJobId = a.id;
            }

            currentTime++;
            remainTime--;
        }

        return answer;
    }

    private static class Printer {
        Job processing;


    }

    private static class Job implements Comparable<Job> {
        Integer id, createdAt, pages;

        public Job(int id, int createdAt, int pages) {
            this.id = id;
            this.createdAt = createdAt;
            this.pages = pages;
        }

        @Override
        public int compareTo(Job o) {
            if (pages.equals(o.pages)) {
                return createdAt.compareTo(o.createdAt);
            }

            return pages.compareTo(o.pages);
        }
    }

    private static void input() throws IOException {
    }

    @Test
    public static void main(String[] args) throws IOException {
        input();

        System.out.println(
            Arrays.toString(
                solution(
                    new int[][] {
                        {1, 0, 5},
                        {2, 2, 2},
                        {3, 3, 1},
                        {4, 4, 1},
                        {5, 10, 2},
                    }
                )
            )
        );

        System.out.println(
            Arrays.toString(
                solution(
                    new int[][] {
                        {1, 0, 3},
                        {2, 1, 3},
                        {3, 3, 2},
                        {4, 9, 1},
                        {5, 10, 2},
                    }
                )
            )
        );

        System.out.println(
            Arrays.toString(
                solution(
                    new int[][] {
                        {1, 2, 10},
                        {2, 5, 8},
                        {3, 6, 9},
                        {4, 20, 6},
                        {5, 25, 5},
                    }
                )
            )
        );

        System.out.println(
            Arrays.toString(
                solution(
                    new int[][] {
                        {1, 1, 1}
                    }
                )
            )
        );
    }

}

