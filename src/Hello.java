import org.apache.commons.cli.*;

import java.util.ArrayList;
import java.util.List;


public class Hello {
    public static void main(String[] args) throws ParseException {
        // create Options object
        Options options = new Options();
        options.addOption("h", false, "вывести справку");
        options.addOption("login", true, "параметр логин");
        options.addOption("pass", true, "параметр пароль");
        options.addOption("role", true, "параметр роль");
        options.addOption("res", true, "параметр ресурс");

        CommandLineParser parser = new DefaultParser();
        CommandLine cmd = parser.parse(options, args);

        PolzVvod proba = new PolzVvod();


        if (cmd.hasOption("h")) {

            proba.h = true;

        }


        proba.login = cmd.getOptionValue("login");
        proba.pass = cmd.getOptionValue("pass");
        proba.res = cmd.getOptionValue("res");
        proba.role = cmd.getOptionValue("role");


        List<User> userList = new ArrayList<>();///

        userList.add(new User(1, "John Doe", "jdoe", "sup3rpaZZ"));
        userList.add(new User(2, "Jane Row", "jrow", "Qweqrty12"));

        List<Role> RoleList = new ArrayList<>();

        RoleList.add(new Role(1, 1, Permission.READ, "a"));
        RoleList.add(new Role(2, 1, Permission.WRITE, "a.b"));
        RoleList.add(new Role(1, 2, Permission.EXECUTE, "a.b.c"));
        RoleList.add(new Role(2, 1, Permission.EXECUTE, "a.bc"));


        if (proba.isEmpty()) {
            System.out.println("данные не введены!!");
            System.exit(0);
        } else if (proba.authorization()) {

            //loginPass(proba.login, proba.pass, userList);
            Avtorizaition(proba.login, proba.pass, userList, proba.role, proba.res, RoleList);
        } else if (proba.authentification()) {

            loginPass(proba.login, proba.pass, userList);
        }

    }

/*
    1 если пусто то выходим и пока
    2 если если логин пароль и роль и ресурс то авторизация
    3 если если логин пароль тоаутентификация

*/


    //Authentification
    private static void loginPass(String login, String pass, List<User> userList) {

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

        System.exit(1);
    }

    private static void Avtorizaition(String login, String pass, List<User> userList, String role, String res, List<Role> RoleList) {
        boolean roleExist = false;
        for (final User user : userList) {
            if (user.login.equals(login)) {

                if (user.pass.equals(pass)) {
        for (Permission permisson : Permission.values()) {
            String name = permisson.name();
            if (name.equals(role)) {
                roleExist = true;
                System.out.println("EE ROL' SUSHESTVUET");
                System.exit(0);
            }
        }

        if (!roleExist) {
            System.out.println("WRONG ROLE");
            System.exit(3);
        }

                } else {
                    System.exit(2);
                }
            }

        }

        System.exit(1);
    }

}
