import java.security.NoSuchAlgorithmException;

/**
 * Created by user on 08.10.2016.
 */
public class User {
    public String login;
    public String pass;
    private String salt;

    public String name;
    public int id;

    public User(int i, String n, String l, String p) throws NoSuchAlgorithmException {
        id=i;
        login=l;
        salt = ForPass.makeSalt();
        pass = ForPass.getHash(ForPass.getHash(p) + salt);
        name=n;
    }
    public String getSalt() { return salt; }




    public String GetLogin(){return login;}
    public String GetPass(){return pass;}

}
