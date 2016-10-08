/**
 * Created by user on 08.10.2016.
 */
public class user {
    public String login;
    public String pass;
    public String name;
    public int id;

    public user(int i, String l, String p, String n)
    {
        id=i;
        login=l;
        pass=p;
        name=n;
    }

    public String GetLogin(){return login;}
    public String GetPass(){return pass;}

}
