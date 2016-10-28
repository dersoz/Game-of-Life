package dersoz.coderetreat.istanbul.gol.generate;

import dersoz.coderetreat.istanbul.gol.domain.AliveCell;
import dersoz.coderetreat.istanbul.gol.domain.Cell;
import dersoz.coderetreat.istanbul.gol.domain.DeadCell;

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
