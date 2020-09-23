package Duke.java;

import java.time.LocalDate;
import java.time.LocalTime;

public  class tasks {
    protected String task;
    protected boolean done;
    protected static int taskNum=0;
    protected LocalTime time;
    protected LocalDate date;

    public tasks() {
        this.done=false;
        taskNum++;
    }

    public LocalTime getTime() {
        return time;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setTask(String task) {
        this.task=task;
    }

    public static void setTaskNum(int taskNum) {
        tasks.taskNum = taskNum;
    }

    public void setDone(){
        this.done=true;
    }

    public String getTask() {
        return task;
    }

    public static int getTaskNum() {
        return taskNum;
    }

    public boolean isDone() {
        return done;
    }

    public void displayTask(){
        System.out.println(this.task);
    }

}
