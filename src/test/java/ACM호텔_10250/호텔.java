package ACM호텔_10250;

import org.junit.jupiter.api.Test;

public class 호텔 {
    @Test
    public void 예제() {
        int H = 6;
        int W = 12;
        int N = 10;

        System.out.println(H - H % N + " " + (H / N) * H);
    }
}
