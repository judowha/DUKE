package opp;

import Duke.java.Deadline;
import Duke.java.Event;
import Duke.java.ToDo;
import Duke.java.tasks;

import java.util.ArrayList;

public class TaskList {
    public static void AddToDoCommands(ArrayList<tasks> taskList, String line){

        taskList.add(new ToDo(line));
        int indexOfCurrentTask= tasks.getTaskNum()-1;
        UI.showAddInformation(taskList.get(indexOfCurrentTask).getTask());
    }

    public static void AddEventCommands(ArrayList<tasks> taskList, String line) throws DukeException {

        taskList.add(new Event(line));
        int indexOfCurrentTask= tasks.getTaskNum()-1;
        UI.showAddInformation(taskList.get(indexOfCurrentTask).getTask());
    }
    public static void AddDeadlineCommands(ArrayList<tasks> taskList, String line) throws DukeException {

        taskList.add(new Deadline(line));
        int indexOfCurrentTask= tasks.getTaskNum()-1;
        UI.showAddInformation(taskList.get(indexOfCurrentTask).getTask());
    }

    public static void deleteTask(String[] commands, ArrayList<tasks> taskList) throws DukeException {
        int targetTask=Integer.parseInt(commands[1])-1;
        if(targetTask>=tasks.getTaskNum()){
            throw new DukeException("OOPS!!! the task is not exist, please enter a valid serial number");
        }
        System.out.println("Noted. I've removed this task:");
        taskList.get(targetTask).displayTask();
        taskList.remove(targetTask);
        tasks.setTaskNum(tasks.getTaskNum()-1);
        System.out.println("Now you have "+tasks.getTaskNum()+ " tasks in the list."+System.lineSeparator());

    }

    public static void MarkAsDoneFaction(String[] commands, ArrayList<tasks> taskList) throws DukeException {
        int currentTask=Integer.parseInt(commands[1])-1;
        if(currentTask>=tasks.getTaskNum()){
            throw new DukeException("OOPS!!! the task is not exist, please enter a valid serial number");
        }
        taskList.get(currentTask).setDone();
        UI.showSetDoneInformation(taskList.get(currentTask).getTask());
    }

    public static void listFaction(ArrayList<tasks> taskList) {
        System.out.println("here are the tasks in you list: ");
        for(int i=0; i<taskList.size();i++){
            System.out.println(i+1+"."+taskList.get(i).getTask());
        }
        System.out.print(System.lineSeparator());
    }
/*
    public static void remainderEvent(ArrayList<tasks> taskList, int index){
        LocalDate nowDate=LocalDate.now();
        LocalTime nowTime=LocalTime.now();
        if (taskList.get(index).getDate().isEqual(nowDate)&&taskList.get(index).getTime().isAfter(nowTime)){
            System.out.println(" (!!! this event need to be done today!!)");
        }
        else if (taskList.get(index).getDate().isBefore(nowDate)){

        }
        else {
            taskList.get(index).setDone();
           System.out.println(" (This task has finished)");
        }
    }

 */
}
