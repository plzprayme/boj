import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {

        // int H = 6;
        // int W = 12;
        // int N = 10;

        // System.out.println(iterSolution(6, 12, 10));
        // System.out.println(solution(new String[] { String.valueOf(H), String.valueOf(W), String.valueOf(N) }));

        // BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        // BufferedWriter w = new BufferedWriter(new OutputStreamWriter(System.out));
        //
        // int iter = parse(r.readLine());
        // for (int i = 0; i < iter; i++) {
        //     String[] HWN = r.readLine().split(" ");
        //     w.write(solution(HWN));
        // }
        // w.flush();

        for (int H = 1; H < 99; H++) {
            for (int W = 1; W < 99; W++) {
                for (int N = 1; N < H * W; N++) {
                    String answer = solution(new String[] {String.valueOf(H), String.valueOf(W), String.valueOf(N)});
                    String iterAnswer = iterSolution(H, W, N);

                    if (!answer.equals(iterAnswer)) {
                        String.format("H: %d, W: %d, N: %d, ANSWER: %s, ITER_ANSWER: %s", H, W, N, answer, iterAnswer);
                    }

                }
            }
        }

    }

    private static String iterSolution(int H, int W, int N) {
        int floor = 1;
        int room = 0;

        int cnt = 0;
        do {
            cnt++;
            room++;

            if (room == H) {
                room = 0;
                floor++;
                continue;
            }
        } while (cnt < N);

        if (lessThanTen(room))
            return String.format("%d0%d", room, floor);
        return String.format("%d%d", room, floor);
    }

    private static String solution(String[] HWN) {
        int H = parse(HWN[0]);
        int N = parse(HWN[2]);

        int floor = N % H;
        int room = N / H;
        if (floor == 0) {
            return String.format("%d", (H * 100) + room);
        }
        return String.format("%d", (floor * 100) + (room + 1));
    }

    private static int parse(String s) {
        return Integer.parseInt(s);
    }

    private static int getFloor(int N, int H) {
        int floor = N % H;
        return floor == 0 ? H : floor;
    }

    private static boolean lessThanTen(int room) {
        return room < 10;
    }
}
