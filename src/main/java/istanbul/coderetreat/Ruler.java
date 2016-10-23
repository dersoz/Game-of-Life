package istanbul.coderetreat;

import java.util.HashMap;
import java.util.Map;

/**
 * C   N                 new C
 * 1   0,1             ->  0  # Lonely
 * 1   4,5,6,7,8       ->  0  # Overcrowded
 * 1   2,3             ->  1  # Lives
 * 0   3               ->  1  # It takes three to give birth!
 * 0   0,1,2,4,5,6,7,8 ->  0  # Barren
 * <p>
 * Created by dogan
 */
public class Ruler {
    private static final Map<Cell, Map<Integer, Cell>> ruleMap = new HashMap<>();

    static {
        Map<Integer, Cell> aliveRules = new HashMap<>();
        aliveRules.put(0, DeadCell.INSTANCE);
        aliveRules.put(1, DeadCell.INSTANCE);
        aliveRules.put(2, AliveCell.INSTANCE);
        aliveRules.put(3, AliveCell.INSTANCE);
        aliveRules.put(4, DeadCell.INSTANCE);
        aliveRules.put(5, DeadCell.INSTANCE);
        aliveRules.put(6, DeadCell.INSTANCE);
        aliveRules.put(7, DeadCell.INSTANCE);
        aliveRules.put(8, DeadCell.INSTANCE);
        Map<Integer, Cell> deadRules = new HashMap<>();
        deadRules.put(0, DeadCell.INSTANCE);
        deadRules.put(1, DeadCell.INSTANCE);
        deadRules.put(2, DeadCell.INSTANCE);
        deadRules.put(3, AliveCell.INSTANCE);
        deadRules.put(4, DeadCell.INSTANCE);
        deadRules.put(5, DeadCell.INSTANCE);
        deadRules.put(6, DeadCell.INSTANCE);
        deadRules.put(7, DeadCell.INSTANCE);
        deadRules.put(8, DeadCell.INSTANCE);
        ruleMap.put(AliveCell.INSTANCE, aliveRules);
        ruleMap.put(DeadCell.INSTANCE, deadRules);
    }

    public static Cell evolve(Cell cell, Integer numOfNeighbours) {
        return ruleMap.get(cell).get(numOfNeighbours);
    }

    private Ruler() {
    }

}
