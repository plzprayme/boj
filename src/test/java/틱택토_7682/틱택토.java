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

            int countX = 0;
            int countO = 0;
            for (char c : line) {
                if (c == 'X')
                    countX++;
                else if (c == 'O')
                    countO++;
            }

            if ((countX == countO) ||
                (countX == 5 && countO == 4) ||
                (countX == 3 && countO == 4) ||
                (countX == 3 && countO == 2) ||
                (countX == 1 && countO == 2) ||
                (countX == 1 && countO == 0)
            ) {

                int bingoX = 0;
                int bingoO = 0;
                for (int i = 0; i < 9; i = i + 3) {
                    if (line[i] == line[i + 1] && line[i + 1] == line[i + 2]) {
                        if (line[i] == 'X') {
                            bingoX++;
                        } else if (line[i] == 'O') {
                            bingoO++;
                        }
                    }
                }

                for (int i = 0; i < 3; i++) {
                    if (line[i] == line[i+3] && line[i+3] == line[i+6]) {
                        if (line[i] == 'X') {
                            bingoX++;
                        } else if (line[i] == 'O') {
                            bingoO++;
                        }
                    }
                }

                if (line[0] == line[4] && line[4] == line[8]) {
                    if (line[0] == 'X') {
                        bingoX++;
                    } else if (line[0] == 'O') {
                        bingoO++;
                    }
                }

                if (line[2] == line[4] && line[4] == line[6]) {
                    if (line[2] == 'X') {
                        bingoX++;
                    } else if (line[2] == 'O') {
                        bingoO++;
                    }
                }


                if (bingoO + bingoX >= 3) { // O빙고든 X빙고든 빙고가 세개 이상일 수는 없음
                    w.write("invalid");
                } else if (bingoO >= 1 && bingoX >= 1) { // O 빙고과 X 빙고가 공존할 수 없음
                    w.write("invalid");
                } else if (bingoO == 1 && ((countX == 5 && countO == 4) || (countX == 4 && countO == 4))) { // O 빙고가 있으면 총 7개 이하여야함
                    w.write("invalid");
                } else if (bingoO + bingoX == 0 && !(countX == 5 && countO == 4)) { // 빙고가 없으면 반드시 9개여야함
                    w.write("invalid");
                } else {
                    w.write("valid");
                }

            } else {
                w.write("invalid");
            }

            w.newLine();

        }
        w.flush();
    }
}
