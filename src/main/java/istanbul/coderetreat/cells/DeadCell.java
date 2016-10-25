package istanbul.coderetreat.cells;

/**
 * Created by dogan
 */
public class DeadCell implements Cell {

    @Override
    public Boolean isAlive() {
        return false;
    }

    @Override
    public String toString() {
        return "D";
    }

    DeadCell() {
    }

}
