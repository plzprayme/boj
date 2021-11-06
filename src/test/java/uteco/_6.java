package uteco;

import org.junit.jupiter.api.Test;

public class _6 {
    @Test
    public void main() {
        solution(
            3.5
        );
    }

    private static final double MONDAY_START_WORK_TIME = 13.0;
    private static final double FRIDAY_END_WORK_TIME = 18.0;

    public String solution(double time) {
        String[][] plans = {
            // { "홍콩", "11PM", "9AM" },
            // { "엘에이", "3PM", "2PM" },
            {"안녕", "12AM", "12PM"},
        };

        String lastTravelNation = "";

        for (String[] plan : plans) {
            String nation = plan[0];
            double travelStartTime = convertStringTimeToDouble(plan[1]);
            double travelEndTime = convertStringTimeToDouble(plan[2]);
            time += calculateSpendTimeAtStartDay(travelStartTime);
            time += calculateSpendTimeAtEndDay(travelEndTime);

            if (canTravel(time)) {
                lastTravelNation = nation;
                continue;
            }

            break;
        }

        return lastTravelNation;
    }

    private boolean canTravel(double time) {
        return time >= 0.0;
    }

    private double convertStringTimeToDouble(String timeString) {
        double time = getTime(timeString);
        int weight = getTimeWeight(timeString);
        return time + weight;
    }

    private double calculateSpendTimeAtStartDay(double travelStartTime) {
        double spendTime = 0.0;

        double needTime = travelStartTime - FRIDAY_END_WORK_TIME;
        if (needTime < 0) {
            spendTime += needTime;
        }

        return spendTime;
    }

    private double calculateSpendTimeAtEndDay(double travelEndTime) {
        double spendTime = 0.0;

        double needTime = MONDAY_START_WORK_TIME - travelEndTime;
        if (needTime < 0) {
            spendTime += needTime;
        }

        return spendTime;
    }

    private double getTime(String timeString) {
        double time = 0;
        if (timeString.length() == 3) {
            time = timeString.charAt(0) - '0';
        }

        if (timeString.length() == 4) {
            StringBuilder sb = new StringBuilder();
            sb.append(timeString.charAt(0))
                .append(timeString.charAt(1));
            time = Integer.parseInt(sb.toString());
        }
        return time;
    }

    private int getTimeWeight(String timeString) {
        int weight = 0;

        if (timeString.length() == 3 && isPM(timeString, 1)) {
            weight = 12;
        }

        if (timeString.length() == 4 && isPM(timeString, 2) && !is12(timeString)) {
            weight = 12;
        }

        if (timeString.length() == 4 && isPM(timeString, 2) && !is12(timeString)) {
            weight = 12;
        }

        if (timeString.length() == 4 && isAM(timeString, 2) && is12(timeString)) {
            weight = 12;
        }

        return weight;
    }

    private boolean isPM(String time, int index) {
        return time.charAt(index) == 'P';
    }

    private boolean isAM(String time, int index) {
        return time.charAt(index) == 'A';
    }

    private boolean is12(String time) {
        return time.charAt(0) == '1' && time.charAt(1) == '2';
    }

}
