package dersoz.coderetreat.istanbul.gol.rules;

import dersoz.coderetreat.istanbul.gol.domain.Cell;

public interface RuleBook {
    Cell lookup(Cell cell, Integer numOfNeighbours);
}
