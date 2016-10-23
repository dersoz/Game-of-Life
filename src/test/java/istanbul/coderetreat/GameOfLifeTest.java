package istanbul.coderetreat;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by dogan
 */
public class GameOfLifeTest {

    Integer rows = 3;
    Integer columns = 3;

    Cell[][] cells = new Cell[][]{
            {Cell.dead(), Cell.alive(), Cell.dead()},
            {Cell.dead(), Cell.dead(), Cell.dead()},
            {Cell.alive(), Cell.alive(), Cell.alive()}
    };

    Integer[][] neigborCounts = new Integer[][]{
            {1, 0, 1},
            {3, 4, 3},
            {1, 2, 1}
    };

    @Test
    public void shouldInitBoard() {
        Board board = new Board(rows, columns, cells);
        assertArrayEquals(cells, board.state());
    }

    @Test
    public void shouldComputeNeighbours() {
        Board board = new Board(rows, columns, cells);
        assertEquals(neigborCounts[0][0], board.getNumOfNeighbours(0, 0));
        assertEquals(neigborCounts[0][1], board.getNumOfNeighbours(0, 1));
        assertEquals(neigborCounts[0][2], board.getNumOfNeighbours(0, 2));
        assertEquals(neigborCounts[1][0], board.getNumOfNeighbours(1, 0));
        assertEquals(neigborCounts[1][1], board.getNumOfNeighbours(1, 1));
        assertEquals(neigborCounts[1][2], board.getNumOfNeighbours(1, 2));
        assertEquals(neigborCounts[2][0], board.getNumOfNeighbours(2, 0));
        assertEquals(neigborCounts[2][1], board.getNumOfNeighbours(2, 1));
        assertEquals(neigborCounts[2][2], board.getNumOfNeighbours(2, 2));
    }

    @Test
    public void aliveShouldEvolve() {
        Cell cell = AliveCell.INSTANCE;
        assertTrue(Ruler.evolve(cell, 2).isAlive());
        assertTrue(Ruler.evolve(cell, 3).isAlive());
        assertFalse(Ruler.evolve(cell, 4).isAlive());
    }

    @Test
    public void deadShouldEvolve() {
        Cell cell = DeadCell.INSTANCE;
        assertTrue(Ruler.evolve(cell, 3).isAlive());
        assertFalse(Ruler.evolve(cell, 4).isAlive());
    }

}
