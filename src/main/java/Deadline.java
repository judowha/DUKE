public class Deadline extends tasks{
    private static final int CommandLength=9;
    public Deadline (String task){

        super(task.substring(CommandLength));
        System.out.println("Got it. I have add this task: ");
        displayTasks();
        System.out.println("Now you have "+taskNum+" tasks in the list.");
        System.out.println("");
    }


    public  void displayTasks(){
        System.out.print("  [D]");
        if(done==true)
            System.out.print("[✓] ");
        else System.out.print("[✗] ");
        String[] contain=new String[1];
        contain=task.split("/");
        System.out.println(contain[0]+"("+contain[1]+")");
    }


}
