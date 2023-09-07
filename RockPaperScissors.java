import java.util.Scanner;

public class RockPaperScissors {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int playerScore = 0;
        int computerScore = 0;

        while (true) {
            System.out.println("Enter your choice (rock, paper, or scissors):");
            String playerSelection = scanner.nextLine().toLowerCase();

            if (playerSelection.equals("rock") || playerSelection.equals("paper") || playerSelection.equals("scissors")) {
                String computerSelection = getRandomSelection();
                System.out.println("Computer selected: " + computerSelection);

                String result = playRound(playerSelection, computerSelection);
                System.out.println("Result: " + result);

                if (result.equals("win")) {
                    playerScore++;
                } else if (result.equals("lose")) {
                    computerScore++;
                }

                System.out.println("Player Score: " + playerScore);
                System.out.println("Computer Score: " + computerScore);
            } else {
                System.out.println("Invalid input. Please try again.");
            }

            System.out.println("Do you want to play again? (yes/no)");
            String playAgain = scanner.nextLine().toLowerCase();

            if (!playAgain.equals("yes")) {
                break;
            }
        }

        scanner.close();
        System.out.println("Thank you for playing!");
    }

    private static String getRandomSelection() {
        String[] options = {"rock", "paper", "scissors"};
        int randomIndex = (int) (Math.random() * options.length);
        return options[randomIndex];
    }

    private static String playRound(String playerSelection, String computerSelection) {
        if (playerSelection.equals(computerSelection)) {
            return "draw";
        } else if (
            (playerSelection.equals("rock") && computerSelection.equals("scissors")) ||
            (playerSelection.equals("paper") && computerSelection.equals("rock")) ||
            (playerSelection.equals("scissors") && computerSelection.equals("paper"))
        ) {
            return "win";
        } else {
            return "lose";
        }
    }
} {
    
}
