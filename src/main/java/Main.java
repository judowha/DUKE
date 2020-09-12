import java.util.Scanner;
import Duke.java.*;
import java.util.HashMap;
import java.util.Map;

public class Main {
    private static HashMap<Integer,String> taskList = new HashMap<>();
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
        else if(commands[0].equals("todo")){
            if(commands.length<2){
                throw new DukeException("OOPS!!! The description of a todo cannot be empty.");
            }

            list[tasks.getTaskNum()]=new ToDo(line);
            taskList.put(tasks.getTaskNum(),list[tasks.getTaskNum()-1].getTask());
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
            taskList.put(tasks.getTaskNum(),list[tasks.getTaskNum()-1].getTask());
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
            taskList.put(tasks.getTaskNum(),list[tasks.getTaskNum()-1].getTask());
            System.out.println("");
        }
        else if(commands[0].equals("done")){
            if(commands.length<2){
                throw new DukeException("OOPS!!! The description of a done cannot be empty.");
            }
            MarkAsDoneFaction(commands, list);
            System.out.println("");
        }
        else if(commands[0].equals("delete")){
            if(commands.length<2){
                throw new DukeException("OOPS!!! The description of a done cannot be empty.");
            }
            else deleteTask(commands,list);
        }


        else{
            throw new DukeException("OOPS!!! This command doesn't exist");
        }

    }

    private static void MarkAsDoneFaction(String[] commands, tasks[] list) {
        int currentTask=Integer.parseInt(commands[1])-1;
        list[currentTask].setDone();
        taskList.put(currentTask+1,list[currentTask].getTask());
    }

    private static void deleteTask(String[] commands, tasks[] list){
        int targetTask=Integer.parseInt(commands[1]);
        System.out.println("Noted. I've removed this task:");
        list[targetTask-1].displayTasks();
        System.out.println("Now you have "+tasks.getTaskNum()+ " tasks in the list.");
        taskList.remove(targetTask);
    }

    private static void listFaction(tasks[] list) {
        System.out.println("here are the tasks in you list: ");
        for(Map.Entry<Integer,String> entry: taskList.entrySet()){
            System.out.println(entry.getKey()+". "+entry.getValue());
        }

    }




}
