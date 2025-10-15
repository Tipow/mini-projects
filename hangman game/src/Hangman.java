import java.util.ArrayList;
import java.util.Scanner;

public class Hangman {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String word = "pizza";

        ArrayList<Character> wordState = new ArrayList<>();
        int wrongGuesses = 0;

        for(int i = 0; i < word.length(); i++){
            wordState.add('_');
        }
        System.out.println("Welcome to Hangman Game");

        while(wrongGuesses < word.length()){
            System.out.println(getHangmanArt(wrongGuesses));

            for(char c : wordState ){
                System.out.print(c + " ");
            }
            System.out.println();

            System.out.print("Guess a letter: ");
            char guess = scanner.next().toLowerCase().charAt(0);

            if (word.indexOf(guess) >= 0){
                System.out.println("Correct guess!");
                for (int i = 0; i < word.length(); i++){
                    if (word.charAt(i) == guess){
                        wordState.set(i, guess);
                    }
                }
                if (!wordState.contains('_')){
                    System.out.print(getHangmanArt(wrongGuesses));
                    System.out.println("You win!");
                    System.out.println("The word was: " + word);
                    break;
                }
            } else {
                wrongGuesses++;
                System.out.println("Wrong guess!");
            }
        }
        if(wrongGuesses >= word.length()){
            System.out.println(getHangmanArt(6));
            System.out.println("Game Over!");
            System.out.println("The word was " + word);
        }

        scanner.close();
    }
    static String getHangmanArt(int wrongGuesses){
        return switch (wrongGuesses){
            case 0 -> """
                    
                      """;
            case 1 -> """
                      o
                      """;
            case 2 -> """
                       o
                       |
                      """;
            case 3 -> """
                       o
                      /|
                      """;
            case 4 -> """
                       o
                      /|\\
                      """;
            case 5-> """
                       o
                      /|\\
                      /
                      """;
            case 6 -> """
                       o
                      /|\\
                      / \\
                      """;
            default -> " ";
        };
    }
}
