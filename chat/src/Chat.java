public class Chat {
    public static String firstname;
    public static String surname;


    public void setName(String firstname) {//геттер пароль
        this.firstname = firstname;
    }
    public void setSurname(String surname){//сеттер пароль
        this.surname=surname;
    }
    public String getName(){//геттер пароль
        return firstname;
    }
    public String getSurname() {//геттер логина
        return surname;
    }

}