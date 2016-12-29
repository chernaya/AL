
public class Role {
    private int name;
    private String res;
    private int id;
    public permission role;

    public int getName() {
        return name;
    }

    public String getRes() {
        return res;
    }

    public Role(int id, int name, permission role, String res) {

        this.name = name;
        this.res = res;
        this.id = id;
        this.role = role;
    }
}
