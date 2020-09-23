package Duke.java;

import opp.Parser;

public class ToDo extends tasks {

    public ToDo() {
        this.task="";
        this.done=false;
    }

    public ToDo(String task){
        this.task="  [T][\u2718] "+ Parser.parseToDO(task);
    }


    @Override
    public void setDone() {
        this.task="  [T][\u2713] "+task.substring(9);
        super.setDone();
    }




}
