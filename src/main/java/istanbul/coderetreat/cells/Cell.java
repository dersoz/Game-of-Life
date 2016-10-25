package istanbul.coderetreat.cells;

/**
 * Created by dogan
 */
public interface Cell {

    Boolean isAlive();

    default Integer count() {
        return isAlive() ? 1 : 0;
    }

}
