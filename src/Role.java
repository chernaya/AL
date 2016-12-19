/**
 * Created by User on 31.10.2016.
 */
public class Role {
    private int name;
    private String res;
    private int id;
    public Permission role;

    public int getName() {
        return name;
    }

    public String getRes() {
        return res;
    }

    public Role(int id,int name,  Permission role, String res) {

        this.name = name;
        this.res = res;
        this.id = id;
        this.role = role;
    }
}
