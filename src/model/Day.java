package model;

import com.sun.istack.internal.NotNull;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class Day {
    private Date date;
    private String intitule;
    private String description;
    private String Word1EN;
    private String Word1FR;
    private String Word2EN;
    private String Word2FR;
    private String Word3EN;
    private String Word3FR;
    private String Word4EN;
    private String Word4FR;
    private String Word5EN;
    private String Word5FR;
    public Day(){
        days.add(this);
    }
    public Day(Date date, String intitule, String description){
        days.add(this);
        this.date = date;
        this.intitule = intitule;
        this.setDescription(description);
    }

    public Day(Date date, String intitule, String description, String word1EN, String word1FR, String word2EN, String word2FR, String word3EN, String word3FR, String word4EN, String word4FR, String word5EN, String word5FR) {
        this.date = date;
        this.intitule = intitule;
        this.setDescription(description);
        this.Word1EN = word1EN;
        this.Word1FR = word1FR;
        this.Word2EN = word2EN;
        this.Word2FR = word2FR;
        this.Word3EN = word3EN;
        this.Word3FR = word3FR;
        this.Word4EN = word4EN;
        this.Word4FR = word4FR;
        this.Word5EN = word5EN;
        this.Word5FR = word5FR;
        days.add(this);
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getIntitule() {
        return intitule;
    }

    public void setIntitule(String intitule) {
        this.intitule = intitule;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        String[] descr = description.split("ESC");
        this.description = "";
        for (String s : descr) {
            this.description+=s;
            this.description += "\n\n";
        }
    }

    public String getWord1EN() {
        return Word1EN;
    }

    public void setWord1EN(String word1EN) {
        Word1EN = word1EN;
    }

    public String getWord1FR() {
        return Word1FR;
    }

    public void setWord1FR(String word1FR) {
        Word1FR = word1FR;
    }

    public String getWord2EN() {
        return Word2EN;
    }

    public void setWord2EN(String word2EN) {
        Word2EN = word2EN;
    }

    public String getWord2FR() {
        return Word2FR;
    }

    public void setWord2FR(String word2FR) {
        Word2FR = word2FR;
    }

    public String getWord3EN() {
        return Word3EN;
    }

    public void setWord3EN(String word3EN) {
        Word3EN = word3EN;
    }

    public String getWord3FR() {
        return Word3FR;
    }

    public void setWord3FR(String word3FR) {
        Word3FR = word3FR;
    }

    public String getWord4EN() {
        return Word4EN;
    }

    public void setWord4EN(String word4EN) {
        Word4EN = word4EN;
    }

    public String getWord4FR() {
        return Word4FR;
    }

    public void setWord4FR(String word4FR) {
        Word4FR = word4FR;
    }

    public String getWord5EN() {
        return Word5EN;
    }

    public void setWord5EN(String word5EN) {
        Word5EN = word5EN;
    }

    public String getWord5FR() {
        return Word5FR;
    }

    public void setWord5FR(String word5FR) {
        Word5FR = word5FR;
    }

    public String getImageName(){
        return "resources/"+this.getMonthNumber()+"_"+this.getDayMonthNumber()+".jpg";
    }

    public String getMonthNumber(){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(this.date);
        int monthNumber = calendar.get(Calendar.MONTH)+1; //Janvier = 01 chez nous or on obtient Janvier = 0
        if (monthNumber<10){
            return "0"+monthNumber;
        } else {
            return ""+monthNumber;
        }
    }

    public String getDayMonthNumber(){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(this.date);
        int dayMonthNumber = calendar.get(Calendar.DAY_OF_MONTH);
        if (dayMonthNumber<10){
            return "0"+dayMonthNumber;
        } else {
            return ""+dayMonthNumber;
        }
    }

    public Day getNextDay(){
        LocalDateTime localDateTime = this.date.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
        localDateTime = localDateTime.plusDays(1);
        Date nextDate = Date.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant());
        return Day.getDay(nextDate);
    }

    public Day getPreviousDay(){
        LocalDateTime localDateTime = this.date.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
        localDateTime = localDateTime.plusDays(-1);
        Date nextDate = Date.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant());
        return Day.getDay(nextDate);
    }

    private static ArrayList<Day> days = new ArrayList<>();

    public static Day getDay(Date date){
        for (Day day : days){
            Calendar calendarDate = Calendar.getInstance();
            calendarDate.setTime(date);
            Calendar calendarDay = Calendar.getInstance();
            calendarDay.setTime(day.getDate());
            if (calendarDate.get(Calendar.DAY_OF_MONTH) == calendarDay.get(Calendar.DAY_OF_MONTH) && calendarDate.get(Calendar.MONTH)==calendarDay.get(Calendar.MONTH)) {
                day.setDate(date);
                return day;
            }
        }
        Day dayToRemove = new Day();
        days.remove(dayToRemove);
        return dayToRemove;
    }

    @Override
    public String toString(){
        if (Day.days.contains(this)) {
            return this.date + "\n" + this.description + "\n"+ this.intitule;
        } else {
            return "Pas instancié";
        }

    }

}
