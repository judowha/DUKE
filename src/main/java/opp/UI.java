package opp;

import Duke.java.tasks;

public class UI {
    public static void dukeHelp(){
        System.out.println("Here are available functions and the corresponding format: "+System.lineSeparator());
        System.out.println("todo: record what should be done next");
        System.out.println("Format for todo: todo <things you want to record>");
        System.out.println("Example: todo read a book"+System.lineSeparator());

        System.out.println("Deadline: record a deadline");
        System.out.println("Format for deadline: deadline <things you want to record> /by <yyyy-mm-dd time>");
        System.out.println("Example: todo return the book /by 2020-10-1 18:00"+System.lineSeparator());

        System.out.println("event: record a event that will happen in a specific duration");
        System.out.println("Format for event: event <things you want to record> /at <yyyy-mm-dd startTime-endTime>");
        System.out.println("Example: event attend the group meeting /at 2020-10-01 18:00-19:00"+System.lineSeparator());

        System.out.println("done: indicate that a task has been done");
        System.out.println("Format for done: done <taskNUmber>");
        System.out.println("Example: done 2"+System.lineSeparator());

        System.out.println("delete: delete a recorded task");
        System.out.println("Format for delete: delete <taskNUmber>");
        System.out.println("Example: delete 2"+System.lineSeparator());

        System.out.println("list: show all the task");
        System.out.println("Format for done: list");
        System.out.println("Example: list"+System.lineSeparator());
    }
    public static void showGreetings(){
        System.out.println("Hello! I'm Duke");
        System.out.println("What can I do for you?");
        System.out.println("if you need help, please enter 'help' to get instruction"+System.lineSeparator());
    }

    public static void showAddInformation(String task){
        System.out.println("Got it. I have add this task: ");
        System.out.println(task);
        System.out.println("Now you have "+ tasks.getTaskNum()+" tasks in the list."+System.lineSeparator());
    }

    public static void CheckEmptyDescription(String[] commands, String type) throws DukeException {
        if(commands.length<2){
            throw new DukeException("OOPS!!! The description of a "+type+" cannot be empty.");
        }
    }

    public static void CheckValidInputFormat(String line, String type) throws DukeException {
        if(!line.contains("/")){
            throw new DukeException("OOPS!!! Please indicate the time of the "+type+" by '/' ");
        }

    }

    public static void showSetDoneInformation(String task){
        System.out.println("Nice! I've marked this task as done: ");
        System.out.println(task+System.lineSeparator());
    }

    public static void NoneExistCommand() throws DukeException{
        throw new DukeException("OOPS!!! This command doesn't exist");
    }
    public static void sayBye(){
        System.out.println("Bye. Hope to see you again soon");
    }


}
