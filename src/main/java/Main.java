import java.util.Scanner;
import Duke.java.*;
import java.util.ArrayList;
import java.io.FileWriter;
import java.io.IOException;


public class Main {
    private static ArrayList<tasks> taskList = new ArrayList<>();
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
        tasks.setTaskNum(0);
        Scanner in=new Scanner(System.in);
        while(!(line= in.nextLine()).equals("bye")){
            try {
                DukeComannds(line);
            }catch(DukeException | IOException e){
                System.out.println(e);
                System.out.println("");
            }


        }

    }



    public static void DukeComannds(String line) throws DukeException, IOException {
        String[] commands;
        commands= line.split(" ");
        String filePath="duke.txt";
        if(line.equals("list")){
            listFaction();
            System.out.println("");
            writeToFile(filePath,getFileContain());

        }
        else if(commands[0].equals("todo")){
            if(commands.length<2){
                throw new DukeException("OOPS!!! The description of a todo cannot be empty.");
            }
            taskList.add(new ToDo(line));
            System.out.println("");
            writeToFile(filePath,getFileContain());
        }
        else if (commands[0].equals("deadline")){
            if(commands.length<2){
                throw new DukeException("OOPS!!! The description of a deadline cannot be empty.");
            }
            if(!line.contains("/")){
                throw new DukeException("OOPS!!! Please indicate the time of the deadline by '/' ");
            }

            taskList.add(new Deadline(line));
            System.out.println("");
            writeToFile(filePath,getFileContain());
        }

        else if (commands[0].equals("event")){
            if(commands.length<2){
                throw new DukeException("OOPS!!! The description of a event cannot be empty.");
            }
            if(!line.contains("/")){
                throw new DukeException("OOPS!!! Please indicate the time of the event by '/' ");
            }
            taskList.add(new Event(line));
            System.out.println("");
            writeToFile(filePath,getFileContain());
        }
        else if(commands[0].equals("done")){
            if(commands.length<2){
                throw new DukeException("OOPS!!! The description of a done cannot be empty.");
            }
            MarkAsDoneFaction(commands);
            System.out.println("");
        }
        else if(commands[0].equals("delete")){
            if(commands.length<2){
                throw new DukeException("OOPS!!! The description of a done cannot be empty.");
            }
            else deleteTask(commands);
        }


        else{
            throw new DukeException("OOPS!!! This command doesn't exist");
        }

    }

    private static void MarkAsDoneFaction(String[] commands) {
        int currentTask=Integer.parseInt(commands[1])-1;
        taskList.get(currentTask).setDone();
    }

    private static void deleteTask(String[] commands){
        int targetTask=Integer.parseInt(commands[1])-1;
        System.out.println("Noted. I've removed this task:");
        taskList.get(targetTask).displayTasks();
        taskList.remove(targetTask);
        tasks.setTaskNum(tasks.getTaskNum()-1);
        System.out.println("Now you have "+tasks.getTaskNum()+ " tasks in the list.");

    }

    private static void listFaction() {
        System.out.println("here are the tasks in you list: ");
        for(int i=0; i<taskList.size();i++){
            System.out.println(i+1+". "+taskList.get(i).getTask());
        }

    }

    private static String getFileContain(){
        String contain = "";
        for(int i=0;i<tasks.getTaskNum();i++){
            contain=contain+(i+1)+"."+taskList.get(i).getTask()+System.lineSeparator();
        }
        return contain;
    }
    private static void writeToFile(String filePath, String textToAdd) throws IOException {
        FileWriter fw = new FileWriter(filePath);
        fw.write(textToAdd);
        fw.close();
    }





}
