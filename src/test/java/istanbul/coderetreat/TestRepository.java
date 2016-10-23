package istanbul.coderetreat;

import istanbul.coderetreat.cells.Cell;

/**
 * Created by dogan
 */
public class TestRepository {

    public static final Cell[][] cells3x3 = new Cell[][]{
            {Cell.dead(), Cell.alive(), Cell.dead()},
            {Cell.dead(), Cell.dead(), Cell.dead()},
            {Cell.alive(), Cell.alive(), Cell.alive()}
    };

    public static final Cell[][] cells3x3Gen1 = new Cell[][]{
            {Cell.dead(), Cell.dead(), Cell.dead()},
            {Cell.alive(), Cell.dead(), Cell.alive()},
            {Cell.dead(), Cell.alive(), Cell.dead()}
    };

    public static final Cell[][] cells3x3Gen2 = new Cell[][]{
            {Cell.dead(), Cell.dead(), Cell.dead()},
            {Cell.dead(), Cell.alive(), Cell.dead()},
            {Cell.dead(), Cell.alive(), Cell.dead()},
    };

    private TestRepository() {
    }

}
