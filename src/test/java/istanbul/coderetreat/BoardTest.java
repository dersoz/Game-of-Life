package istanbul.coderetreat;

import istanbul.coderetreat.cells.Cell;
import istanbul.coderetreat.cells.CellFactory;
import org.junit.Before;
import org.junit.Test;

import static istanbul.coderetreat.TestRepository.cells3x3Neighbours;
import static istanbul.coderetreat.TestRepository.cells3x3Str;
import static org.junit.Assert.assertEquals;

/**
 * Created by dogan
 */
public class BoardTest {

    private Board board;

    @Before
    public void init() {
        board = new Board(cells3x3Str);
    }

    @Test
    public void shouldInitBoard() {
        assertEquals(cells3x3Str, board.toString());
    }

    @Test(expected = Exception.class)
    public void givenNullPassedBoardShouldNotInit() {
        Board b = new Board("x");
    }

    @Test
    public void shouldComputeNeighbours() {
        Board board = new Board(cells3x3Str);
        assertEquals(cells3x3Neighbours[0][0], board.getNumOfNeighbours(0, 0));
        assertEquals(cells3x3Neighbours[0][1], board.getNumOfNeighbours(0, 1));
        assertEquals(cells3x3Neighbours[0][2], board.getNumOfNeighbours(0, 2));
        assertEquals(cells3x3Neighbours[1][0], board.getNumOfNeighbours(1, 0));
        assertEquals(cells3x3Neighbours[1][1], board.getNumOfNeighbours(1, 1));
        assertEquals(cells3x3Neighbours[1][2], board.getNumOfNeighbours(1, 2));
        assertEquals(cells3x3Neighbours[2][0], board.getNumOfNeighbours(2, 0));
        assertEquals(cells3x3Neighbours[2][1], board.getNumOfNeighbours(2, 1));
        assertEquals(cells3x3Neighbours[2][2], board.getNumOfNeighbours(2, 2));
    }

    @Test
    public void shouldLoadFromString() {
        String cellStr = "[D D A]\n[A D A]\n[D D A]";
        Cell[][] cellsFromStr = CellFactory.cellsFromString(cellStr);
        Board board = new Board(cellsFromStr);
        assertEquals(cellStr, board.toString());
    }

}
