package istanbul.coderetreat;

/**
 * Created by dogan
 */
public class AliveCell implements Cell {

    public static final Cell INSTANCE;

    static {
        INSTANCE = new AliveCell();
    }

    @Override
    public Boolean isAlive() {
        return true;
    }

    private AliveCell() {
    }
}
