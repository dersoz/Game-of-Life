package dersoz.coderetreat.istanbul.gol.domain;

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

    public AliveCell() {
    }
}
