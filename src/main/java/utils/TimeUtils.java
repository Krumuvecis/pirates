package utils;

import org.jetbrains.annotations.NotNull;

//
public class TimeUtils {
    //
    public static final int
            SECONDS_IN_MINUTE = 60,
            MINUTES_IN_HOUR = 60;

    //
    public static double getSecondsFromMillis(long millis) {
        return millis / 1000.0;
    }

    //
    public static int @NotNull [] getHMSFromSeconds(double seconds) {
        int
                secondsInHour = SECONDS_IN_MINUTE * MINUTES_IN_HOUR,
                totalWholeSeconds = (int) Math.floor(seconds),
                hours = Math.floorDiv(totalWholeSeconds, secondsInHour),
                hoursAsSeconds = hours * secondsInHour,
                remainderSecondsAfterHours = totalWholeSeconds - hoursAsSeconds,
                minutes = Math.floorDiv(remainderSecondsAfterHours, SECONDS_IN_MINUTE),
                minutesAsSeconds = minutes * SECONDS_IN_MINUTE,
                remainingSeconds = remainderSecondsAfterHours - minutesAsSeconds;
        return new int[] {
                hours,
                minutes,
                remainingSeconds
        };
    }
}