package istanbul.coderetreat;

/**
 * Created by dogan
 */
public interface Cell {

    Boolean isAlive();

    default Integer count() {
        return isAlive() ? 1 : 0;
    }

    static Cell alive() {
        return AliveCell.INSTANCE;
    }

    static Cell dead() {
        return DeadCell.INSTANCE;
    }

}
