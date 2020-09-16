package Duke.java;

public class tasks {
    protected String task;
    protected boolean done;
    protected static int taskNum=0;

    public tasks() {
        this.done=false;
        taskNum++;
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

    public void showAddInformation(){}

    public void showSetDoneInformation(){
        System.out.println("Nice! I've marked this task as done: ");
        displayTasks();
    }

    public void displayTasks() {}
}
