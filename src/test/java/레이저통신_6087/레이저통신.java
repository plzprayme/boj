package 레이저통신_6087;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.Test;

public class 레이저통신 {
    private static char[][] map;
    private static int W;
    private static int H;
    // private static List<Integer> answer = new ArrayList<>();
    private static Set<Integer> answer = new HashSet<>();

    @Test
    public static void main(String[] args) throws IOException {
        BufferedReader r = new BufferedReader(new FileReader("C:\\Users\\prayme\\workspace\\boj\\src\\test\\java\\레이저통신_6087\\input.txt"));
        BufferedWriter w = new BufferedWriter(new OutputStreamWriter(System.out));


        // 입력
        String[] WH = r.readLine().split(" ");
        W = parse(WH[0]);
        H = parse(WH[1]);


        // 지도 입력
        int x = -2;
        int y = -2;
        map = new char[H][W];
        for (int i = 0; i < H; i++) {

            String row = r.readLine();

            // C의 위치 기억하기
            if (x == -2) {
                int index = row.indexOf('C');
                if (index != -1) {
                    x = index;
                    y = i;
                }
            }

            map[i] = row.toCharArray();
        }

        // C의 위치 , * 의 위치를 알아내야하나?
        // 기억해 놓기에는 너무 많다.
        // 기억해놓더라도 불필요한 연산(순회)가 발생한다.

        // 직접 순회하자

        left(x-1,y,0);
        right(x+1,y,0);
        up(x,y+1,0);
        down(x,y-1,0);

        System.out.println(answer);
    }

    private static void left(int x, int y, int count) {
        if (x == -1) return;

        char c = map[y][x];
        if (c == '*') return;

        if (c == 'C') {
            answer.add(count);
            return;
        }

        left(x-1, y, count);
        up(x, y+1, count+1);
        down(x, y-1, count+1);
    }

    private static void right(int x, int y, int count) {
        if (x == W) return;

        char c = map[y][x];
        if (c == '*') return;

        if (c == 'C') {
            answer.add(count);
            return;
        }

        right(x+1, y, count);
        up(x, y+1, count+1);
        down(x, y-1, count+1);
    }

    private static void up(int x, int y, int count) {
        if (y == H) return;

        char c = map[y][x];
        if (c == '*') return;

        if (c == 'C') {
            answer.add(count);
            return;
        }

        up(x, y+1, count);
        left(x-1, y, count+1);
        right(x+1, y, count+1);
    }

    private static void down(int x, int y, int count) {
        if (y == -1) return;

        char c = map[y][x];
        if (c == '*') return;

        if (c == 'C') {
            answer.add(count);
            return;
        }

        down(x, y -1, count);
        left(x-1, y, count+1);
        right(x+1, y, count+1);
    }

    // private static int horizontal() {
    //
    // }



    private static int parse(String s) {
        return Integer.parseInt(s);
    }



}
