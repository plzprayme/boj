package 정렬;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public abstract class Sort {
    protected List<Integer> list;

    protected Sort(Integer... arr) {
        this.list = new ArrayList<>(Arrays.asList(arr));
    }

    protected Sort(int[] arr) {
        list = new ArrayList<>();
        for (int i : arr) {
            list.add(i);
        }
    }

    public abstract List<Integer> sort();

    protected void swap(int a, int b) {
        Collections.swap(list, a, b);
    }

    @Override
    public String toString() {
        return list.toString();
    }
}
