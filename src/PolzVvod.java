/**
 * Created by student on 03.11.16.
 */
public class PolzVvod {
    boolean h;
    String login;
    String pass;
    String res;
    String role;
    String ds;
    String de;
    String a;

    boolean authentification() {
        return login != null && pass != null;
    }


    boolean authorization() {
        return authentification() && res != null && role != null;
    }

    boolean isEmpty(){
        return !authentification();}// && !authorization());}


    boolean accounting() {return authorization() && ds != null && de != null && a != null; }
}