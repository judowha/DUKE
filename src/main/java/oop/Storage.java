package oop;

import Duke.java.Deadline;
import Duke.java.Event;
import Duke.java.ToDo;
import Duke.java.tasks;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;



public class Storage {
    public static String getFileContain(ArrayList<tasks> taskList){
        String contain = "";
        for(int i = 0; i< tasks.getTaskNum(); i++){
            contain=contain+(i+1)+"."+taskList.get(i).getTask()+System.lineSeparator();
        }
        return contain;
    }

    /**
     * Write the contain testToAdd to a file
     * @param filePath path of the file
     * @param textToAdd text wants to add
     * @throws IOException IOException
     */
    public static void writeToFile(String filePath, String textToAdd) throws IOException {
        FileWriter fw = new FileWriter(filePath);
        fw.write(textToAdd);
        fw.close();
    }


    /**
     * Read a file from the filePath and store it in the task list
     * @param filePath path of the file
     * @param taskList target array list
     * @throws FileNotFoundException if the file does not exist
     */
    public static void ReadFile(String filePath, ArrayList<tasks> taskList) throws FileNotFoundException {
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

            if(taskCommand.charAt(7)=='D'){
                taskList.get(tasks.getTaskNum()-1).setDone();
            }
        }
    }
}
