//import java.util.Scanner;

import java.util.Scanner;

public class Phone {
    //Project p = new Project();

    private String phoneNumber;


    public String getPhoneNumber() {    //????

        return phoneNumber;
    }
    public void setPhoneNumber(String phoneNumber){
     this.phoneNumber=phoneNumber;
    }


    static String checkPhone(String phoneNumber) throws NumberException {// тут очевидно нужны tey catch!
        try
        {
            phoneNumber = phoneNumber.replaceAll("\\D+", "");


            if (phoneNumber.length() != 11) {
                throw new NumberException("wrong Number");
            }

            String[] newNumber = phoneNumber.split("");
            newNumber[0] = "7";
            phoneNumber = newNumber[0]+"("+newNumber[1]+newNumber[2]+newNumber[3]+")"+newNumber[4]+newNumber[5]+newNumber[6]+"-"+newNumber[7]+newNumber[8]+"-"+newNumber[9]+newNumber[10];
            return phoneNumber;
        }
        catch (NumberException e) {

            Scanner scan = new Scanner(System.in);
            System.out.print("\nphone:");
            String phone = scan.nextLine();
            String phoneNew=Phone.checkPhone(phone);
            return phoneNumber;

        }

    }

    }
class NumberException extends Exception{

    private String mss = "Sad number";
    public NumberException(String mss){
        this.mss=mss;


    }
}


