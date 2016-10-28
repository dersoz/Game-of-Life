package dersoz.coderetreat.istanbul.gol.domain;

public class AliveCell implements Cell {

    public AliveCell() {
    }

    @Override
    public Boolean isAlive() {
        return true;
    }

    @Override
    public String toString() {
        return "A";
    }
}
