package istanbul.coderetreat;

import istanbul.coderetreat.populate.RandomPopulator;
import istanbul.coderetreat.populate.StrLoadingPopulator;
import istanbul.coderetreat.rules.GOLRuleBook;
import istanbul.coderetreat.rules.RuleBook;
import org.junit.Before;
import org.junit.Test;

import static istanbul.coderetreat.TestRepository.*;
import static org.junit.Assert.assertEquals;

/**
 * Created by dogan
 */
public class PlayerTest {

    private Player player;
    private Board board;
    private RuleBook ruleBook;

    @Before
    public void init() {
        ruleBook = new GOLRuleBook();
    }

    @Test
    public void shouldEvolveNextGen() {
        board = new Board(new StrLoadingPopulator(cells3x3Str));
        player = new Player(board, ruleBook);

        assertEquals(cells3x3Gen1Str, player.nextGen(1).last().toString());
        assertEquals(cells3x3Gen2Str, player.nextGen(1).last().toString());
        // ALL dead
        assertEquals(cells3x3Gen3Str, player.nextGen(1).last().toString());
        // Dead will stay dead
        assertEquals(cells3x3Gen3Str, player.nextGen(1).last().toString());
    }

    @Test
    public void shoulEvolveMultipleGenerations() {
        board = new Board(new StrLoadingPopulator(cells3x3Str));
        player = new Player(board, ruleBook);

        assertEquals(cells3x3Gen3Str, player.nextGen(3).last().toString());
    }

    @Test
    public void shouldEvolve5x4() {
        board = new Board(new StrLoadingPopulator(cells5x4Str));
        player = new Player(board, ruleBook);

        assertEquals(cells5x4Gen1Str, player.nextGen(1).last().toString());
    }

    @Test
    public void shouldPlayRandomly() {
        int rows = 10;
        int columns = 20;
        Board gameWorld = new Board(new RandomPopulator(rows, columns));
        Player gamer = new Player(gameWorld, new GOLRuleBook());
        assertEquals(gameWorld, gamer.last());
    }

}