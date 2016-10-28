package dersoz.coderetreat.istanbul.gol.generate;

import dersoz.coderetreat.istanbul.gol.domain.Cell;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Created by dogan
 */
public class RandomPopulatorTest {

    @Test
    public void populate() throws Exception {
        int rows = 5;
        int columns = 10;
        Populator randomPopulator = new RandomPopulator(rows, columns);
        Cell[][] cells = randomPopulator.populate();
        assertNotNull(cells);
        Arrays.stream(cells).forEach(Assert::assertNotNull);
        Arrays.stream(cells).forEach(row -> assertEquals(columns, row.length));
        Arrays.stream(cells).forEach(row -> Arrays.stream(row).forEach(Assert::assertNotNull));
        assertEquals(rows, cells.length);
        assertEquals(columns, cells[0].length);
    }

}