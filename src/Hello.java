import org.apache.commons.cli.*;

import java.util.ArrayList;
import java.util.List;


//пароль должен храниться безопасно(Сравните пароль пользователя)
//получать строку и превращать её в дату
//надо возвращать код 5 - некорректная активность (невалидная дата или объем)
/*

Добавьте еще три параметра значение, даты начала и конца
В приложении проверяйте что если количество параметров 7, то нужно не только аутентифицировать, авторизовать, но и аккаунтить
Научитесь парсить строку в число и обрабатывайте ошибку если это невозможно
Научитесь парсить строку в дату и обрабатывайте ошибку если это невозможно
Создайте класс который будет содержать потраченные ресурсы
Добавьте в приложение коллекцию которая будет содержать объекты из предыдущего пункта
В случае успеха добавляйте новую запись
Добавьте библиотеку apache-cli и перепишите работу с параметрами командной строки
Добавьте методы проверки пароля, которые будут добавлять соль, хэшировать и сравнивать полученный результат с паролем из объекта Пользователь
*/

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
        //String[] split = proba.res.split("[.]");
        //System.out.println(split[1]);

        if (proba.isEmpty()) {
            System.out.println("данные не введены!!");
            System.exit(0);
        } else if (proba.authorization()) {
            System.out.println("4 параметра есть можно авторизовать");
            //loginPass(proba.login, proba.pass, userList);
            Avtorizaition(proba.login, proba.pass, userList, proba.role, proba.res, RoleList);
        } else if (proba.authentification()) {
            System.out.println("2 параметра есть можно аутентифицировать");
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
                System.out.println("правильный логин");
                if (user.pass.equals(pass)) {
                    System.out.println("правильный пароль");
                    System.exit(0);
                } else {
                    System.out.println("неправильный пароль");
                    System.exit(2);
                }
            }

        }
        System.out.println("неправильный логин");
        System.exit(1);
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
                    System.out.println("ресурс не совпадает");
                    return false;
                }
            }
            System.out.println("ресурс совпадает");
            return true;
        } else {
            System.out.println("ресурс не совпадает");
            return false;
        }
    }

    private static void Avtorizaition(String login, String pass, List<User> userList, String role, String res, List<Role> RoleList) {
        boolean roleExist = false;
        for (final User user : userList) {
            if (user.login.equals(login)) {
                System.out.println("правильный логин");
                if (user.pass.equals(pass)) {
                    System.out.println("правильный пароль");
                    for (Permission permisson : Permission.values()) {
                        String name = permisson.name();
                        if (name.equals(role)) {
                            roleExist = true;
                            System.out.println("EE ROL' SUSHESTVUET");
                            for (final Role rees : RoleList) {
                                if (isChild(rees.getRes(), res)) {
                                    System.out.println("ресурс совпадает");
                                    System.exit(0);
                                } else {
                                    System.out.println("ресурс не совпадает");
                                    System.exit(4);
                                }

                            }

                            System.exit(0);
                        }
                    }

                    if (!roleExist) {
                        System.out.println("WRONG ROLE");
                        System.exit(3);
                    }

                } else {
                    System.out.println("неправильный пароль");
                    System.exit(2);
                }
            }

        }
        System.out.println("неправильный логин");
        System.exit(1);
    }

}
