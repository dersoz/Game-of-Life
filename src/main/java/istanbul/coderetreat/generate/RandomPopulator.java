package istanbul.coderetreat.generate;

import istanbul.coderetreat.domain.Cell;

import java.security.SecureRandom;

/**
 * Created by dogan
 */
public class RandomPopulator implements Populator {
    private final int rows;
    private final int columns;
    private final SecureRandom random;

    public RandomPopulator(int rows, int columns) {
        this.rows = rows;
        this.columns = columns;
        random = new SecureRandom();
    }

    @Override
    public Cell[][] populate() {
        Cell[][] cells = new Cell[rows][columns];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                cells[i][j] = random.nextBoolean() ? CellFactory.alive() : CellFactory.dead();
            }
        }
        return cells;
    }
}
