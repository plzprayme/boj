package 정렬.버블;

import java.util.List;

import 정렬.Sort;

public class Bubble extends Sort {

    public Bubble(Integer... arr) {
        super(arr);
    }

    @Override
    public List<Integer> sort() {

        int size = list.size() - 1;
        for (int i = 0; i < size; i++) {

            boolean isSorted = true;
            for (int j = 0; j < size - i; j++) {
                if (isBigger(j, j + 1)) {
                    swap(j, j + 1);
                    isSorted = false;
                }
            }

            if (isSorted) break;
        }
        return null;
    }

    private boolean isBigger(int a, int b) {
        return list.get(a) > list.get(b);
    }
}
