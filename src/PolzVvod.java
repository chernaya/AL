/**
 * Created by student on 03.11.16.
 */
public class PolzVvod {
    boolean h;
    String login;
    String pass;
    String res;
    String role;

    boolean authentification() {
        return login != null && pass != null;
    }


    boolean authorization() {
        return authentification() && res != null && role != null;
    }
}