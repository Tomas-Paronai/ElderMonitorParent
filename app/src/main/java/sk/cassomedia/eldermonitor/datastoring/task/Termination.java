package sk.cassomedia.eldermonitor.datastoring.task;

/**
 * Created by tomas on 11/28/2015.
 */
public class Termination {
    private int day;
    private int month;
    private int year;
    private int hour;
    private int minutes;

    public Termination(int day, int month, int year, int hour, int minutes){
        this.day = day;
        this.month = month;
        this.year = year;
        this.hour = hour;
        this.minutes = minutes;
    }

    public boolean shouldTerminate(){
        //to do
        return  false;
    }

    public int getDay(){
        return day;
    }

    public int getMonth(){
        return month;
    }

    public int getYear(){
        return year;
    }

    public int getHour(){
        return hour;
    }

    public int getMinutes(){
        return minutes;
    }
}
