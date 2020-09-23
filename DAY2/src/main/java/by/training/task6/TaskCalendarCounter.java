package by.training.task6;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Period;
import java.util.Calendar;
import java.util.Date;

public class TaskCalendarCounter {
    private static final DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");

    public static void main(String[] args) {

        Date currentDate = new Date();

        //convert date to calendar
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(currentDate);
        calendar.add(Calendar.DATE, Integer.parseInt(args[1]));

        //convert calendar to date
        Date currentDatePlusTime = calendar.getTime();

        System.out.println(args[0]+" "+dateFormat.format(currentDatePlusTime));

    }
}
