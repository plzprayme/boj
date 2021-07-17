package 네번째점_3009;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

public class 네번째점Test {
    @Test
    public void 예제() {
        // int[] x = new int[]{5,5,7};
        // int[] y = new int[]{5,7,5};

        int[] x = new int[]{30,10,10};
        int[] y = new int[]{20,10,20};

        Arrays.sort(x);
        Arrays.sort(y);

        int[] xy = new int[2];
        xy[0] = lastPosition(x);
        xy[1] = lastPosition(x);
        System.out.printf("%d %d", xy[0], xy[1]);

    }

    private int lastPosition(int[] x) {
        return x[0] == x[1] ? x[2] : x[0];
    }
}
