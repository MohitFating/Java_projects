import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class QuizQuestion {
    private String question;
    private Map<String, Boolean> options;

    public QuizQuestion(String question, Map<String, Boolean> options) {
        this.question = question;
        this.options = options;
    }

    public String getQuestion() {
        return question;
    }

    public Map<String, Boolean> getOptions() {
        return options;
    }
}

class QuizGame {
    private Map<QuizQuestion, String> quizQuestions;
    private int score;

    public QuizGame() {
        quizQuestions = new HashMap<>();
        score = 0;
    }

    public void addQuestion(QuizQuestion question, String correctOption) {
        quizQuestions.put(question, correctOption);
    }

    public void startGame() {
        Scanner scanner = new Scanner(System.in);

        for (QuizQuestion question : quizQuestions.keySet()) {
            System.out.println(question.getQuestion());
            Map<String, Boolean> options = question.getOptions();
            int optionIndex = 1;
            for (String option : options.keySet()) {
                System.out.println(optionIndex + ". " + option);
                optionIndex++;
            }

            int userAnswer = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character after reading the integer.

            if (userAnswer > 0 && userAnswer <= options.size()) {
                String selectedOption = (String) options.keySet().toArray()[userAnswer - 1];
                if (options.get(selectedOption)) {
                    System.out.println("Correct!");
                    score++;
                } else {
                    System.out.println("Wrong!");
                }
            } else {
                System.out.println("Invalid option. Skipping question...");
            }

            System.out.println("---------------------");
        }

        System.out.println("Quiz Completed!");
        System.out.println("Your score: " + score + " out of " + quizQuestions.size());
    }
}

public class QuizGameApp {
    public static void main(String[] args) {
        QuizGame quizGame = new QuizGame();
        Scanner scanner = new Scanner(System.in);

        QuizQuestion question1 = new QuizQuestion("What is the capital of India?", createOptions("Dheli", "Mumbai", "Bengluru"), 1);
        QuizQuestion question2 = new QuizQuestion("Which planet is closest to the sun?", createOptions("Venus", "Mars", "Mercury"), 3);
        QuizQuestion question3 = new QuizQuestion("What is 5 + 7?", createOptions("10", "11", "12"), 3);

        quizGame.addQuestion(question1, "Dheli");
        quizGame.addQuestion(question2, "Mercury");
        quizGame.addQuestion(question3, "12");

        System.out.println("Welcome to the Quiz Game!");
        System.out.println("Answer the following questions:");

        quizGame.startGame();

        scanner.close();
    }

    private static Map<String, Boolean> createOptions(String... options) {
        Map<String, Boolean> optionsMap = new HashMap<>();
        for (String option : options) {
            optionsMap.put(option, false);
        }
        optionsMap.put(options[options.length - 1], true); // Mark the last option as correct.
        return optionsMap;
    }
}
