
import java.util.Scanner;


public class Project {
    public  void log () {//тело
        Chat user = new Chat();
        Phone phoneNumber = new Phone();
        Mss messege = new Mss();
        Scanner scan = new Scanner(System.in);

        while (true) {
            System.out.print("firstname:");
            String firstname = scan.nextLine();

            System.out.print("\nsecondname:");
            String surname = scan.nextLine();

            System.out.print("\nphone:");
            String phone = scan.nextLine();

            System.out.println(phone);

            user.setName(firstname);
            user.setSurname(surname);

            phoneNumber.setPhoneNumber(phone);
            String phoneNew=Phone.checkPhone(phone);
            if (phoneNew.equals("-"))
            {
                continue;
            }


            System.out.println("Firstname:" + firstname);
            System.out.println("Surname:" + surname);
            System.out.println("Phone:"+phoneNew);
            messege.show();

            System.out.println("Next? (1/0)");
            int flagStatus = Integer.parseInt(scan.nextLine());
            if (flagStatus==0)
                break;
        }
    }

    public static class Chat {
        public static String firstname;
        public static String surname;


        public void setName(String firstname) {//геттер пароль
            this.firstname = firstname;
        }
        public void setSurname(String surname){//сеттер пароль
            this.surname=surname;
        }
        public static String getName(){//геттер пароль
            return firstname;
        }
        public static String getSurname() {//геттер логина
            return surname;
        }

    }



}
