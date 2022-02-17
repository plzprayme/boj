package indexedtree;

import org.junit.jupiter.api.Test;

public class Main {

    static int[][] sum;
    static int[] arr;

    @Test
    void main() {
        arr = new int[9];
        sum = new int[9][9];
    }

    void init(int left, int right, int node) {
        if (left == right) { // 리프노드일 떄
            // 값 할당
            sum[left][left] = node;
            arr[left] = node;
            return;
        }

        int mid = (left + right) / 2;
        init(left, mid, node * 2);
        init(mid + 1, right, node * 2 + 1);

    }
}
