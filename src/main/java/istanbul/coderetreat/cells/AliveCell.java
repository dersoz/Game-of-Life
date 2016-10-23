package istanbul.coderetreat.cells;

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

    @Override
    public String toString() {
        return "A";
    }

    private AliveCell() {
    }
}
