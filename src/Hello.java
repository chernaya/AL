import java.util.ArrayList;
import java.util.List;


public class Hello {
    public static void main(String[] args) {
        List<User> userList = new ArrayList<>();

        userList.add(new User(1, "ururur", "123", "new"));
        userList.add(new User(2, "urur", "123", "new"));

        List<Role> RoleList = new ArrayList<>();

        RoleList.add(new Role(1,"a",1,1));
        RoleList.add(new Role(2,"a",2,2));
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
        boolean result;
        for (final User user : userList) {
            if (user.login.equals(login)) {
                if (user.pass.equals(pass)) {
                    System.out.println("Success");
                } else {
                    System.exit(2);
                }
            }

        }

        //System.exit(1);
    }

    private static void Avtorizaition(String role, String res, List<Role> RoleList) {
        boolean roleExist = false;

        for(Permission permisson : Permission.values()) {
            String name = permisson.name();
            if(name.equals(role)){
                roleExist = true;
                System.out.println("EE ROL' SUSHESTVUET");
            }
        }

        if(!roleExist) {
            System.out.println("WRONG ROLE");
            System.exit(3);
        }


    }

}
