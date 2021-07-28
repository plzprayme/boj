package 정렬;

import java.util.Random;

public class RandomInteger {
    private Random random  = new Random();

    public Integer[] get(int size) {
        return random.ints(size, 0, 100)
            .boxed()
            .toArray(Integer[]::new);
    }
}
