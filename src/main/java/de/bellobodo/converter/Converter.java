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
}
