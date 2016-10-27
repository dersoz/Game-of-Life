package istanbul.coderetreat.domain;

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

    public DeadCell() {
    }

}
