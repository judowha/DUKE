package oop;

import Duke.Deadline;
import Duke.Event;
import Duke.ToDo;
import Duke.tasks;

import java.util.ArrayList;

public class TaskList {

    /**
     * Add a task of type to do in the list of tasks.
     *
     * @param taskList target array list
     * @param line the input line
     */
    public static void AddToDoCommands(ArrayList<tasks> taskList, String line) {

        taskList.add(new ToDo(line));
        int indexOfCurrentTask = tasks.getTaskNum() - 1;
        UI.showAddInformation(taskList.get(indexOfCurrentTask).getTask());
    }

    /**
     * Add a task of type event in the list of tasks.
     *
     * @param taskList target array list
     * @param line the input line
     */
    public static void AddEventCommands(ArrayList<tasks> taskList, String line) throws DukeException {

        taskList.add(new Event(line));
        int indexOfCurrentTask = tasks.getTaskNum() - 1;
        UI.showAddInformation(taskList.get(indexOfCurrentTask).getTask());
    }

    /**
     * Add a task of type deadline in the list of tasks.
     *
     * @param taskList target array list
     * @param line the input line
     */
    public static void AddDeadlineCommands(ArrayList<tasks> taskList, String line) throws DukeException {

        taskList.add(new Deadline(line));
        int indexOfCurrentTask = tasks.getTaskNum() - 1;
        UI.showAddInformation(taskList.get(indexOfCurrentTask).getTask());
    }

    /**
     * Remove a specific task from the task list.
     *
     * @param commands input command
     * @param taskList target array list
     * @throws DukeException
     */
    public static void deleteTask(String[] commands, ArrayList<tasks> taskList) throws DukeException {
        int targetTask = Integer.parseInt(commands[1]) - 1;
        if (targetTask >= tasks.getTaskNum()) {
            throw new DukeException("OOPS!!! the task is not exist, please enter a valid serial number");
        }
        System.out.println("Noted. I've removed this task:");
        taskList.get(targetTask).displayTask();
        taskList.remove(targetTask);
        tasks.setTaskNum(tasks.getTaskNum() - 1);
        System.out.println("Now you have " + tasks.getTaskNum() + " tasks in the list." + System.lineSeparator());

    }

    /**
     * Set a specific task as done.
     *
     * @param commands input command
     * @param taskList target array list
     * @throws DukeException if the index number of the task is not valid
     */
    public static void MarkAsDoneFaction(String[] commands, ArrayList<tasks> taskList) throws DukeException {
        int currentTask = Integer.parseInt(commands[1]) - 1;
        if (currentTask >= tasks.getTaskNum()) {
            throw new DukeException("OOPS!!! the task is not exist, please enter a valid serial number");
        }
        taskList.get(currentTask).setDone();
        UI.showSetDoneInformation(taskList.get(currentTask).getTask());
    }

    /**
     * Show the full task list.
     *
     * @param taskList target array list
     */
    public static void listFaction(ArrayList<tasks> taskList) {
        System.out.println("here are the tasks in you list:");
        for (int i = 0; i < taskList.size(); i++) {
            System.out.println(i + 1 + "." + taskList.get(i).getTask());
        }
        System.out.println("Now you have " + tasks.getTaskNum() + " tasks in the list." + System.lineSeparator());
    }

    /**
     * Find a task in the task list by searching for a keyword.
     *
     * @param commands input command
     * @param taskList target array list
     */
    public static void findTask(String[] commands, ArrayList<tasks> taskList) {
        int index = 0;
        String targetTask = commands[1];
        System.out.println("Here are matching tasks in your list");
        for (int i = 0; i < taskList.size(); i++) {
            if (taskList.get(i).getTask().contains(targetTask)) {
                index++;
                System.out.println(index + "." + taskList.get(i).getTask());
            }
        }
        if (index == 0) {
            System.out.println("Sorry, no match task exists");
        }
        System.out.print(System.lineSeparator());
    }
}
