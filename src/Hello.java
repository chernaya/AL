import org.apache.commons.cli.*;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;


public class Hello {
    public static void main(String[] args) throws ParseException {
        // create Options object
        Options options = new Options();
        options.addOption("h", false, "вывести справку");
        options.addOption("login", true, "параметр логин");
        options.addOption("pass", true, "параметр пароль");

        CommandLineParser parser = new DefaultParser();
        CommandLine cmd = parser.parse( options, args);

        PolzVvod proba = new PolzVvod();


        if(cmd.hasOption("h")) {

            proba.h=true;

        }


        proba.login  = cmd.getOptionValue("login");
        proba.pass  = cmd.getOptionValue("pass");
        //proba.res  = cmd.getOptionValue("res");
        //proba.role= cmd.getOptionValue("role");



        List<User> userList = new ArrayList<>();

        userList.add(new User(1, "ururur", "123", "new"));
        userList.add(new User(2, "urur", "123", "new"));

        List<Role> RoleList = new ArrayList<>();

        RoleList.add(new Role(1, "a", 1, 1));
        RoleList.add(new Role(2, "a", 2, 2));



        if (args.length == 4) {
            String login = args[0];
            String pass = args[1];
            String role = args[2];
            String res = args[3];

            loginPass(login, pass, userList);
            Avtorizaition(role, res, RoleList);


        }

            if (args.length == 2) {

                String login = args[0];
                String pass = args[1];

                loginPass(login, pass, userList);


            } else {
                if (args.length == 1) {
                    System.out.println("пароль не введен!!!");
                } else {
                    System.out.println("данные не введены!!");
                }
            }

    }

    //Authentification
    private static void loginPass(String login, String pass, List<User> userList) {
    /*
    есть список пользователей с паролями.
            какой-либо пользователь вводит свои данные(логин и проль).
    нужно проверить их правдивость.
    проверяем если такой логин?
    если его нет то ошибка.
            если есть то проверяем его пароль.
            если нет то ошибка
    если есть то

            */
       // boolean result;
        for (final User user : userList) {
            if (user.login.equals(login)) {
                if (user.pass.equals(pass)) {
                   // System.out.println("Success");
                    System.exit(0);
                } else {
                    System.exit(2);
                }
            }

        }

        //System.exit(1);
    }

    private static void Avtorizaition(String role, String res, List<Role> RoleList) {
        boolean roleExist = false;

        for (Permission permisson : Permission.values()) {
            String name = permisson.name();
            if (name.equals(role)) {
                roleExist = true;
                System.out.println("EE ROL' SUSHESTVUET");
            }
        }

        if (!roleExist) {
            System.out.println("WRONG ROLE");
            System.exit(3);
        }


    }

}
