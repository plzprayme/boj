import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        BufferedReader r = new BufferedReader(
            new FileReader("C:\\Users\\prayme\\workspace\\boj\\src\\test\\java\\FlyMeToTheAlphaCentauri\\input.txt"));
        BufferedWriter w = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = parse(r.readLine());
        for (int i = 0; i < N; i++) {
            String[] xy = r.readLine().split(" ");
            int x = parse(xy[0]);
            int y = parse(xy[1]);
            w.write(String.valueOf(getCount(y-x)));
            w.newLine();
        }
        w.flush();
    }

    private static int getCount(int position) {
        int max = (int) Math.sqrt(position);
        int square = max * max;

        if (max == Math.sqrt(position)) {
            return 2 * max - 1;
        }

        if (position <= square + max) {
            return 2 * max;
        }

        if (position <= square + max * 2) {
            return 2 * max + 1;
        }

        return -1;
    }

    private static int parse(String s) {
        return Integer.parseInt(s);
    }

    private static int distance(int step) {
        return step * (step + 1) / 2;
    }

}
