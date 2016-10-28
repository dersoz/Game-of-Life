package dersoz.coderetreat.istanbul.gol.generate;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CellFactoryTest {
    @Test
    public void cellFromString() throws Exception {
        assertEquals(CellFactory.alive(), CellFactory.cellFromString("A"));
        assertEquals(CellFactory.dead(), CellFactory.cellFromString("D"));
        assertEquals(CellFactory.dead(), CellFactory.cellFromString("X"));
    }

}