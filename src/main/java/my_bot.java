import java.util.Scanner;

public class my_bot {
    public static void main(String[] args){

        System.out.println("Hello! I'm Duke");
        System.out.println("What can I do for you?");
        System.out.println("");
        storeInput();
        System.out.println("Bye. Hope to see you again soon");
    }
    public static void storeInput(){
        String line;
        tasks[] list=new tasks[100];
        tasks.setTaskNum(0);
        Scanner in=new Scanner(System.in);
        while(!(line= in.nextLine()).equals("bye")){
            if(line.equals("list")){
                System.out.println("here are the tasks in you list: ");
                for(int i=0;i<tasks.getTaskNum();i++){
                    System.out.print((i+1)+".");
                    list[i].markAsDone();
                }
            }
            else if(line.contains("done")){
                String[] commandPart=new String[2];
                commandPart=line.split(" ");
                int currentTask=Integer.parseInt(commandPart[1])-1;
                list[currentTask].setDone();
                System.out.println("Nice, I have marked this work as done");
                list[currentTask].markAsDone();

            }
            else{
                list[tasks.getTaskNum()]=new tasks(line);
                System.out.println("   added: "+line);
                tasks.setTaskNum(tasks.getTaskNum()+1);
            }
        }

    }

}
