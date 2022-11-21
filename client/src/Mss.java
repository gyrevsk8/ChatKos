//import java.io.PrintStream;
import java.util.Date;
import java.util.Scanner;
import java.io.*;
public class Mss {
    String phn = "";
    public void makeLog() //логи
    {
        Scanner scan = new Scanner(System.in);
        String messge = null;
        String trueMessage=null;
        String name ;
        Chat ch = new Chat();
        name = ch.getName()+ " " +ch.getSurname() ;

        System.out.print(name);
        System.out.print(" Send:");
        try{
            PGP pgp = new PGP();
            messge = scan.nextLine();// сюда исключения для сообщений
            String encryptedMessage = pgp.encrypt(messge);
            trueMessage=messge;
            System.out.println(messge);
            System.out.println(encryptedMessage);
            messge=encryptedMessage;
        }catch (Exception ignored){}





        try (FileWriter writer = new FileWriter("Log.txt", true))
        {
            Date date = new Date();
            writer.append('\n');
            // запись всей строки
            writer.write(date.toString());
            writer.append('\n');
            String text = "Name:"+ ch.getName()+'\n' + "Surneme:" + ch.getSurname()+'\n'+phn+'\n' + " Messge:";
            writer.write(text);

            text = messge ;
            writer.write(text);
            writer.append('\n');




            writer.flush();
        }
        catch(IOException ex){

            System.out.println(ex.getMessage());
        }
        try (FileWriter writer = new FileWriter("chat/decrypted.txt", true))
        {
            Date date = new Date();
            writer.append('\n');
            // запись всей строки
            writer.write(date.toString());
            writer.append('\n');
            String text = "Name:"+ ch.getName()+'\n' + "Surname:" + ch.getSurname()+'\n'+phn+'\n' + " Messge:";
            writer.write(text);
            text = trueMessage ;
            writer.write(text);
            writer.append('\n');




            writer.flush();
        }
        catch(IOException ex){

            System.out.println(ex.getMessage());
        }
    }
}
