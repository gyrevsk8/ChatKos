
import java.io.IOException;
import java.util.Scanner;


public class Project {


    Scanner scan = new Scanner(System.in);
    public  void registr() throws NumberException {//тело
        Chat user = new Chat();
        Phone phoneNumber = new Phone();
        Mss messege = new Mss();


        while (true) {
            System.out.print("firstname:");
            String firstname = "";
            firstname = nameIns();
            user.setName(firstname);

            System.out.print("\nsecondname:");
            String surname = "";
            surname = snameIns();
            user.setSurname(surname);

            System.out.print("\nphone:");
            String phone = scan.nextLine();
            System.out.println(phone);
            phoneNumber.setPhoneNumber(phone);
            String phoneNew=Phone.checkPhone(phone);

            if (phoneNew.equals("-"))
            {
                continue;
            }


            System.out.println("Firstname:" + firstname);
            System.out.println("Surname:" + surname);
            messege.phn = phoneNew;
            System.out.println("Phone:"+phoneNew);
            messege.makeLog();

            System.out.println("Next? (1/0)");
            int flagStatus = Integer.parseInt(scan.nextLine());
            if (flagStatus==0)
                break;
        }
    }

public String nameIns()
{
    String name = "";

        while (true) {
            name = scan.nextLine();
            if (name == "") {
                System.out.println("Введите имя! :");
            }
            else {
                break;
            }
        }
        return name;



}
    public String snameIns()
    {
        String sname = "";

        while (true) {
            sname = scan.nextLine();
            if (sname == "") {
                System.out.println("Введите фамилию! :");
            } else {
                break;
            }
        }
        return sname;



    }



}

class NameException   extends Exception{
    public NameException()
    {


    }

}
