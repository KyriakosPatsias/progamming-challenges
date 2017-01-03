package programming.challenegs.kata;


/*
Description:

Write a function, which takes a non-negative integer (seconds) as input and returns the time in a human-readable format (HH:MM:SS)

HH = hours, padded to 2 digits, range: 00 - 99
MM = minutes, padded to 2 digits, range: 00 - 59
SS = seconds, padded to 2 digits, range: 00 - 59
The maximum time never exceeds 359999 (99:59:59)
 */

public class HumanReadableTime {
    public static String makeReadable(int seconds) {
        if(seconds==0)
            return "00:00:00";

        StringBuilder humanReadable = new StringBuilder();

        int hours = seconds/3600;
        int remaining = seconds%3600;
        int minutes = remaining/60;
        int secondsRemaining = remaining%60;

        if(hours>=10)
            humanReadable.append(hours);
        else{
            humanReadable.append("0");
            humanReadable.append(hours);
        }
        humanReadable.append(":");

        if(minutes>=10)
            humanReadable.append(minutes);
        else{
            humanReadable.append("0");
            humanReadable.append(minutes);
        }
        humanReadable.append(":");

        if(secondsRemaining>=10)
            humanReadable.append(secondsRemaining);
        else{
            humanReadable.append("0");
            humanReadable.append(secondsRemaining);
        }

        return humanReadable.toString();
    }
}
