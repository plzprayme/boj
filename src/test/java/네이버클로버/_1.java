package 네이버클로버;

import org.junit.jupiter.api.Test;

public class _1 {

    public String solution(String S) {
        // write your code in Java SE 8

        int index = getIndex(S);
        return getAnswer(index, S);
    }

    private String getAnswer(int index, String S) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < S.length(); i++) {
            if (i == index) continue;
            sb.append(S.charAt(i));
        }
        return sb.toString();
    }

    private int getIndex(String S) {
        for (int i = 0; i < S.length() - 1; i++) {
            if (S.charAt(i) > S.charAt(i + 1)) return i;
        }
        return S.length() - 1;
    }

    @Test
    public void main() {
        System.out.println(solution("acb"));
        System.out.println(solution("hot"));
        System.out.println(solution("codility"));
    }
}
