//import java.util.Scanner;

public class Phone {
    //Project p = new Project();

    private String phoneNumber;


    public String getPhoneNumber() {    //????

        return phoneNumber;
    }
    public void setPhoneNumber(String phoneNumber){
     this.phoneNumber=phoneNumber;
    }


    static String checkPhone(String phoneNumber) {// тут очевидно нужны tey catch!

        while(true) {
            phoneNumber = phoneNumber.replaceAll("\\D+", "");
            if (phoneNumber.length() == 11) {
                break;
            }
            else {

                System.out.println("Номер некорректен, повторите попытку");
                return "-";

            }
        }
        String[] newNumber = phoneNumber.split("");
        newNumber[0] = "7";
        phoneNumber = newNumber[0]+"("+newNumber[1]+newNumber[2]+newNumber[3]+")"+newNumber[4]+newNumber[5]+newNumber[6]+"-"+newNumber[7]+newNumber[8]+"-"+newNumber[9]+newNumber[10];
        return phoneNumber;
    }

    }


