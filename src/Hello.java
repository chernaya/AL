import java.util.ArrayList;
import java.util.List;


public class Hello {
    public static void main(String[] args) {
        System.out.println(args[1]);
        String login = args[0];
        String pass = args[1];

        List<User> userList = new ArrayList<>();

        userList.add(new User(1, "ururur", "123", "new"));
        userList.add(new User(2, "urur", "123", "new"));
        //System.out.println(p.login);
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
        for (int i = 0; i < userList.size(); i++) {
            final User user = userList.get(i);
            if (user.login.equals(login)) {
                if (user.pass.equals(pass)) {
                    System.exit(0);
                }
                else
                {
                    System.exit(2);
                }
            }

        }

        System.exit(1);

    }


}
