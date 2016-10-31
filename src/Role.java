/**
 * Created by User on 31.10.2016.
 */
public class Role {
    private int name;
    private String res;
    private int id;
    private int user_id;

    public int getName() {
        return name;
    }

    public String getRes() {
        return res;
    }

    public Role(int name, String res, int id, int user_id) {

        this.name = name;
        this.res = res;
        this.id = id;
        this.user_id = user_id;
    }
}
