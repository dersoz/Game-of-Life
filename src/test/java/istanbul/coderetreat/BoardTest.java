package istanbul.coderetreat;

import istanbul.coderetreat.domain.Board;
import istanbul.coderetreat.domain.Cell;
import istanbul.coderetreat.generate.RandomPopulator;
import istanbul.coderetreat.generate.StrLoadingPopulator;
import org.junit.Before;
import org.junit.Test;

import static istanbul.coderetreat.TestRepository.cells3x3Neighbours;
import static istanbul.coderetreat.TestRepository.cells3x3Str;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Created by dogan
 */
public class BoardTest {

    private Board board;

    @Before
    public void init() {
        board = new Board(new StrLoadingPopulator(cells3x3Str));
    }

    @Test
    public void shouldInitBoard() {
        assertEquals(cells3x3Str, board.toString());
    }

    @Test(expected = Exception.class)
    public void givenNullPassedBoardShouldNotInit() {
        Board b = new Board(null);
    }

    @Test
    public void shouldComputeNeighbours() {
        Board board = new Board(new StrLoadingPopulator(cells3x3Str));
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
        Board board = new Board(new StrLoadingPopulator(cellStr));
        assertEquals(cellStr, board.toString());
    }

    @Test
    public void shouldGenerateRandomCells() {
        int rows = 10;
        int columns = 15;
        Board board = new Board(new RandomPopulator(rows, columns));
        Cell[][] state = board.state();
        assertNotNull(state);
        assertEquals(rows, state.length);
        assertEquals(columns, state[0].length);
    }

}
