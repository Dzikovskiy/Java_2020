package by.training.task7;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class BirthdayDay {
    public static void main(String[] args) {

        //parse date from command line
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        Date date = null;
        try {
            date = dateFormat.parse(args[0]);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        Calendar birthDay = Calendar.getInstance();
        birthDay.setTime(date);

        System.out.println("Your day is number: " + birthDay.get(Calendar.DAY_OF_WEEK));

        //prints how old you are
        Calendar now = Calendar.getInstance();
        now.setTime(new Date());
        int yearsInBetween = now.get(Calendar.YEAR)
                - birthDay.get(Calendar.YEAR);
        System.out.println("You are " + yearsInBetween + " years old");

        //prints if you have birthday 
        if (now.get(Calendar.DAY_OF_MONTH) == birthDay.get(Calendar.DAY_OF_MONTH)
                && now.get(Calendar.MONTH) == birthDay.get(Calendar.MONTH)) {
            System.out.println("Your birthday is today !!!");
        }

    }
}
