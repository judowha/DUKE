import java.util.Scanner;

public class Main {
    public static void main(String[] args){

        showGreeting();
        storeInput();
        System.out.println("Bye. Hope to see you again soon");
    }

    private static void showGreeting() {
        System.out.println("Hello! I'm Duke");
        System.out.println("What can I do for you?");
        System.out.println("");
    }


    public static void storeInput(){
        String line;
        String[] commands=new String[100];
        tasks[] list=new tasks[100];
        tasks.setTaskNum(0);
        Scanner in=new Scanner(System.in);
        while(!(line= in.nextLine()).equals("bye")){
            commands=line.split(" ");
            if(line.equals("list")){
                listFaction(list);
            }
            else if(commands[0].equals("done")){
                MarkAsDoneFaction(commands, list);
            }
            else if(commands[0].equals("todo")){
                list[tasks.getTaskNum()]=new ToDo(line);
            }
            else if (commands[0].equals("deadline")){
                list[tasks.getTaskNum()]=new Deadline(line);
            }

            else if (commands[0].equals("event")){
                list[tasks.getTaskNum()]=new Event(line);
            }
            else{
                AddFaction(line, list);
            }


        }

    }

    private static void AddFaction(String line, tasks[] list) {
        list[tasks.getTaskNum()]=new tasks(line);
        System.out.println("   added: "+ line);
    }

    private static void MarkAsDoneFaction(String[] commands, tasks[] list) {
        int currentTask=Integer.parseInt(commands[1])-1;
        list[currentTask].setDone();
        System.out.println("Nice, I have marked this work as done");
        list[currentTask].displayTasks();
    }

    private static void listFaction(tasks[] list) {
        System.out.println("here are the tasks in you list: ");
        for(int i=0;i<tasks.getTaskNum();i++){
            System.out.print("  "+(i+1)+".");
            list[i].displayTasks();
        }
    }


}
