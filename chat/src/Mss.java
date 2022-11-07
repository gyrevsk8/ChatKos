//import java.io.PrintStream;
import java.util.Date;
import java.util.Scanner;
import java.io.*;
public class Mss {
    public void makeLog() //логи
    {

        Scanner scan = new Scanner(System.in);
        String messge ;
        String name ;
        Chat ch = new Chat();
        name = ch.getName()+ " " +ch.getSurname() ;
        System.out.print(name);
        System.out.print(" Send:");
        messge = scan.nextLine(); // сюда исключения для сообщений
        System.out.println(messge);




        try(FileWriter writer = new FileWriter("Log.txt", true))
        {   Date date = new Date();
            writer.append('\n');
            // запись всей строки
            writer.write(date.toString());
            writer.append('\n');
            String text = "Name:"+ ch.getName()+'\n' + "Surneme:" +'\n'+ ch.getSurname() + " Messge:";
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
