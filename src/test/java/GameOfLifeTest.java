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
    Integer[][] komsuSayisi = new Integer[][]{
            {1, 0, 1},
            {3, 4, 3},
            {1, 2, 1}
    };

    @Test
    public void shouldInitBoard() {
        Board board = new Board(rows, columns, cells);
        assertEquals(rows, board.getRows());
        assertEquals(columns, board.getColumns());
        assertArrayEquals(cells, board.state());
    }

    @Test
    public void shouldComputeNeighbours() {
        Board board = new Board(rows, columns, cells);
//        assertEquals(komsuSayisi[0][0], board.getNumOfNeighbours(0, 0));
//        assertEquals(komsuSayisi[0][1], board.getNumOfNeighbours(0, 1));
//        assertEquals(komsuSayisi[0][2], board.getNumOfNeighbours(0, 2));
//        assertEquals(komsuSayisi[1][0], board.getNumOfNeighbours(1, 0));
        assertEquals(komsuSayisi[1][1], board.getNumOfNeighbours(1, 1));
//        assertEquals(komsuSayisi[1][2], board.getNumOfNeighbours(1, 2));
//        assertEquals(komsuSayisi[2][0], board.getNumOfNeighbours(2, 0));
//        assertEquals(komsuSayisi[2][1], board.getNumOfNeighbours(2, 1));
//        assertEquals(komsuSayisi[2][2], board.getNumOfNeighbours(2, 2));
    }

    @Test
    public void aliveShouldEvolve() {
        Cell alive = new AliveCell();
        assertTrue(alive.evolve(2).isAlive());
        assertTrue(alive.evolve(3).isAlive());
        assertFalse(alive.evolve(4).isAlive());
    }

    @Test
    public void deadShouldEvolve() {
        Cell alive = new DeadCell();
        assertTrue(alive.evolve(3).isAlive());
        assertFalse(alive.evolve(4).isAlive());
    }

}
