package Duke.java;

import opp.DukeException;
import opp.Parser;

import java.time.format.DateTimeFormatter;

public class Deadline extends tasks{

    public Deadline(){
        this.task="";
        this.done=false;
    }

    public Deadline (String task) throws DukeException {
        String[] contain=Parser.parseDeadline(task);
        this.date = Parser.parseDeadlineDate(task);
        this.time = Parser.parseDeadlineTime(task);
        String commandContain=contain[0]+"(at "+date.format(DateTimeFormatter.ofPattern("MMM d yyyy"))+" "+time+")";
        this.task="  [D][\u2718] "+commandContain;
    }

    @Override
    public void setDone() {
        super.setDone();
        this.task="  [D][\u2713] " +task.substring(9);

    }

}
