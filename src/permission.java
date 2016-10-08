/**
 * Created by user on 08.10.2016.
 */
public enum permission {

    READ (1),
    WRITE(2),
    EXECUTE(4);

    private int value;
    permission (int value)
    {this.value=value;}

    public int code(){return value;}
}
