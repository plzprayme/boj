package 코딜리티;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.Test;

public class 트레이닝2_1 {
    @Test
    public void main() {
    }

    class Solution {
        public int solution(int[] A) {
            Map<Integer, Integer> map = new HashMap<>();
            for (int i : A) {
                map.put(i, map.getOrDefault(i, 0) + 1);
            }

            for (var s : map.entrySet()) {
                if (s.getValue() % 2 == 1)
                    return s.getKey();
            }
            return -1;
        }
    }
        
}
