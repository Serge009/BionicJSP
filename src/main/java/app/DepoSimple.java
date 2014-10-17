package app;

import java.util.Date;

public class DepoSimple extends DepoBase{
    private static final long serialVersionUID = 1L;

    public DepoSimple(String bank, String depoId, Date startDate, int dayLong, double sum, double interestRate){
        super(bank, depoId, startDate, dayLong, sum, interestRate);
    }

    public DepoSimple(Date startDate, int dayLong, double sum, double interestRate){
        super("", "", startDate, dayLong, sum, interestRate);
    }

    public DepoSimple(){

    }
    @Override
    public double getInterest(){
        if (interest > 0.0) return interest;
        int daysInYear = getDaysInYear();
        double dayCf = dayLong;
        interest = sum * (interestRate / 100.0) * (dayCf / daysInYear);
        return interest;
    }

}
