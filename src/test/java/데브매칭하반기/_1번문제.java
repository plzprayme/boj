package 데브매칭하반기;

import org.junit.jupiter.api.Test;

public class _1번문제 {
    @Test
    public void main() {
        System.out.println(
            solution(
                new String[] {"cow", "cow1", "cow2", "cow3", "cow4", "cow9", "cow8", "cow7", "cow6", "cow5"},
                "cow"
            )
        );

        System.out.println(
            solution(
                new String[] {"bird99", "bird98", "bird101", "gotoxy"},
                "bird98"
            )
        );
    }

    public String solution(String[] registered_list, String new_id) {


        String str = "";
        String num = "";
        s: while (true) {
            if (in(registered_list, new_id)) {

                int tmp = -1;
                for (int i = 0; i < new_id.length(); i++) {
                    if (Character.isDigit(new_id.charAt(i))) tmp = i;
                }

                if (tmp == -1) {tmp = new_id.length(); new_id += "1"; continue s;}

                if (str.equals("")) for (int j = 0; j < tmp; j++) str += new_id.charAt(j);

                if (num.equals("")) {
                    for (int j = tmp; j < new_id.length(); j++) num += new_id.charAt(j);
                    num = String.valueOf(Integer.parseInt(num) + 1);
                }
                else num = String.valueOf(Integer.parseInt(num) + 1);

                new_id = str + num;
            }
            else return new_id;
        }

    }

    private boolean in(String[] registered_list, String new_id) {
        for (var rl : registered_list) if (new_id.equals(rl)) return true;
        return false;
    }

}
