import java.util.Scanner;
import Duke.java.*;
import java.util.ArrayList;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class Main {
    private static ArrayList<tasks> taskList = new ArrayList<>();
    public static void main(String[] args)  {

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
        try{
            ReadFile("duke.txt");
        }catch(FileNotFoundException e){
            System.out.println("A new file will be created to save your schedule");
        }
        while(!(line= in.nextLine()).equals("bye")){
            try {
                DukeComannds(line);
            }catch(DukeException  e){
                System.out.println(e);
                System.out.println("");
            }catch(IOException e){
                System.out.println("OOPS!!!, there are something wrong with the file"+System.lineSeparator());
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

        }
        else if(commands[0].equals("todo")){
            if(commands.length<2){
                throw new DukeException("OOPS!!! The description of a todo cannot be empty.");
            }
            taskList.add(new ToDo(line));
            taskList.get(tasks.getTaskNum()-1).showAddInformation();
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
            taskList.get(tasks.getTaskNum()-1).showAddInformation();
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
            taskList.get(tasks.getTaskNum()-1).showAddInformation();
            System.out.println("");
            writeToFile(filePath,getFileContain());
        }
        else if(commands[0].equals("done")){
            if(commands.length<2){
                throw new DukeException("OOPS!!! The description of a done cannot be empty.");
            }
            MarkAsDoneFaction(commands);
            System.out.println("");
            writeToFile(filePath,getFileContain());
        }
        else if(commands[0].equals("delete")){
            if(commands.length<2){
                throw new DukeException("OOPS!!! The description of a done cannot be empty.");
            }
            else deleteTask(commands);
            writeToFile(filePath,getFileContain());
        }

        else if(commands[0].equals("find")){
            if(commands.length<2){
                throw new DukeException("OOPS!!! The description of a done cannot be empty.");
            }
            else findTask(commands);
        }

        else{
            throw new DukeException("OOPS!!! This command doesn't exist");
        }

    }

    private static void MarkAsDoneFaction(String[] commands) {
        int currentTask=Integer.parseInt(commands[1])-1;
        taskList.get(currentTask).setDone();
        taskList.get(currentTask).showSetDoneInformation();
    }

    private static void deleteTask(String[] commands){
        int targetTask=Integer.parseInt(commands[1])-1;
        System.out.println("Noted. I've removed this task:");
        taskList.get(targetTask).displayTasks();
        taskList.remove(targetTask);
        tasks.setTaskNum(tasks.getTaskNum()-1);
        System.out.println("Now you have "+tasks.getTaskNum()+ " tasks in the list."+System.lineSeparator());

    }

    private static void listFaction() {
        System.out.println("here are the tasks in you list: ");
        for(int i=0; i<taskList.size();i++){
            System.out.println(i+1+"."+taskList.get(i).getTask());
        }

    }

    private static void findTask(String[] commands){
        int index=0;
        String targetTask=commands[1];
        System.out.println("Here are matching tasks in your list");
        for(int i=0;i<taskList.size();i++){
            if(taskList.get(i).getTask().contains(targetTask)){
                index++;
                System.out.println(index+"."+taskList.get(i).getTask());
            }
        }
        if(index==0){
            System.out.println("Sorry, no match task exists");
        }
        System.out.print(System.lineSeparator());
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

    private static void ReadFile(String filePath) throws FileNotFoundException {
        String taskCommand;
        File f= new File(filePath);
        Scanner s= new Scanner(f);


        while (s.hasNext()){
            taskCommand=s.nextLine();

            if (taskCommand.charAt(5)=='D'){
                Deadline task= new Deadline();
                task.setTask(taskCommand.substring(2));
                taskList.add(task);

            }
            else if (taskCommand.charAt(5)=='E'){
                Event task= new Event();
                task.setTask(taskCommand.substring(2));
                taskList.add(task);
            }
            else if (taskCommand.charAt(5)=='T'){
                ToDo task= new ToDo();
                task.setTask(taskCommand.substring(2));
                taskList.add(task);
            }

            if(taskCommand.charAt(7)=='\u2713'){
                taskList.get(tasks.getTaskNum()-1).setDone();
            }
        }
    }
}
