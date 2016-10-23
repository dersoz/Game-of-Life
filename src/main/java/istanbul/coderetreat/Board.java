package istanbul.coderetreat;

/**
 * Created by dogan
 */
public class Board {
    private Integer rows;
    private Integer columns;

    private Cell[][] cells;

    public Board(Integer rows, Integer columns, Cell[][] cells) {
        this.rows = rows;
        this.columns = columns;
        this.cells = copyState(cells);
    }

    public static Cell[][] copyState(Cell[][] cells) {
        Cell[][] copiedCells = new Cell[cells.length][cells[0].length];
        for (int i = 0; i < cells.length; i++)
            System.arraycopy(cells[i], 0, copiedCells[i], 0, cells[0].length);
        return copiedCells;
    }

    public Cell[][] state() {
        return copyState(this.cells);
    }

    public Integer getNumOfNeighbours(Integer rowIndex, Integer columnIndex) {
        Integer count = 0;
        for (Integer i = columnIndex - 1; i <= columnIndex + 1; i++) {
            if (i < 0 || i.equals(columns)) // Skip beyond boundary
                continue;
            for (Integer j = rowIndex - 1; j <= rowIndex + 1; j++) {
                if (j < 0 || j.equals(rows))  // Skip beyond boundary
                    continue;
                count += cells[j][i].count();
            }
        }
        count -= cells[rowIndex][columnIndex].count(); // Subtract itself
        return count;
    }

}
