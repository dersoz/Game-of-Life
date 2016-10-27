package istanbul.coderetreat.rules;

import istanbul.coderetreat.domain.Cell;

import java.util.HashMap;
import java.util.Map;

import static istanbul.coderetreat.generate.CellFactory.alive;
import static istanbul.coderetreat.generate.CellFactory.dead;

/**
 * <p>
 * C   N                 new C
 * 1   0,1             ->  0  # Lonely
 * 1   4,5,6,7,8       ->  0  # Overcrowded
 * 1   2,3             ->  1  # Lives
 * 0   3               ->  1  # It takes three to give birth!
 * 0   0,1,2,4,5,6,7,8 ->  0  # Barren
 * </p>
 * Created by dogan
 */
public final class GOLRuleBook implements RuleBook {

    private static final Map<Cell, Map<Integer, Cell>> RULES = new HashMap<>();

    static {
        Map<Integer, Cell> aliveRules = new HashMap<>();
        aliveRules.put(0, dead());
        aliveRules.put(1, dead());
        aliveRules.put(2, alive());
        aliveRules.put(3, alive());
        aliveRules.put(4, dead());
        aliveRules.put(5, dead());
        aliveRules.put(6, dead());
        aliveRules.put(7, dead());
        aliveRules.put(8, dead());
        Map<Integer, Cell> deadRules = new HashMap<>();
        deadRules.put(0, dead());
        deadRules.put(1, dead());
        deadRules.put(2, dead());
        deadRules.put(3, alive());
        deadRules.put(4, dead());
        deadRules.put(5, dead());
        deadRules.put(6, dead());
        deadRules.put(7, dead());
        deadRules.put(8, dead());
        RULES.put(alive(), aliveRules);
        RULES.put(dead(), deadRules);
    }

    @Override
    public Cell lookup(Cell cell, Integer numOfNeighbours) {
        return RULES.get(cell).get(numOfNeighbours);
    }

}
