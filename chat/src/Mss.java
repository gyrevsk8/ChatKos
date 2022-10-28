import java.io.PrintStream;
import java.util.Date;
import java.util.Scanner;
import java.io.*;
public class Mss {
    public void show()
    {
        Project p = new Project();
        Project.Chat ki = new Project.Chat();
        Scanner scan = new Scanner(System.in);
        String messge = new String();
        String name = new String();
        name = Project.Chat.getName()+ " " +Project.Chat.getSurname() ;
        System.out.print(name);
        System.out.print(" Send:");
        messge = scan.nextLine();
        System.out.println(messge);




        try(FileWriter writer = new FileWriter("Log.txt", true))
        {   Date date = new Date();
            writer.append('\n');
            // запись всей строки
            writer.write(date.toString());
            writer.append('\n');
            String text = "Name:"+ Project.Chat.getName()+ " Surneme:" +Project.Chat.getSurname() + " Messge:";
            writer.write(text);
            text = messge;
            writer.write(text);
            writer.append('\n');




            writer.flush();
        }
        catch(IOException ex){

            System.out.println(ex.getMessage());
        }
    }
}
