package Duke.java;

public class Deadline extends tasks{
    private static final int CommandLength=9;
    public Deadline (String task) {
        String[] contain;
        contain=(task.substring(CommandLength)).split("/");
        String commandContain=contain[0]+"("+contain[1]+")";
        this.task="  [D][\u2718] "+commandContain;

        System.out.println("Got it. I have add this task: ");
        displayTasks();
        System.out.println("Now you have "+taskNum+" tasks in the list.");

    }

    @Override
    public void setDone() {
        super.setDone();
        System.out.println("Nice! I've marked this task as done: ");
        this.task="  [D][\u2713] " +task.substring(9);
        displayTasks();
    }

    public  void displayTasks() {
        System.out.println(this.task);
    }


}
