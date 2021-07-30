package 정렬.삽입;

import 정렬.Sort;

public class Insertion extends Sort {

    public Insertion(Integer... arr) {
        super(arr);
    }

    @Override
    public void sort() {
        for (int i = 1; i < list.size(); i++) {

            int minIndex = -1;
            for (int j = i - 1; j >= 0; j--) {
                if (list.get(j) < list.get(i))
                    continue;

                minIndex = j;
            }

            if (minIndex != -1) {
                list.add(minIndex, list.get(i));
                list.remove(i + 1);
            }
        }
    }

    private boolean isSmaller(int a, int b) {
        return list.get(a) < list.get(b);
    }
}
