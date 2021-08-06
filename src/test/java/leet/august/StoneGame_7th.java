package leet.august;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Deque;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.jupiter.api.Test;

public class StoneGame_7th {

    @Test
    public void 예제1() {
        int[] given = new int[] {5, 3, 4, 5};
        boolean actual = new Solution().stoneGame(given);
        assertTrue(actual);
    }

    @Test
    public void 예제2() {
        int[] given = new int[] {5, 5, 5, 5};
        boolean actual = new Solution().stoneGame(given);
        assertFalse(actual);
    }

    @Test
    public void 예제3() {
        int[] given = new int[] {5, 4, 5, 5, 5, 5};
        boolean actual = new Solution().stoneGame(given);
        assertTrue(actual);
    }

    @Test
    public void 예제4() {
        int[] given = new int[] {3, 2, 10, 4};
        boolean actual = new Solution().stoneGame(given);
        assertTrue(actual);
    }

    private static class Solution {
        private Set<Boolean> results = new HashSet<>();

        public boolean stoneGame(int[] input) {
            Deque<Integer> piles = new ArrayDeque<>();
            for (int i : input) {
                piles.add(i);
            }

            int alex = 0;
            int lee = 0;
            while (!piles.isEmpty()) {
                alex += piles.getFirst() > piles.getLast() ? piles.pollFirst() : piles.pollLast();
                lee += piles.getFirst() > piles.getLast() ? piles.pollLast() : piles.pollFirst();
            }

            return alex > lee;

            // next(0, 0, piles);
            //
            // return results.contains(true);
        }

        private void next(int alex, int lee, Deque<Integer> piles) {
            if (piles.isEmpty()) {
                results.add(alex > lee);
                return;
            }

            Deque<Integer> ff = clone(piles);
            next(alex + ff.pollFirst(), lee + ff.pollFirst(), ff);

            Deque<Integer> fl = clone(piles);
            next(alex + fl.pollFirst(), lee + fl.pollLast(), fl);

            Deque<Integer> lf = clone(piles);
            next(alex + lf.pollLast(), lee +lf.pollFirst(), lf);

            Deque<Integer> ll = clone(piles);
            next(alex + ll.pollLast(), lee + ll.pollLast(), lf);
        }

        private Deque<Integer> clone(Deque<Integer> d) {
            return new ArrayDeque<>(d);
        }


    }
}
