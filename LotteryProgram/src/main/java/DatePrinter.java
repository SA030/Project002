package main.java;

import java.util.Calendar;

/** yy~ss set **/
public class DatePrinter {
  public static void printDateTime(Calendar cal) {

    // YY.MM.DD.hh.mi.ss
    int yy = cal.get(Calendar.YEAR);
    int mm = cal.get(Calendar.MONTH) + 1;
    int dd = cal.get(Calendar.DAY_OF_MONTH);
    int hh = cal.get(Calendar.HOUR_OF_DAY);
    int mi = cal.get(Calendar.MINUTE);
    int ss = cal.get(Calendar.SECOND);
  }
}
