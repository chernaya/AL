import java.util.ArrayList;
import java.util.List;


public class Hello {
    public static void main(String[] args) {
        // System.out.println(args[1]);
        /*
        проблема!
        !
        1 аргументов нет
           ??? необходимо присвоить 2 аргументам значения стоит ли??????
            и выводить ошибку: данные не введены
        2 один аргумент
           ????? необходимо
            выводить ошибку: пароль отсутствует
        3 2 аргумента
            проблемы нет
         */
        if (args.length == 2) {

            String login = args[0];
            String pass = args[1];

            List<User> userList = new ArrayList<>();

            userList.add(new User(1, "ururur", "123", "new"));
            userList.add(new User(2, "urur", "123", "new"));
            //System.out.println(p.login);
            loginPass(login, pass, userList);

        } else {
            if (args.length == 1) {
                System.out.println("пароль не введен!!!");
            } else {
                System.out.println("данные не введены!!");
            }
        }
    }


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
        boolean result;
        for (final User user : userList) {
            if (user.login.equals(login)) {
                if (user.pass.equals(pass)) {
                    System.exit(0);
                } else {
                    System.exit(2);
                }
            }

        }

        System.exit(1);
    }

}
