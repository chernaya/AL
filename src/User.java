/**
 * Created by user on 08.10.2016.
 */
public class User {
    public String login;
    public String pass;

    public String name;
    public int id;

    public User(int i, String l, String n, String p)
    {
        id=i;
        login=l;
        pass=p;
        name=n;
    }

    public String GetLogin(){return login;}
    public String GetPass(){return pass;}

}
