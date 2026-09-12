package week1;

import java.util.*;

public class RockPaperScissors {

    static String playRound(String playerMove, String computerMove) {

        if (playerMove.equalsIgnoreCase(computerMove))
            return "Draw";

        if ((playerMove.equalsIgnoreCase("Rock") && computerMove.equals("Scissors")) ||
            (playerMove.equalsIgnoreCase("Paper") && computerMove.equals("Rock")) ||
            (playerMove.equalsIgnoreCase("Scissors") && computerMove.equals("Paper")))
            return "Player Wins";

        return "Computer Wins";
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String[] moves = {"Rock", "Paper", "Scissors"};

        int wins = 0, losses = 0, draws = 0;

        System.out.print("Enter number of rounds: ");
        int n = sc.nextInt();

        String[] player = new String[n];
        String[] computer = new String[n];
        String[] result = new String[n];

        for (int i = 0; i < n; i++) {

            System.out.print("Enter your move (Rock/Paper/Scissors): ");
            player[i] = sc.next();

            computer[i] = moves[(int)(Math.random() * 3)];

            result[i] = playRound(player[i], computer[i]);

            System.out.println("Computer: " + computer[i]);
            System.out.println(result[i]);

            if (result[i].equals("Player Wins"))
                wins++;
            else if (result[i].equals("Computer Wins"))
                losses++;
            else
                draws++;
        }

        System.out.println("\nRound\tPlayer\tComputer\tResult");

        for (int i = 0; i < n; i++) {
            System.out.println((i + 1) + "\t" + player[i] + "\t" +
                               computer[i] + "\t\t" + result[i]);
        }

        double winPercentage = (wins * 100.0) / n;

        System.out.println("\nWins: " + wins);
        System.out.println("Losses: " + losses);
        System.out.println("Draws: " + draws);
        System.out.println("Win Percentage: " + winPercentage + "%");
    }
}