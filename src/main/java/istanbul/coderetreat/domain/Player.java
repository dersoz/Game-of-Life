package istanbul.coderetreat.domain;

import istanbul.coderetreat.rules.RuleBook;

/**
 * Player who is responsible to make the moves
 * Created by dogan
 */
public class Player {

    private RuleBook ruleBook;
    private Board board;

    public Player(Board board, RuleBook ruleBook) {
        this.board = board;
        this.ruleBook = ruleBook;
    }

    public Player nextGen(int numOfGenerations) {
        for (int i = 0; i < numOfGenerations; i++)
            next();
        return this;
    }

    public Board last() {
        return board.clone();
    }

    private Player next() {
        Cell[][] state = board.state();
        int rows = state.length;
        int columns = state[0].length;
        Cell[][] nextGen = new Cell[rows][columns];
        for (int i = 0; i < columns; i++) {
            for (int j = 0; j < rows; j++) {
                Integer neighbourCount = board.getNumOfNeighbours(j, i);
                Cell currentCell = state[j][i];
                Cell nextCell = ruleBook.lookup(currentCell, neighbourCount);
                nextGen[j][i] = nextCell;
            }
        }
        board.setCells(nextGen);
        return this;
    }

}
