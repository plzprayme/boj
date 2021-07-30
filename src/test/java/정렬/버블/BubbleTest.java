package 정렬.버블;

import java.util.Random;

import org.junit.jupiter.api.Test;

import 정렬.RandomInteger;

public class BubbleTest {
    @Test
    public void 두개() {
        Bubble bubble = new Bubble(2,1);
        System.out.println(bubble);
        bubble.sort();
        System.out.println(bubble);
    }

    @Test
    public void 세개() {
        Bubble bubble = new Bubble(2,1, 4);
        System.out.println(bubble);
        bubble.sort();
        System.out.println(bubble);
    }

    @Test
    public void 백개() {
        Bubble bubble = new Bubble(new RandomInteger().get(100));
        System.out.println(bubble);
        bubble.sort();
        System.out.println(bubble);
    }
}
