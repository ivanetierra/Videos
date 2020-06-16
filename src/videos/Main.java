package videos;

import javax.swing.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Main {


    public static void main(String[] args) throws Exception {

        List<User> users = new ArrayList<>();

        System.out.println("1:[Create User]  2:[Log in]  0:[Exit]");
        String userOption = JOptionPane.showInputDialog("1:[Create User]  2:[Log in]  0:[Exit]");

        while (!userOption.equals("0")) {

            switch (userOption) {

                case "1": // Create
                    users.add(createUser()); //create and add a new User to users List

                    userOption = JOptionPane.showInputDialog("1:[Create User]  2:[Log in]  0:[Exit]");
                    break;

                case "2": //Log in - Enter
                    logIn(users);

                    userOption = JOptionPane.showInputDialog("1:[Create User]  2:[Log in]  0:[Exit]");
                    break;

                default:
                    System.out.println("Wrong input");

                    userOption = JOptionPane.showInputDialog("1:[Create User]  2:[Log in]  0:[Exit]");
                    break;
            }
        }
    }

    private static User createUser() throws Exception {

        System.out.println("Create a new User:");

        String name = null;
        String surname = null;
        String password = null;


        boolean inputOK=false;

        while(inputOK == false){

            //try catch para que recoja la excepción si se introdice un input en blanco
            try {
                name = JOptionPane.showInputDialog("Name:");
                checkInput(name);

                surname = JOptionPane.showInputDialog("Surname:");
                checkInput(surname);

                password = JOptionPane.showInputDialog("Password:");
                checkInput(password);

                inputOK = true;

            } catch (Exception e) {
                System.out.println("Input should not be blank!");
            }
        }


        LocalDate date = LocalDate.now();

        User user1 = new User(name, surname, password, date);
        System.out.println("New User "+user1.getName()+" "+user1.getSurname()+" Created On "+user1.getDate()+"!");

        return user1;
    }

    private static void logIn(List<User> users) throws Exception {

        System.out.println("Log in into your account:");

        String name = null;
        String surname = null;
        String password = null;

//try catch para que salte la excepción si se intrudice un input en blanco
        try {
            name = JOptionPane.showInputDialog("Name:");
            checkInput(name);

            surname = JOptionPane.showInputDialog("Surname:");
            checkInput(surname);

            password = JOptionPane.showInputDialog("Password:");
            checkInput(password);

        } catch (Exception e) {
            System.out.println("Input should not be blank!");
        }

        //comprueba si el nombre, Apellido y password son de algun usuario
        boolean isValid = Validate(name, surname, password, users);


        if(isValid){

            //myUser es el usuario que ya hemos validado que existe
            User myUser = getValidUser(name, surname, password, users);

            System.out.println("Welcome "+myUser.getName()+" "+myUser.getSurname()+"!");

            String userOption = JOptionPane.showInputDialog("1:[Create Video]  2:[See My videos]  0:[Exit]");

            while (!userOption.equals("0")) {

                switch (userOption) {

                    case "1": //create video

                        myUser.CreateVideo();

                        userOption = JOptionPane.showInputDialog("1:[Create Video]  2:[See My videos]  0:[Exit]");
                        break;

                    case "2": //See videos

                        System.out.println(myUser.getVideos());

                        userOption = JOptionPane.showInputDialog("1:[Create Video]  2:[See My videos]  0:[Exit]");
                        break;

                    default:
                        System.out.println("Wrong input");
                }
            }
        }else {
            System.out.println("User not found or wrong password.");
        }
    }

    private static boolean Validate(String name, String surname, String password, List<User> users) {

        boolean isValid = false;

        for(User i : users){
            if ((i.getName()).equals(name) && ((i.getSurname()).equals(surname)) && ((i.getPassword()).equals(password))){
                isValid = true;
                break;
            }
        }
        return isValid;
    }

    private static User getValidUser(String name, String surname, String password, List<User> users) {

        User myUser = null;
        for(User i : users){

            if ((i.getName()).equals(name) && ((i.getSurname()).equals(surname)) && ((i.getPassword()).equals(password))){
                myUser = i;
                break;
            }
        }

        return myUser;
    }


    //Metodo que nos provoca una excepción cuando lo que introducimos está en blanco
    private static void checkInput(String string) throws Exception {

        if(string.isBlank()){

            throw new Exception();
        }
    }
}

