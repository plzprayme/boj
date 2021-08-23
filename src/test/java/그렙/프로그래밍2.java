package 그렙;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

import org.junit.jupiter.api.Test;

public class 프로그래밍2 {
    @Test
    public void 예제() {
        new Solution().solution(
            new String[] {
                "DS7651 A0", "CA0055 D+", "AI5543 C0", "OS1808 B-", "DS7651 B+", "AI0001 F", "DB0001 B-",
                "AI5543 D+", "DS7651 A+", "OS1808 B-"
            }
        );
    }

    private static class Solution {
        public String[] solution(String[] grades) {
            Map<String, String> map = new LinkedHashMap<>();
            List<String> g = new ArrayList<>(
                Arrays.asList("A+",
                    "A0",
                    "A-",
                    "B+",
                    "B0",
                    "B-",
                    "C+",
                    "C0",
                    "C-",
                    "D+",
                    "D0",
                    "D-",
                    "F")
            );

            for (String grade : grades) {
                StringTokenizer st = new StringTokenizer(grade);
                String id = st.nextToken();
                String gg = st.nextToken();

                String score = map.getOrDefault(id, "NON");
                if (score.equals("NON") || g.indexOf(score) > g.indexOf(gg)) {
                    map.put(id, gg);
                }
            }

            System.out.println(map);
            String[] answer = {};

            return answer;
        }
    }

    private static class Subject implements Comparable<Subject> {

        @Override
        public int compareTo(Subject o) {
            return 0;
        }
    }
}
