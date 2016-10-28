package dersoz.coderetreat.istanbul.gol;

import dersoz.coderetreat.istanbul.gol.domain.Board;
import dersoz.coderetreat.istanbul.gol.domain.Player;
import dersoz.coderetreat.istanbul.gol.generate.RandomPopulator;
import dersoz.coderetreat.istanbul.gol.rules.GOLRuleBook;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter number of rows : ");
        int rows = scanner.nextInt();
        System.out.println("Enter number of columns : ");
        int columns = scanner.nextInt();
        System.out.println("Enter number of generations : ");
        int generations = scanner.nextInt();
        Player player = new Player(new Board(new RandomPopulator(rows, columns)), new GOLRuleBook());
        System.out.println("Initial cells are:\n" + player.last());
        player.nextGen(generations);
        System.out.println("After playing :\n" + player.last());
    }
}
