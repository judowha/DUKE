public class ToDo extends tasks{
    private static final int CommandLength=5;
    public ToDo(String task){

        super(task.substring(CommandLength));
        System.out.println("Got it. I've added this task:");
        displayTasks();
        System.out.println("Now you have "+taskNum+" tasks in the list.");
        System.out.println("");
    }

    public  void displayTasks(){
        System.out.print("  [T]");
        super.displayTasks();
    }
}
