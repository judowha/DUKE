package Duke.java;

import oop.DukeException;
import oop.Parser;

import java.time.format.DateTimeFormatter;

public class Deadline extends tasks{

    public Deadline(){
        taskNum++;
        this.task="";
        this.done=false;
    }

    public Deadline (String task) throws DukeException {
        this.done=false;
        String[] contain=Parser.parseDeadline(task);
        this.date = Parser.parseDeadlineDate(task);
        this.time = Parser.parseDeadlineTime(task);
        String commandContain=contain[0]+"(at "+date.format(DateTimeFormatter.ofPattern("MMM d yyyy"))+" "+time+")";
        this.task="  [D][NOTDone] "+commandContain;
        taskNum++;
    }

    static final int indicatorLength=14;
    @Override
    public void setDone() {
        super.setDone();
        this.task="  [D][Done] " +task.substring(indicatorLength);

    }

}
