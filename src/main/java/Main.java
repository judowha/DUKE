import java.time.format.DateTimeParseException;
import java.util.Scanner;
import Duke.java.*;
import oop.*;
import java.util.ArrayList;
import java.io.IOException;
import java.io.FileNotFoundException;

public class Main {
    private static ArrayList<tasks> taskList = new ArrayList<>();
    private final static String EVENT="event";
    private final static String TODO="todo";
    private final static String DEADLINE="deadline";
    private final static String BYE="bye";
    private final static String LIST="list";
    private final static String DONE="done";
    private final static String DELETE="delete";
    private final static String HELP="help";
    private final static String FIND="find";

    public static void main(String[] args)  {

        UI.showGreetings();
        RunReadFile();
        RunDukeCommands();
        UI.sayBye();
    }

    public static void RunReadFile(){
        try{
            Storage.ReadFile("duke.txt",taskList);
        }catch(FileNotFoundException e){
            System.out.println("A new file will be created to save your schedule");
        }
    }

    public static void RunDukeCommands() {
        String inputLine;
        Scanner in=new Scanner(System.in);
        while(!(inputLine= in.nextLine()).equals(BYE)){
            try {
                DukeCommands(inputLine);
            }catch(DukeException e){
                System.out.println(e+System.lineSeparator());
            }catch(IOException e){
                System.out.println("OOPS!!! there are something wrong with the file"+System.lineSeparator());
            }catch(DateTimeParseException e){
                System.out.println("OOPS!!! please check the input format of date and time"+System.lineSeparator());
            }catch(NumberFormatException e){
                System.out.println("OOPS!!! please ensure that you input a integer but not a character"+System.lineSeparator());
            }
        }
    }


    /**
     * Accept users' input and do corresponding commands
     * @param line users' input line
     * @throws DukeException DukeException
     * @throws IOException IOException
     */

    public static void DukeCommands(String line) throws DukeException, IOException {
        String[] commands;
        commands = line.split(" ");
        String filePath = "duke.txt";
        if (line.equals(LIST)) {
            TaskList.listFaction(taskList);
        }
        else if (commands[0].equals(TODO)) {
            UI.CheckEmptyDescription(commands, TODO);
            TaskList.AddToDoCommands(taskList, line);
            Storage.writeToFile(filePath, Storage.getFileContain(taskList));
        }
        else if (commands[0].equals(DEADLINE)) {
            UI.CheckEmptyDescription(commands, DEADLINE);
            UI.CheckValidInputFormat(line, DEADLINE);
            TaskList.AddDeadlineCommands(taskList, line);
            Storage.writeToFile(filePath, Storage.getFileContain(taskList));
        }
        else if (commands[0].equals(EVENT)) {
            UI.CheckEmptyDescription(commands, EVENT);
            UI.CheckValidInputFormat(line, EVENT);
            TaskList.AddEventCommands(taskList, line);
            Storage.writeToFile(filePath, Storage.getFileContain(taskList));
        }
        else if (commands[0].equals(DONE)) {
            UI.CheckEmptyDescription(commands, DONE);
            TaskList.MarkAsDoneFaction(commands, taskList);
            Storage.writeToFile(filePath, Storage.getFileContain(taskList));
        }
        else if (commands[0].equals(DELETE)) {
            UI.CheckEmptyDescription(commands, DELETE);
            TaskList.deleteTask(commands, taskList);
            Storage.writeToFile(filePath, Storage.getFileContain(taskList));
        }
        else if (commands[0].equals(FIND)) {
            UI.CheckEmptyDescription(commands,FIND);
            TaskList.findTask(commands, taskList);
        }
        else if (commands[0].equals(HELP)) {
            UI.dukeHelp();
        }
        else {
            UI.NoneExistCommand();
        }
    }
}
