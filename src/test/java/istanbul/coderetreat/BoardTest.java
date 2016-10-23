package istanbul.coderetreat;

import istanbul.coderetreat.cells.Cell;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

/**
 * Created by dogan
 */
public class BoardTest {

    private Board board;

    private Cell[][] cells = new Cell[][]{
            {Cell.dead(), Cell.alive(), Cell.dead()},
            {Cell.dead(), Cell.dead(), Cell.dead()},
            {Cell.alive(), Cell.alive(), Cell.alive()}
    };

    private Integer[][] neighbourCounts = new Integer[][]{
            {1, 0, 1},
            {3, 4, 3},
            {1, 2, 1}
    };

    @Before
    public void init() {
        board = new Board(cells);
    }

    @Test
    public void shouldInitBoard() {
        assertArrayEquals(cells, board.state());
    }

    @Test
    public void shouldComputeNeighbours() {
        Board board = new Board(cells);
        assertEquals(neighbourCounts[0][0], board.getNumOfNeighbours(0, 0));
        assertEquals(neighbourCounts[0][1], board.getNumOfNeighbours(0, 1));
        assertEquals(neighbourCounts[0][2], board.getNumOfNeighbours(0, 2));
        assertEquals(neighbourCounts[1][0], board.getNumOfNeighbours(1, 0));
        assertEquals(neighbourCounts[1][1], board.getNumOfNeighbours(1, 1));
        assertEquals(neighbourCounts[1][2], board.getNumOfNeighbours(1, 2));
        assertEquals(neighbourCounts[2][0], board.getNumOfNeighbours(2, 0));
        assertEquals(neighbourCounts[2][1], board.getNumOfNeighbours(2, 1));
        assertEquals(neighbourCounts[2][2], board.getNumOfNeighbours(2, 2));
    }

}