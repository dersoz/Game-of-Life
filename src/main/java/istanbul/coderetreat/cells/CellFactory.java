package istanbul.coderetreat.cells;

import java.util.Arrays;
import java.util.stream.Collectors;

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

    public static Cell[][] cellsFromString(final String strRep) {
        // TODO: Validate input
        String[] rows = strRep.split("\\n");
        int rowNum = rows.length;
        int columns = getSplittedRow(rows[0]).length;
        return fillCells(rows, rowNum, columns);
    }

    private static Cell[][] fillCells(String[] rows, int rowNum, int columns) {
        Cell[][] cells = new Cell[rowNum][columns];
        for (int i = 0; i < rowNum; i++) {
            Cell[] cellsInRow = Arrays
                    .stream(getSplittedRow(rows[i]))
                    .map(CellFactory::cellFromString)
                    .collect(Collectors.toList())
                    .toArray(new Cell[columns]);
            cells[i] = cellsInRow;
        }
        return cells;
    }

    private static String[] getSplittedRow(String row) {
        return row.substring(1, row.length() - 1).trim().split("\\s+");
    }

    private CellFactory() {
    }
}
