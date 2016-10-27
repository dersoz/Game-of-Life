package istanbul.coderetreat;

import istanbul.coderetreat.domain.Board;
import istanbul.coderetreat.domain.Player;
import istanbul.coderetreat.generate.RandomPopulator;
import istanbul.coderetreat.rules.GOLRuleBook;

import java.util.Scanner;

/**
 * Created by dogan
 */
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
