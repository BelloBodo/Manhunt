package de.bellobodo.converter;

public class Converter {

    public static String convertIntToTime(int time) {

        String result;
        int day;
        int hour;
        int minute;
        int second;

        day = time / 86400;
        hour = (time - 86400 * day) / 3600;
        minute = (time - 3600 * hour - 86400 * day) / 60;
        second = time - 86400 * day - 3600 * hour - 60 * minute;

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
