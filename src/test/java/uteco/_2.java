package uteco;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

public class _2 {

    @Test
    public void main() {
        System.out.println(solution(
            new String[] {
                "08:30", "09:00", "14:00", "16:00", "16:01", "16:06", "16:07", "16:11"
            }
        ));

        System.out.println(solution(
            new String[] {
                "01:00", "08:00", "15:00", "15:04", "23:00", "23:59"
            }
        ));
    }

    private static final int START_TIMES_INDEX = 0;
    private static final int END_TIMES_INDEX = 1;

    private static final int CONVERT_TIME_INDEX = 0;
    private static final int CONVERT_MINUTE_INDEX = 1;

    public String solution(String[] log) {
        String[] startTimes = selectTimesFrom(log, START_TIMES_INDEX);
        String[] endTimes = selectTimesFrom(log, END_TIMES_INDEX);
        int studiedTime = calculateTimes(startTimes, endTimes);
        return convertIntegerTimeToString(studiedTime);
    }

    private String[] selectTimesFrom(String[] log, int startIndex) {
        String[] times = new String[log.length / 2];
        int timeIndex = 0;
        for (int logIndex = startIndex; logIndex < log.length; logIndex += 2) {
            times[timeIndex++] = log[logIndex];
        }
        return times;
    }

    private int calculateTimes(String[] startTimes, String[] endTimes) {
        int studiedTime = 0;
        for (int i = 0; i < startTimes.length; i++) {
            int endedTime = convertStringTimeToInteger(endTimes[i], CONVERT_TIME_INDEX);
            int startedTime = convertStringTimeToInteger(startTimes[i], CONVERT_TIME_INDEX);
            int endedMinute = convertStringTimeToInteger(endTimes[i], CONVERT_MINUTE_INDEX);
            int startedMinute = convertStringTimeToInteger(startTimes[i], CONVERT_MINUTE_INDEX);

            int calculatedTime = (endedTime - startedTime) * 60;
            calculatedTime += endedMinute - startedMinute;

            if (calculatedTime < 5) {
                calculatedTime = 0;
            }

            if (calculatedTime > 105) {
                calculatedTime = 105;
            }

            studiedTime += calculatedTime;
        }

        return studiedTime;
    }

    private int convertStringTimeToInteger(String stringTime, int index) {
        return Integer.parseInt(stringTime.split(":")[index]);
    }

    private String convertIntegerTimeToString(int integerTime) {
        StringBuilder sb = new StringBuilder();
        int time = integerTime / 60;
        int minute = integerTime % 60;

        if (time < 10) {
            sb.append('0');
        }
        sb.append(time);

        sb.append(':');

        if (minute < 10) {
            sb.append('0');
        }
        sb.append(minute);

        return sb.toString();
    }

}
