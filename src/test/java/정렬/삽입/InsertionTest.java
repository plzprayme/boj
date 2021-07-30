package 정렬.삽입;

import org.junit.jupiter.api.Test;

import 정렬.Sort;

public class InsertionTest {
    @Test
    public void 두개() {
        Sort insertion = new Insertion(2, 1);
        System.out.println(insertion);
        insertion.sort();
        System.out.println(insertion);
    }

    @Test
    public void 다섯() {
        Sort insertion = new Insertion(2, 1, 12, 1, 3);
        System.out.println(insertion);
        insertion.sort();
        System.out.println(insertion);
    }
}
