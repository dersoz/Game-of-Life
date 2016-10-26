package istanbul.coderetreat;

import istanbul.coderetreat.cells.Cell;
import istanbul.coderetreat.cells.CellFactory;

import java.util.Arrays;

import static java.util.stream.Collectors.joining;

/**
 * Created by dogan
 */
public class Board implements Cloneable {
    private Integer rows;
    private Integer columns;

    private Cell[][] cells;

    public Board(String cellsStr) {
        initCells(CellFactory.cellsFromString(cellsStr));
        this.rows = this.cells.length;
        this.columns = this.cells[0].length;
    }

    public Board(Cell[][] cells) {
        initCells(cells);
        this.rows = this.cells.length;
        this.columns = this.cells[0].length;
    }

    @Override
    public Board clone() {
        return new Board(cloneCells(this.cells));
    }

    public void setCells(Cell[][] cells) {
        initCells(cells);
    }

    private void initCells(Cell[][] cells) {
        if (cells == null)
            throw new InvalidCellsException("NULL passed to cells");
        this.cells = cloneCells(cells);
    }

    private static Cell[][] cloneCells(Cell[][] cells) {
        Cell[][] copiedCells = new Cell[cells.length][cells[0].length];
        for (int i = 0; i < cells.length; i++)
            System.arraycopy(cells[i], 0, copiedCells[i], 0, cells[0].length);
        return copiedCells;
    }

    public Cell[][] state() {
        return cloneCells(this.cells);
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

    @Override
    public String toString() {
        return Arrays.stream(cells)
                .map(row -> "[" + Arrays.stream(row)
                        .map(Object::toString)
                        .collect(joining(" ")) + "]"
                )
                .collect(joining("\n"));
    }

}

