package 그렙;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

import org.junit.jupiter.api.Test;

public class 프로그래밍1 {
    @Test
    public void 예제() {
        new Solution().solution(
            new String[] {
                "kim password", "lee abc"
            },

            new String[] {
                "ADD 30",
                "LOGIN kim abc",
                "LOGIN lee password",
                "LOGIN kim password",
                "LOGIN kim password",
                "LOGIN lee abc",
                "ADD 30",
                "ORDER",
                "ORDER",
                "ADD 40",
                "ADD 50"
            });
    }

    private class Solution {
        public boolean[] solution(String[] infos, String[] actions) {

            Map<String, String> users = new HashMap<>();
            for (String user : infos) {
                StringTokenizer st = new StringTokenizer(user);
                users.put(st.nextToken(), st.nextToken());
            }

            List<Boolean> answer = new ArrayList<>();
            boolean needLogin = true;
            boolean isAdded = false;
            for (String action : actions) {
                StringTokenizer st = new StringTokenizer(action);

                String act = st.nextToken();
                if ("LOGIN".equals(act)) {
                    String id = st.nextToken();
                    String password = st.nextToken();
                    if (needLogin && users.getOrDefault(id, "").equals(password)) {
                        needLogin = false;
                        answer.add(true);
                    } else {
                        answer.add(false);
                    }
                }
                else if ("ADD".equals(act)) {
                    if (needLogin) {
                        answer.add(false);
                    } else {
                        answer.add(true);
                        isAdded = true;
                    }
                }
                else if ("ORDER".equals(act)) {
                    if (isAdded) {
                        isAdded = false;
                        answer.add(true);
                    } else {
                        answer.add(false);
                    }
                }

            }

            boolean[] arrAnswer = new boolean[answer.size()];
            for (int i = 0; i < answer.size(); i++) {
                arrAnswer[i] = answer.get(i);
            }
            return arrAnswer;
        }
    }
}
