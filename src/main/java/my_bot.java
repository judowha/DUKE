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
        String[] list=new String[100];
        int listNUm=0;
        Scanner in=new Scanner(System.in);
        while(!(line= in.nextLine()).equals("bye")){
            if(line.equals("list")){
                for(int i=0;i<listNUm;i++){
                    System.out.println((i+1)+"."+list[i]);
                }
            }
            else{
                list[listNUm]=line;
                System.out.println("   added: "+line);
                listNUm++;
            }
        }

    }

}
