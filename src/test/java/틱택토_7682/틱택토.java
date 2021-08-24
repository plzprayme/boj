package 틱택토_7682;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;

import org.junit.jupiter.api.Test;

public class 틱택토 {
    @Test
    public static void main(String[] args) throws IOException {
        BufferedReader r = new BufferedReader(
            new FileReader("C:\\Users\\prayme\\workspace\\boj\\src\\test\\java\\틱택토_7682\\input.txt"));
        BufferedWriter w = new BufferedWriter(new OutputStreamWriter(System.out));

        while (true) {
            char[] line = r.readLine().toCharArray();
            if (line[0] == 'e') break;

            // X, O 세기
            int countX = 0;
            int countO = 0;
            for (char c : line) {
                if (c == 'X')
                    countX++;
                else if (c == 'O')
                    countO++;
            }

            // 빙고 찾기
            int bingoX = 0;
            int bingoO = 0;
            // 가로
            for (int i = 0; i < 9; i = i + 3) {
                if (line[i] == line[i + 1] && line[i + 1] == line[i + 2]) {
                    if (line[i] == 'X') {
                        bingoX++;
                    } else if (line[i] == 'O') {
                        bingoO++;
                    }
                }
            }
            // 세로
            for (int i = 0; i < 3; i++) {
                if (line[i] == line[i+3] && line[i+3] == line[i+6]) {
                    if (line[i] == 'X') {
                        bingoX++;
                    } else if (line[i] == 'O') {
                        bingoO++;
                    }
                }
            }
            // 대각 \
            if (line[0] == line[4] && line[4] == line[8]) {
                if (line[0] == 'X') {
                    bingoX++;
                } else if (line[0] == 'O') {
                    bingoO++;
                }
            }
            // 대각 /
            if (line[2] == line[4] && line[4] == line[6]) {
                if (line[2] == 'X') {
                    bingoX++;
                } else if (line[2] == 'O') {
                    bingoO++;
                }
            }

            // O가 빙고면 안됨
            // X는 빙고가 0 , 1, 2 아무거나 상관 없음
            if (countX == 5 && countO == 4) {
                if (bingoO == 1) {
                    w.write("invalid");
                } else {
                    w.write("valid");
                }
            }
            // X와 O가 같을 때 중 가능한 경우는 각각 4와 3일 때 밖에 없음
            else if ((countX == 4 && countO == 4) || (countX == 3 && countO == 3)) {
                // O가 이겨야됨
                if (bingoO == 1 && bingoX == 0) {
                    w.write("valid");
                } else {
                    w.write("invalid");
                }
            }
            // 4 3 / 3 2 인 경우 밖에 없음
            else if ((countX == 4 && countO == 3) || (countX == 3 && countO == 2)) {
                // X가 이겨야됨
                if (bingoO == 0 && bingoX == 1) {
                    w.write("valid");
                } else {
                    w.write("invalid");
                }
            }
            // 그 외 O가 더 많거나, X만 왕창 있거나 빙고가 성립이 안됐는데 게임이 끝난 경우
            else {
                w.write("invalid");
            }

            w.newLine();

        }
        w.flush();
    }
}
