package Duke.java;

import oop.Parser;

public class ToDo extends tasks {


    public ToDo() {
        taskNum++;
        this.task="";
        this.done=false;
    }

    public ToDo(String task){
        this.task="  [T][NOTDone] "+ Parser.parseToDO(task);
        this.done=false;
        taskNum++;
    }

    static final int indicatorLength=14;
    @Override
    public void setDone() {
        this.task="  [T][Done] "+task.substring(indicatorLength);
        super.setDone();
    }
}
