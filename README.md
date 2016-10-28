#Conway's Game of Life
An object oriented - and a bit complicated :)- approach to famous Game of Life.

After attending a Code Retreat in Istanbul, I decided to take an object oriented approach to the solution of problem.

The classes and responsibilities
- RuleBook - Main interface for game rules
  - GOLRuleBook - Regular Game of Life rules implementing RuleBook
- Cell - An interface for a living organism :) Which lives or dies according to the rules in rulebook. A cell can answer are you alive question.
  - AliveCell - Represents a living cell
  - DeadCell - Represents a dead cell
- Board - The game world. Holds all the cells, and their locations. Can tell each cells number of neighbours.
- Player - The player of the game. Player is just responsible for generation change of the board.
- CellFactory - Responsible for cell creation (Gives the same instance for all the alive cells, and gives the same instance for all the dead cells)
- Populator - Cell generators
  - StrLoadingPopulator - Load initial cells from new line delimited string such as ```[A D A]\n[D D D]```
  - RandomPopulator - Given number of rows and number of columns randomly generate cells
- Main - Main class. Number of rows, number of columns and number of generations are collected from user

# Idioms
- The cells are placed in the board in a matrix like 2d array. 
- Flyweight pattern is applied to the representation of individual cells.
- Cells are represented in string as 'A' and 'D'
- Cell generation is implemented as Strategy Pattern with the use of 'Populator' interface
