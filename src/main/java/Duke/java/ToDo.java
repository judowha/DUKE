package Duke.java;

public class ToDo extends tasks {
    private static final int CommandLength=5;

    public ToDo() {
        this.task="";
        this.done=false;

    }

    public ToDo(String task){
        this.task="  [T][\u2718] "+task.substring(CommandLength);
    }

    public void showAddInformation(){
        System.out.println("Got it. I have add this task: ");
        displayTasks();
        System.out.println("Now you have "+taskNum+" tasks in the list.");
    }
    @Override
    public void setDone() {
        super.setDone();
        this.task="  [T][\u2713] "+task.substring(9);
    }


    public  void displayTasks() {
        System.out.println(this.task);
    }


}
