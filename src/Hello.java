import org.apache.commons.cli.*;
import org.apache.commons.cli.ParseException;

import java.security.NoSuchAlgorithmException;
import java.text.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class Hello {
    public static void main(String[] args) throws ParseException, java.text.ParseException, NoSuchAlgorithmException {
        Options options = new Options();
        options.addOption("h", false, "вывести справку");
        options.addOption("login", true, "параметр логин");
        options.addOption("pass", true, "параметр пароль");
        options.addOption("role", true, "параметр роль");
        options.addOption("res", true, "параметр ресурс");
        options.addOption("ds", true, "параметр начало даты");
        options.addOption("de", true, "параметр конец даты");
        options.addOption("a", true, "параметр значение");

        CommandLineParser parser = new DefaultParser();
        CommandLine cmd = parser.parse(options, args);

        PolzVvod proba = new PolzVvod();


        if (cmd.hasOption("h")) {

            proba.h = true;

        }


        proba.login = cmd.getOptionValue("login");
        proba.pass = cmd.getOptionValue("pass");
        proba.res = cmd.getOptionValue("res");
        proba.ds = cmd.getOptionValue("ds");
        proba.de = cmd.getOptionValue("de");
        proba.a = cmd.getOptionValue("a");
        proba.role = cmd.getOptionValue("role");


        List<User> userList = new ArrayList<>();

        userList.add(new User(1, "John Doe", "jdoe", "sup3rpaZZ"));
        userList.add(new User(2, "Jane Row", "jrow", "Qweqrty12"));

        List<Role> RoleList = new ArrayList<>();

        RoleList.add(new Role(1, 1, Permission.READ, "a"));
        RoleList.add(new Role(2, 1, Permission.WRITE, "a.b"));
        RoleList.add(new Role(1, 2, Permission.EXECUTE, "a.b.c"));
        RoleList.add(new Role(2, 1, Permission.EXECUTE, "a.bc"));

        List<Accouting> AccountList = new ArrayList<>();


        if (proba.isEmpty()) {
            System.out.println("данные не введены!!");
            System.exit(0);
        } else if (proba.accounting()) {
            System.out.println("7 параметров есть можно аккаунтить");
            accounting(proba.login, proba.pass, userList, proba.role, proba.res, RoleList, AccountList, proba.a, proba.de, proba.ds);
            AccountList.add(new Accouting(proba.a, proba.ds, proba.de));
            System.exit(0);

        } else if (proba.authorization()) {
            System.out.println("4 параметра есть можно авторизовать");
            avtorization(proba.login, proba.pass, userList, proba.role, proba.res, RoleList);
            System.exit(0);
        } else if (proba.authentification()) {
            System.out.println("2 параметра есть можно аутентифицировать");
            loginPass(proba.login, proba.pass, userList);
            System.exit(0);
        }

    }


    //Authentification
    private static void loginPass(String login, String pass, List<User> userList) throws NoSuchAlgorithmException {
        int flag = 0;
        User tempUser = null;
        for (final User user : userList) {
            if (user.login.equals(login)) {
                System.out.println("правильный логин");
                flag = 1;
                tempUser = user;
                String passCheck = ForPass.getHash(ForPass.getHash(pass) + tempUser.getSalt());
                if (user.pass.equals(passCheck)) {
                    System.out.println("правильный пароль");
                    //System.exit(0);
                } else {
                    System.out.println("неправильный пароль");
                    System.exit(2);
                }
            }
        }

        if (flag == 0) {
            System.out.println("неправильный логин");
            System.exit(1);
        }
    }

    private static boolean isChild(String parent, String child) {
        String[] sp = parent.split("[.]");
        String[] sc = child.split("[.]");
        int lp = sp.length;
        int lc = sc.length;
        if (lc >= lp) {
            System.out.println("длина потомка >= длины родителя");
            for (int i = 0; i < lp; i++) {
                if (!sp[i].equals(sc[i])) {
                    //System.out.println("ресурс не совпадает");
                    return false;
                }
            }
            //System.out.println("ресурс совпадает");
            return true;
        } else {
            //System.out.println("ресурс не совпадает");
            return false;
        }
    }

    private static void avtorization(String login, String pass, List<User> userList, String role, String res, List<Role> RoleList) throws NoSuchAlgorithmException {
        boolean roleExist = false;
        int flag = 0;
        loginPass(login, pass, userList);
        for (Permission permisson : Permission.values()) {
            String name = permisson.name();
            if (name.equals(role)) {
                roleExist = true;
                System.out.println("роль существует");
                for (final Role rees : RoleList) {

                    if (isChild(rees.getRes(), res)) {
                        System.out.println("ресурс совпадает");
                        flag = 1;
                    }

                }
                if (flag == 0) {
                    System.out.println("ресурс не совпадает");
                    System.exit(4);
                }

            }
        }

        if (!roleExist) {
            System.out.println("роль не существует");
            System.exit(3);
        }
    }

    private static void accounting(String login, String pass, List<User> userList, String role, String res, List<Role> RoleList, List<Accouting> AccountList, String a, String de, String ds) throws NoSuchAlgorithmException {
        avtorization(login, pass, userList, role, res, RoleList);//
        float f3 = 0;
        try {
            f3 = Float.parseFloat(a);
        } catch (NumberFormatException e) {
            System.out.println("некорректная активность (невалидная дата или объем)");
            System.exit(5);
        }

        DateFormat formatter;
        Date date2;
        formatter = new SimpleDateFormat("yyyy-MM-dd");
        formatter.setLenient(false);
        try {
            date2 = formatter.parse(ds);
            System.out.println("start");
            System.out.println(date2);
        } catch (java.text.ParseException e) {
            System.out.println("некорректная активность (невалидная дата или объем)");
            System.exit(5);
        }

        DateFormat formatter1;
        Date date;
        formatter1 = new SimpleDateFormat("yyyy-MM-dd");
        formatter1.setLenient(false);
        try {
            date = formatter1.parse(de);
            System.out.println("end");
            System.out.println(date);
        } catch (java.text.ParseException e) {
            System.out.println("некорректная активность (невалидная дата или объем)");
            System.exit(5);
        }

    }

}