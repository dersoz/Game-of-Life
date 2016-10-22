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
        this.cells = copy2dArray(cells);
    }

    public static Cell[][] copy2dArray(Cell[][] cells) {
        Cell[][] copiedCells = new Cell[cells.length][cells[0].length];
        for (int i = 0; i < cells.length; i++)
            System.arraycopy(cells[i], 0, copiedCells[i], 0, cells[0].length);
        return copiedCells;
    }

    public Integer getRows() {
        return rows;
    }

    public Integer getColumns() {
        return columns;
    }

    public Cell[][] state() {
        return copy2dArray(this.cells);
    }

    public Integer getNumOfNeighbours(Integer rowIndex, Integer columnIndex) {
        Integer count = 0;
        for (Integer i = columnIndex - 1; i <= columnIndex + 1; i++) {
            for (Integer j = rowIndex - 1; j <= rowIndex + 1; j++) {
                if (cells[j][i].isAlive())
                    count++;
            }
        }
        if (cells[rowIndex][columnIndex].isAlive())
            count--;
        return count;
    }


}
