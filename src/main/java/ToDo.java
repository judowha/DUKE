public class ToDo extends tasks{
    public ToDo(String task){

        super(task.substring(5));
        System.out.println("Got it. I've added this task:");
        displayTasks();
        System.out.println("Now you have "+taskNum+" tasks in the list.");
    }

    public  void displayTasks(){
        System.out.print("  [T]");
        super.displayTasks();
    }
}
