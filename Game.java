import java.util.Scanner;

public class Game {
    private final Scanner input = new Scanner(System.in);

    private int correctGuesses = 0;

    public void play() {
        int gamesPlayed = 0;
        boolean playAgain;

        System.out.println("#### Hign Low Predection Card Game ####");
        do {
            keepPlayingUntillIncorrectGuess();
            gamesPlayed++;
            playAgain = askUserToPlayAgain();
        } while (playAgain);

        double averageScore = ((double) correctGuesses) / gamesPlayed;
        System.out.println();
        System.out.println("You played " + gamesPlayed + " game.");
        System.out.printf("Your average score was %1.3f.\n", averageScore);
    }

    public void keepPlayingUntillIncorrectGuess() {
        Deck deck = new Deck();
        deck.Shuffle();

        Card currentCard = deck.dealCard();
        Card nextCard;
        System.out.println("The first card is: " + currentCard);

        boolean keepPlaying = true;
        while (keepPlaying) {
            char guess = askForUserInput();
            nextCard = deck.dealCard();
            System.out.println("The next card is " + nextCard);

            if (nextCard.getValues() == currentCard.getValues()) {
                System.out.println("The value is the same as the previous card.");
                System.out.println("You lose on ties. Sorry!");
                keepPlaying = false;
            } else if (nextCard.getValues() > currentCard.getValues()) {
                if (guess == 'H') {
                    System.out.println("Your guess was correct.");
                    correctGuesses++;
                } else {
                    System.out.println("Your guess was incorrect.");
                    keepPlaying = false;
                }
            } else {
                if (guess == 'L') {
                    System.out.println("Your guess was correct.");
                    correctGuesses++;
                } else {
                    System.out.println("Your guess was incorrect.");
                    keepPlaying = false;
                }
            }

            currentCard = nextCard;
            System.out.println();
            System.out.println("The Game Over! ");
            System.out.println("You Made " + correctGuesses + " Correct Guess");
            System.out.println();
        }
    }

    private boolean askUserToPlayAgain() {
        System.out.println("Want to play again? if, please type YES, otherwise type exit ");

        return input.nextLine().toUpperCase().contains("YES");
    }

    private char askForUserInput() {
        System.out.println("Will the next line be higher (H) or lower (L): ");
        char guess;
        do {
            guess = input.nextLine().toUpperCase().charAt(0);
            if (guess != 'H' && guess != 'L') {
                System.out.println("Please type 'H' or 'L': ");
            }
        } while (guess != 'H' && guess != 'L');

        return guess;
    }
}
