package istanbul.coderetreat.cells;

/**
 * Created by dogan
 */
public class AliveCell implements Cell {

    @Override
    public Boolean isAlive() {
        return true;
    }

    @Override
    public String toString() {
        return "A";
    }

    AliveCell() {
    }
}
