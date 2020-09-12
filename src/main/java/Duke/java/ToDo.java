package Duke.java;

public class ToDo extends tasks {
    private static final int CommandLength=5;
    public ToDo(String task){
        this.task="  [T][\u2718] "+task.substring(CommandLength);
        System.out.println("Got it. I've added this task:");
        displayTasks();
        System.out.println("Now you have "+taskNum+" tasks in the list.");
    }

    @Override
    public void setDone() {
        super.setDone();
        this.task="  [T][\u2713] "+task.substring(9);
        System.out.println("Nice! I've marked this task as done: ");
        displayTasks();
    }

    public  void displayTasks() {
        System.out.println(this.task);
    }


}
