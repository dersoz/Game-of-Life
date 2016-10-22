/**
 * Created by dogan
 */
public interface Cell {

    Boolean isAlive();

    Cell evolve(Integer neighbourCount);

    static Cell alive() {
        return AliveCell.INSTANCE;
    }

    static Cell dead() {
        return DeadCell.INSTANCE;
    }

}
