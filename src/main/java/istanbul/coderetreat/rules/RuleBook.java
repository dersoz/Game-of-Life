package istanbul.coderetreat.rules;

import istanbul.coderetreat.domain.Cell;

/**
 * Created by dogan
 */
public interface RuleBook {
    Cell lookup(Cell cell, Integer numOfNeighbours);
}
