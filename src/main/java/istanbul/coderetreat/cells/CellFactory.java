package istanbul.coderetreat.cells;

/**
 * Created by dogan
 */
public final class CellFactory {

    private static final Cell ALIVE;
    private static final Cell DEAD;

    static {
        ALIVE = new AliveCell();
        DEAD = new DeadCell();
    }

    public static Cell alive() {
        return ALIVE;
    }

    public static Cell dead() {
        return DEAD;
    }

    public static Cell cellFromString(final String strRep) {
        return "A".equals(strRep.trim()) ? alive() : dead();
    }

    private CellFactory() {
    }
}
