package istanbul.coderetreat.rules;

import istanbul.coderetreat.domain.Cell;
import istanbul.coderetreat.generate.CellFactory;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created by dogan
 */
public class GOLRuleBookTest {

    private RuleBook ruleBook;

    @Before
    public void init() {
        ruleBook = new GOLRuleBook();
    }

    @Test
    public void aliveShouldEvolve() {
        Cell cell = CellFactory.alive();
        assertTrue(ruleBook.lookup(cell, 2).isAlive());
        assertTrue(ruleBook.lookup(cell, 3).isAlive());
        assertFalse(ruleBook.lookup(cell, 4).isAlive());
    }

    @Test
    public void deadShouldEvolve() {
        Cell cell = CellFactory.dead();
        assertTrue(ruleBook.lookup(cell, 3).isAlive());
        assertFalse(ruleBook.lookup(cell, 4).isAlive());
    }


}