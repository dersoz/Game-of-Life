package dersoz.coderetreat.istanbul.gol.generate;

import dersoz.coderetreat.istanbul.gol.domain.Cell;
import org.junit.Test;

import static dersoz.coderetreat.istanbul.gol.generate.CellFactory.alive;
import static dersoz.coderetreat.istanbul.gol.generate.CellFactory.dead;
import static org.junit.Assert.assertArrayEquals;

/**
 * Created by dogan
 */
public class StrLoadingPopulatorTest {

    final String cells3x3Str = "[D A D]\n[D D D]\n[A A A]";

    final Cell[][] cells = new Cell[][]{
            {dead(), alive(), dead()},
            {dead(), dead(), dead()},
            {alive(), alive(), alive()}
    };

    @Test
    public void populate() throws Exception {
        Populator strLoadingPopulator = new StrLoadingPopulator(cells3x3Str);
        assertArrayEquals(cells, strLoadingPopulator.populate());
    }

}