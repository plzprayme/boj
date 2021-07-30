package 정렬.분할;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

import 정렬.RandomInteger;

public class MergeTest {
    @Test
    public void 분할() {
        List<Integer> list = new ArrayList<>();
        list.add(2); list.add(1);

        System.out.println(sort(list));
    }

    @Test
    public void 분할2() {
        List<Integer> list = new ArrayList<>();
        list.add(2); list.add(1); list.add(3);
        System.out.println(sort(list));
    }

    @Test
    public void 병합() {
        List<Integer> left = new ArrayList<>();
        left.add(1); left.add(2); left.add(3);

        List<Integer> right = new ArrayList<>();
        right.add(1); right.add(4); right.add(5);

        List<Integer> merged = merge(left, right);
        System.out.println(merged);
    }

    @Test
    public void 여러걔() {
        System.out.println(sort(Arrays.asList(new RandomInteger().get(100))));
    }

    private List<Integer> sort(List<Integer> arr) {
        List<Integer> left = split(arr.subList(0, arr.size() / 2));
        List<Integer> right = split(arr.subList(arr.size() / 2, arr.size()));
        return merge(left, right);
    }

    private List<Integer> split(List<Integer> arr) {
        if (arr.size() < 2) {
            return arr;
        }

        List<Integer> left = split(arr.subList(0, arr.size() / 2));
        List<Integer> right = split(arr.subList(arr.size() / 2, arr.size()));
        return merge(left, right);
    }


    private List<Integer> merge(List<Integer> left, List<Integer> right) {
        List<Integer> merged = new ArrayList<>();

        int lm = left.size();
        int rm = right.size();
        int l = 0;
        int r = 0;
        while (l <= lm && r <= rm) {

            if (l == lm) {
                merged.addAll(right.subList(r, rm));
                break;
            }

            if (r == rm) {
                merged.addAll(left.subList(l, lm));
                break;
            }

            int le = left.get(l);
            int re = right.get(r);

            if (le > re) {
                merged.add(re);
                ++r;
            } else {
                merged.add(le);
                ++l;
            }
        }

        return merged;
    }
}
