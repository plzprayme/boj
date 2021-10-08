package 듣보잡_1764;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

import org.junit.jupiter.api.Test;

public class 듣보잡 {
    static List<String> dbj = new ArrayList<>();

    @Test
    public static void main(String[] args) throws IOException {
        BufferedReader r = new BufferedReader(new FileReader("C:\\Users\\prayme\\workspace\\boj\\src\\test\\java\\듣보잡_1764\\input.txt"));

        StringTokenizer st = new StringTokenizer(r.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        String[] everHear = new String[N];
        for (int i = 0; i < N; i++) everHear[i] = r.readLine();
        String[] everSeen = new String[M];
        for (int i = 0; i < M; i++) everSeen[i] = r.readLine();
        Arrays.sort(everSeen);

        for (var a : everHear) bSearch(everSeen, 0, M - 1, a);

        StringBuilder sb = new StringBuilder();
        sb.append(dbj.size()).append('\n');
        dbj.stream().sorted().forEach(e -> sb.append(e).append('\n'));
        System.out.println(sb);
    }

    static void bSearch(String[] A, int L, int R, String X) {
        while (L <= R) {
            int M = L + (R - L) / 2;
            int flag = A[M].compareTo(X);
            if (flag < 0) L = M + 1;
            else if (flag > 0) R = M - 1;
            else { dbj.add(X); return; }
        }
    }

}
