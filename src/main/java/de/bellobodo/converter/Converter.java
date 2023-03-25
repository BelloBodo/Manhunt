package de.bellobodo.converter;

public class Converter {

    public static String convertIntToTime(final int time) {

        String result;

        final int day = time / 86400;
        final int hour = (time - 86400 * day) / 3600;
        final int minute = (time - 3600 * hour - 86400 * day) / 60;
        final int second = time - 86400 * day - 3600 * hour - 60 * minute;

        if (day == 0) {
            if (hour == 0) {
                if (minute == 0) {
                    result = second + "s";
                    return result;
                }
                result = minute + "m " + second + "s";
                return result;
            }
            result = hour + "h " + minute + "m " + second + "s";
            return result;
        }
        result = day + "d " + hour + "h " + minute + "m " + second + "s";
        return result;
    }

    public static int convertTimeToInt(String time) {

        int result = 0;

        //Seconds s, Minutes m, Hours h, Days d
        String[] times = time.split(" ", 4);

        for (String string : times) {
            if (string.contains("s")) {
                string = string.replace("s", "");
                result = result + Integer.parseInt(string);
            }
            else if (string.contains("m")) {
                string = string.replace("m", "");
                result = result + (Integer.parseInt(string) * 60);
            }
            else if (string.contains("h")) {
                string = string.replace("h", "");
                result = result + (Integer.parseInt(string) * 3600);
            }
            else if (string.contains("d")) {
                string = string.replace("d", "");
                result = result + (Integer.parseInt(string) * 86400);
            }
            else {
                Integer.parseInt(string);
                result = result + Integer.parseInt(string);
            }
        }


        return result;
    }
}