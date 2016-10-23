package istanbul.coderetreat.cells;

/**
 * Created by dogan
 */
public class DeadCell implements Cell {

    public static final Cell INSTANCE;

    static {
        INSTANCE = new DeadCell();
    }

    @Override
    public Boolean isAlive() {
        return false;
    }

    @Override
    public String toString() {
        return "D";
    }

    private DeadCell() {
    }

}
