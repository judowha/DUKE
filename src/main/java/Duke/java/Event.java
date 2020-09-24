package Duke.java;

import oop.*;
import java.time.*;
import java.time.format.DateTimeFormatter;

public class Event  extends tasks{


    public Event(){
        this.task="";
        this.done=false;
    }

    public Event (String task) throws DukeException{
        String[] contain=Parser.parseEvent(task);
        this.date=Parser.parseEventDate(task);
        String[] time=Parser.parseEventTime(task);
        LocalTime startTime = LocalTime.parse(time[0]);
        LocalTime endTime = LocalTime.parse(time[1]);
        this.time= startTime;
        String newCommandContain=contain[0]+"(at "+date.format(DateTimeFormatter.ofPattern("MMM d yyyy"))+" "+ startTime +"-"+ endTime +")";
        this.task="  [E][\u2718] "+newCommandContain;
    }

    @Override
    public void setDone() {
        super.setDone();
        this.task="  [E][\u2713] " +task.substring(9);
    }

}
