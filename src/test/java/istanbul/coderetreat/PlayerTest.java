package istanbul.coderetreat;

import istanbul.coderetreat.rules.CodeTreatRuleBook;
import istanbul.coderetreat.rules.RuleBook;
import org.junit.Before;
import org.junit.Test;

import static istanbul.coderetreat.TestRepository.*;
import static org.junit.Assert.assertArrayEquals;

/**
 * Created by dogan
 */
public class PlayerTest {

    private Player player;
    private Board board;
    private RuleBook ruleBook;

    @Before
    public void init() {
        ruleBook = new CodeTreatRuleBook();
        board = new Board(cells3x3);
        player = new Player(board, ruleBook);
    }

    @Test
    public void shouldEvolveNextGen() {
        assertArrayEquals(cells3x3Gen1, player.nextGen().board().state());
        assertArrayEquals(cells3x3Gen2, player.nextGen().board().state());
    }

}