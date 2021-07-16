package 걸그룹마스터준석이_16165;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.Test;

public class 걸그룹마스터준석이Test {

    private static final int GROUP = 0;
    private static final int MEMBER = 1;

    @Test
    public void 예제() throws Exception {
        BufferedReader r = new BufferedReader(new FileReader("C:\\Users\\prayme\\workspace\\boj\\src\\test\\java\\걸그룹마스터준석이_16165\\input.txt"));
        BufferedWriter w = new BufferedWriter(new OutputStreamWriter(System.out));

        Map<String, String[]> groupMember = new HashMap<>();
        Map<String, String> memberGroup = new HashMap<>();
        String[] nums = r.readLine().split(" ");
        int groups = parseInt(nums[0]);
        int problems = parseInt(nums[1]);
        for (int i = 0; i < groups; i++) {
            String group = r.readLine();

            int headCount = parseInt(r.readLine());
            String[] members = new String[headCount];
            for (int j = 0; j < headCount; j++) {
                String member = r.readLine();
                members[j] = member;
                memberGroup.put(member, group);
            }
            Arrays.sort(members);
            groupMember.put(group, members);
        }

        for (int i = 0; i < problems; i++) {
            String target = r.readLine();
            int type = parseInt(r.readLine());

            if (type == GROUP) {
                String[] members = groupMember.get(target);
                w.write(arrayToString(members));
            }

            if (type == MEMBER) {
                w.write(memberGroup.get(target));
                w.newLine();
            }
        }

        w.flush();
    }

    private String arrayToString(String[] strings) {
        StringBuilder sb = new StringBuilder();
        for (String s : strings) {
            sb.append(s);
            sb.append("\n");
        }
        return sb.toString();
    }

    private int parseInt(String s) {
        return Integer.parseInt(s);
    }
}
