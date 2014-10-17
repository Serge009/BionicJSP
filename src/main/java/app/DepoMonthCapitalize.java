package app;

import java.util.*;

public class DepoMonthCapitalize extends DepoBase{
    private static final long serialVersionUID = 1L;

    public DepoMonthCapitalize(String bank, String depoId, Date startDate, int dayLong, double sum, double interestRate){
        super(bank, depoId, startDate, dayLong, sum, interestRate);
    }

    public DepoMonthCapitalize(Date startDate, int dayLong, double sum, double interestRate){
        super("", "", startDate, dayLong, sum, interestRate);
    }

    public DepoMonthCapitalize(){

    }

    @Override
    public double getInterest(){
        if (interest > 0.0) return interest;
        int dayN = 0;
        GregorianCalendar calendar = new GregorianCalendar();
        calendar.setTime(startDate);
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DAY_OF_MONTH) + 1;
        int daysInYear = getDaysInYear();
        double interest = 0.0;
        double capital = 0.0;
        int periodDay = 0;
        double dayCf = 0.0;
        while (true){
            calendar.set(Calendar.MONTH, month+1);
            month++;
            calendar.set(Calendar.DAY_OF_MONTH, 1);
            calendar.add(Calendar.DATE, -1);
            periodDay = calendar.get(Calendar.DAY_OF_MONTH) - day + 1;
            if ((dayN + periodDay) > dayLong) {
                break;
            }
            dayCf = periodDay;
            interest = (sum + capital) * (interestRate / 100.0) * (dayCf / daysInYear);
            capital += interest;
            day = 1;
            dayN += periodDay;
        }
        dayCf = dayLong - dayN;
        interest = (sum + capital) * (interestRate / 100.0) * (dayCf / daysInYear);
        capital += interest;
        return capital;
    }
}

