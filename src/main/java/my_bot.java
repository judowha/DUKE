import java.util.Scanner;

public class my_bot {
    public static void main(String[] args){

        System.out.println("Hello! I'm Duke");
        System.out.println("What can I do for you?");
        System.out.println("");
        String line;
        Scanner in=new Scanner(System.in);
        while(!(line= in.nextLine()).equals("bye")){
            System.out.println("   "+line);
        }
        System.out.println("Bye. Hope to see you again soon");
    }

}
