import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Created by user on 01.10.2016.
 */
public class Hello {
    public static void main(String[] args) {
        System.out.println(args[1]);
        String login = args[0];
        String pass = args[1];

        List<User> userList = new ArrayList<>();

        userList.add(new User(1, "ururur", "123", "new"));
        userList.add(new User(2, "urur", "123", "new"));
        //System.out.println(p.login);
        for (int i = 0; i < userList.size(); i++) {
            final User user = userList.get(i);
            if (user.login.equals(login)&&user.pass.equals(pass)) {
                System.out.println("lalal");
            }

        }
        System.exit(1);

    }
}
