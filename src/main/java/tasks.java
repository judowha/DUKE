public class tasks {
    private String task;
    private boolean done;
    private static int taskNum=0;

    public tasks(String task) {
        this.task = task;
        this.done=false;
    }


    public void setTask(String task) {
        this.task=task;
    }
    public void setDone(){
        this.done=true;
    }

    public String getTask() {
        return task;
    }

    public boolean isDone() {
        return done;
    }

    public static void setTaskNum(int taskNum) {
        tasks.taskNum = taskNum;
    }

    public static int getTaskNum() {
        return taskNum;
    }

    public void markAsDone(){
        if(done==true)
            System.out.println("[✓] "+task);
        else System.out.println("[✗] "+task);
    }
}
