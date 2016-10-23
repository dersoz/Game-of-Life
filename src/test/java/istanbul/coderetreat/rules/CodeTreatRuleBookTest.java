package istanbul.coderetreat.rules;

import istanbul.coderetreat.cells.AliveCell;
import istanbul.coderetreat.cells.Cell;
import istanbul.coderetreat.cells.DeadCell;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created by dogan
 */
public class CodeTreatRuleBookTest {

    private RuleBook ruleBook;

    @Before
    public void init() {
        ruleBook = new CodeTreatRuleBook();
    }

    @Test
    public void aliveShouldEvolve() {
        Cell cell = AliveCell.INSTANCE;
        assertTrue(ruleBook.lookup(cell, 2).isAlive());
        assertTrue(ruleBook.lookup(cell, 3).isAlive());
        assertFalse(ruleBook.lookup(cell, 4).isAlive());
    }

    @Test
    public void deadShouldEvolve() {
        Cell cell = DeadCell.INSTANCE;
        assertTrue(ruleBook.lookup(cell, 3).isAlive());
        assertFalse(ruleBook.lookup(cell, 4).isAlive());
    }


}