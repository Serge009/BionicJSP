package app;

import java.text.SimpleDateFormat;
import java.util.*;
import java.io.*;

public abstract class DepoBase  implements Comparable<DepoBase>, Serializable{
    private static final long serialVersionUID = 1L;
    protected String bank;
    protected String depoId;
    protected Date startDate;
    protected int dayLong;
    protected double sum;
    protected double interestRate;
    protected double interest;

    public DepoBase() {
        this.interest = -1.0;
    }

    public DepoBase(String bank, String depoId, Date startDate, int dayLong, double sum, double interestRate){
        this.bank = bank;
        this.depoId = depoId;
        this.startDate = startDate;
        this.dayLong = dayLong;
        this.sum = sum;
        this.interestRate = interestRate;
        this.interest = -1.0;
    }

    public String getBank(){
        return bank;
    }
    public void setBank(String value){
        bank = value;
    }

    public String getDepoId(){
        return depoId;
    }
    public void setDepoId(String value){
        depoId = value;
    }

    public Date getStartDate(){
        return startDate;
    }
    public void setStartDate(Date value){
        startDate = value;
    }

    public int getDayLong(){
        return dayLong;
    }
    public void setDayLong(int value){
        dayLong = value;
    }

    public double getSum(){
        return sum;
    }
    public void setSum(double value){
        sum = value;
    }

    public double getInterestRate(){
        return interestRate;
    }
    public void setInterestRate(double value){
        interestRate = value;
    }

    public abstract double getInterest();

    protected int getDaysInYear(){
        GregorianCalendar calendar = new GregorianCalendar();
        calendar.setTime(startDate);
        GregorianCalendar yearEnd = new GregorianCalendar(calendar.get(Calendar.YEAR), Calendar.DECEMBER, 31);
        int ret = yearEnd.get(Calendar.DAY_OF_YEAR) - calendar.get(Calendar.DAY_OF_YEAR);
        calendar.add(GregorianCalendar.YEAR, 1);
        ret += calendar.get(Calendar.DAY_OF_YEAR);
        return ret;
    }

    public int compareTo(DepoBase depo) {
        if ((this.getInterest() - depo.getInterest()) > 0) return 1;
        if ((this.getInterest() - depo.getInterest()) < 0) return -1;
        return 0;
    }

    public String getDataForWeb(){
        SimpleDateFormat dtFrm = new SimpleDateFormat("dd.MM.yyyy");
        String ret = "<tr><td>";
        ret += dtFrm.format(startDate) +"</td>";
        ret += "<td>" + dayLong + "</td><td>" + sum + "</td><td>" + interestRate + "<td></tr>";
        return ret;
    }
}
