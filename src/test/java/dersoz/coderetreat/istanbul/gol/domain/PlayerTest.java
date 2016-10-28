package dersoz.coderetreat.istanbul.gol.domain;

import dersoz.coderetreat.istanbul.gol.generate.RandomPopulator;
import dersoz.coderetreat.istanbul.gol.generate.StrLoadingPopulator;
import dersoz.coderetreat.istanbul.gol.rules.GOLRuleBook;
import dersoz.coderetreat.istanbul.gol.rules.RuleBook;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

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
        board = new Board(new StrLoadingPopulator(TestRepository.cells3x3Str));
        player = new Player(board, ruleBook);

        Assert.assertEquals(TestRepository.cells3x3Gen1Str, player.nextGen(1).last().toString());
        Assert.assertEquals(TestRepository.cells3x3Gen2Str, player.nextGen(1).last().toString());
        // ALL dead
        Assert.assertEquals(TestRepository.cells3x3Gen3Str, player.nextGen(1).last().toString());
        // Dead will stay dead
        Assert.assertEquals(TestRepository.cells3x3Gen3Str, player.nextGen(1).last().toString());
    }

    @Test
    public void shoulEvolveMultipleGenerations() {
        board = new Board(new StrLoadingPopulator(TestRepository.cells3x3Str));
        player = new Player(board, ruleBook);

        Assert.assertEquals(TestRepository.cells3x3Gen3Str, player.nextGen(3).last().toString());
    }

    @Test
    public void shouldEvolve5x4() {
        board = new Board(new StrLoadingPopulator(TestRepository.cells5x4Str));
        player = new Player(board, ruleBook);

        Assert.assertEquals(TestRepository.cells5x4Gen1Str, player.nextGen(1).last().toString());
    }

    @Test
    public void shouldPlayRandomly() {
        int rows = 10;
        int columns = 20;
        Board gameWorld = new Board(new RandomPopulator(rows, columns));
        Player gamer = new Player(gameWorld, new GOLRuleBook());
        assertEquals(gameWorld, gamer.last());
        System.out.print(gamer.last());
    }

}