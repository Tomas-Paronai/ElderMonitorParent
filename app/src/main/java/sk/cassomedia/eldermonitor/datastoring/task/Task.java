package sk.cassomedia.eldermonitor.datastoring.task;

import java.util.ArrayList;

/**
 * Created by tomas on 11/28/2015.
 */
public class Task {
    private int category;
    private ArrayList<Integer> days;
    private ArrayList<AlertTime> time;
    private Termination term;


    public Task(int category){
        this.category = category;
    }

    public int getCategory(){
        return category;
    }

    public void addDay(int day){
        days.add(day);
    }

    public ArrayList<Integer> getDays(){
        return days;
    }

    public void addAlertTime(AlertTime alertTime){
        time.add(alertTime);
    }

    public ArrayList<AlertTime> getTimes(){
        return time;
    }

    public void addTermination(Termination term){
        this.term = term;
    }

    public Termination getTermination(){
        return term;
    }
}
