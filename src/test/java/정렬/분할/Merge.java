package 정렬.분할;

import java.util.ArrayList;
import java.util.List;

import 정렬.Sort;

public class Merge extends Sort {

    public Merge(int[] arr) {
        super(arr);
    }

    @Override
    public List<Integer> sort() {
        List<Integer> left = split(list.subList(0, list.size() / 2));
        List<Integer> right = split(list.subList(list.size() / 2, list.size()));
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
