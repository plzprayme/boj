import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {

        System.out.println(azcxc("a"));
        System.out.println(azcxc("b"));
        System.out.println(azcxc("acaa"));
        System.out.println(azcxc("acaaac"));
        System.out.println(azcxc("aaaaaa"));
        System.out.println(azcxc("") + " NULL ");
    }

    public static String azcxc(String input) {

        // "acaa"

        // 방법 1. 쓰리? 포인터
        // 시작 점을 기억하고 있는 포인터와 끝 점을 기억하고 있는 포인터
        // 두 점 사이의 거리가 개수

        // acaa
        // start = 0, end = 0, next = 1
        // end 와 next가 다르면 압축 가능
        // next가 길이를 초과할 수도 있다..
        // next가 필요 없을 수도 있다..

        StringBuilder sb = new StringBuilder();

        int N = input.length();
        int start = 0, end = 0;
        while (end < N) {
            int next = end + 1;

            // 다음 문자열이 없는 경우 (길이의 끝)
            if (next == N) {
                // 끝이 없으니까 압축 가능
                // 아래 로직을 함수화 할 수 있다.
                sb.append(zip(end - start + 1, input.charAt(start)));
                // 스타트 안바꿔도됨
                break;
            }

            // 다음 문자와 끝 문자열이 같은 경우 (전진할 수 있다.)
            if (input.charAt(end) == input.charAt(next)) {
                // 전진할 수 있다. end++
                end++;
            } else { // 전진을 할 수 없다.
                // 지금 까지의 거리를 압축한다.
                sb.append(zip(end - start + 1, input.charAt(start)));// 압축하고
                start = next;
                end = next;
            }
        }

        return sb.toString();
    }

    private static String zip(int i, char charAt) {
        StringBuilder sb = new StringBuilder();
        return sb.append(i).append(charAt).toString();
    }


}
