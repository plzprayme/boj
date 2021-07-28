package 정렬.선택;

import org.junit.jupiter.api.Test;

import 정렬.RandomInteger;
import 정렬.Sort;

public class SelectionTest {
    @Test
    public void 두개() {
        Sort selection = new Selection(2, 1);
        System.out.println(selection);
        selection.sort();
        System.out.println(selection);
    }

    @Test
    public void 세개() {
        Sort selection = new Selection(3, 45, 1);
        System.out.println(selection);
        selection.sort();
        System.out.println(selection);
    }

    @Test
    public void 백개() {
        Sort selection = new Selection(new RandomInteger().get(100));
        System.out.println(selection);
        selection.sort();
        System.out.println(selection);
    }
}
