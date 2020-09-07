import java.util.Scanner;
import Duke.java.*;

public class Main {
    public static void main(String[] args) throws DukeException {

        showGreeting();
        storeInput();
        System.out.println("Bye. Hope to see you again soon");
    }

    private static void showGreeting() {
        System.out.println("Hello! I'm Duke");
        System.out.println("What can I do for you?");
        System.out.println("");
    }


    public static void storeInput() {
        String line;
        String[] commands=new String[100];
        tasks[] list=new tasks[100];
        tasks.setTaskNum(0);
        Scanner in=new Scanner(System.in);
        while(!(line= in.nextLine()).equals("bye")){
            try {
                DukeComannds(line, list);
            }catch(DukeException e){
                System.out.println(e);
                System.out.println("");
            }


        }

    }

    public static void DukeComannds(String line, tasks[] list) throws DukeException {
        String[] commands;
        commands= line.split(" ");

        if(line.equals("list")){
            listFaction(list);
            System.out.println("");
        }
        else if(commands[0].equals("done")){
            if(commands.length<2){
                throw new DukeException("OOPS!!! The description of a done cannot be empty.");
            }
            MarkAsDoneFaction(commands, list);
            System.out.println("");
        }
        else if(commands[0].equals("todo")){
            if(commands.length<2){
                throw new DukeException("OOPS!!! The description of a todo cannot be empty.");
            }

            list[tasks.getTaskNum()]=new ToDo(line);
            System.out.println("");
        }
        else if (commands[0].equals("deadline")){
            if(commands.length<2){
                throw new DukeException("OOPS!!! The description of a deadline cannot be empty.");
            }
            if(!line.contains("/")){
                throw new DukeException("OOPS!!! Please indicate the time of the deadline by '/' ");
            }
            list[tasks.getTaskNum()]=new Deadline(line);
            System.out.println("");
        }

        else if (commands[0].equals("event")){
            if(commands.length<2){
                throw new DukeException("OOPS!!! The description of a event cannot be empty.");
            }
            if(!line.contains("/")){
                throw new DukeException("OOPS!!! Please indicate the time of the event by '/' ");
            }
            list[tasks.getTaskNum()]=new Event(line);
            System.out.println("");
        }

        else{
            throw new DukeException("OOPS!!! This command doesn't exist");
        }

    }

    private static void AddFaction(String line, tasks[] list) {
        list[tasks.getTaskNum()]=new tasks(line);
        System.out.println("   added: ");

    }

    private static void MarkAsDoneFaction(String[] commands, tasks[] list) throws DukeException{
        int currentTask=Integer.parseInt(commands[1])-1;
        list[currentTask].setDone();
        System.out.println("Nice, I have marked this work as done");
        list[currentTask].displayTasks();

    }

    private static void listFaction(tasks[] list) throws DukeException{
        System.out.println("here are the tasks in you list: ");
        for(int i=0;i<tasks.getTaskNum();i++){
            System.out.print("  "+(i+1)+".");
            list[i].displayTasks();
        }

    }


}
