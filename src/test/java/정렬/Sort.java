package 정렬;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public abstract class Sort {
    protected List<Integer> list;

    protected Sort(Integer... arr) {

        this.list = new ArrayList<>(Arrays.asList(arr));
    }

    public abstract void sort();

    protected void swap(int a, int b) {
        Collections.swap(list, a, b);
    }

    @Override
    public String toString() {
        return list.toString();
    }
}
