package istanbul.coderetreat.domain;

import istanbul.coderetreat.domain.exception.InvalidCellsException;
import istanbul.coderetreat.generate.Populator;

import java.util.Arrays;

import static java.util.stream.Collectors.joining;

/**
 * Created by dogan
 */
public class Board implements Cloneable {
    private Integer rows;
    private Integer columns;

    private Cell[][] cells;

    public Board(Populator populator) {
        this(populator.populate());
    }

    private Board(Cell[][] cells) {
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
                count += decideToCount(cells[j][i]);
            }
        }
        count -= decideToCount(cells[rowIndex][columnIndex]); // Subtract itself
        return count;
    }

    private Integer decideToCount(Cell cell) {
        return cell.isAlive() ? 1 : 0;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Board board = (Board) o;

        if (!rows.equals(board.rows)) return false;
        if (!columns.equals(board.columns)) return false;
        return Arrays.deepEquals(cells, board.cells);

    }

    @Override
    public int hashCode() {
        int result = rows.hashCode();
        result = 31 * result + columns.hashCode();
        result = 31 * result + Arrays.deepHashCode(cells);
        return result;
    }

}

