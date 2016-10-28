package dersoz.coderetreat.istanbul.gol.domain;

public class DeadCell implements Cell {

    public DeadCell() {
    }

    @Override
    public Boolean isAlive() {
        return false;
    }

    @Override
    public String toString() {
        return "D";
    }

}
