package 정렬.선택;

import java.util.List;

import 정렬.Sort;

public class Selection extends Sort {
    public Selection(Integer... arr) {
        super(arr);
    }

    @Override
    public List<Integer> sort() {
        for (int i = 0; i < list.size() - 1; i++) {
            int min = Integer.MAX_VALUE;
            int minIndex = -1;
            for (int j = i+1; j < list.size(); j++) {
                int current = list.get(j);
                if (min > current) {
                    minIndex = j;
                    min = current;
                }
            }

            if (minIndex != -1 && list.get(i) > list.get(minIndex)) swap(i, minIndex);
        }
        return null;
    }


}
