package dersoz.coderetreat.istanbul.gol.generate;

import dersoz.coderetreat.istanbul.gol.domain.Cell;

import java.util.Arrays;
import java.util.stream.Collectors;

public class StrLoadingPopulator implements Populator {

    private final String strRep;

    public StrLoadingPopulator(final String strRep) {
        this.strRep = strRep;
    }

    @Override
    public Cell[][] populate() {
        return cellsFromString(strRep);
    }

    private Cell[][] cellsFromString(final String strRep) {
        String[] rows = strRep.split("\\n");
        int rowNum = rows.length;
        int columns = getSplittedRow(rows[0]).length;
        return fillCells(rows, rowNum, columns);
    }

    private String[] getSplittedRow(String row) {
        return row.substring(1, row.length() - 1).trim().split("\\s+");
    }

    private Cell[][] fillCells(String[] rows, int rowNum, int columns) {
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

}
