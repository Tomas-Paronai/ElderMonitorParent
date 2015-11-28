package sk.cassomedia.eldermonitor.datastoring.task;

/**
 * Created by tomas on 11/28/2015.
 */
public class AlertTime {
    private int hour;
    private int minutes;

    public AlertTime(int hour, int minutes){
        this.hour = hour;
        this.minutes = minutes;
    }

    public int getHour(){
        return hour;
    }

    public int getMinutes(){
        return minutes;
    }
}
