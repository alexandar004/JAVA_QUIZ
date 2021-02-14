import java.io.File;
import java.io.FileNotFoundException;
import java.util.Objects;
import java.util.Scanner;

public class QuizGame {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Please enter number 1 - 3 for chosen topic");
        printTopics();
        int chosenTopic = input.nextInt();
        choseTopic(chosenTopic);
    }

    public static void printTopics() {
        String[] topics = {"1.Programing", "2.Mathe", "3.History"};
        for (int i = 0; i < topics.length; i++) {
            System.out.println(topics[i]);
        }
    }

    public static void printQuestions(String filePath) {

        try {
            File myObj = new File(filePath);
            Scanner myReader = new Scanner(myObj);
            Scanner input = new Scanner(System.in);

            int score = 0;
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();

                if (data != null && !data.trim().isEmpty()) {
                    String answer = data.substring(0, 1);
                    String question = data.substring(1);

                    System.out.println(question);

                    for (int i = 0; i < 4; i++) {
                        System.out.println(myReader.nextLine());
                    }

                    var choiceAnswer = input.next();

                    if (Objects.equals(choiceAnswer, answer)) {
                        score++;
                        System.out.println("Correct answer");
                    } else {
                        System.out.println("Wrong answer");
                        score--;
                    }
                    System.out.println(score);
                }
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred");
            e.printStackTrace();
        }
    }

    public static void choseTopic(int chosenNumber) {
        switch (chosenNumber) {
            case 1:
                var programingFilePath = "D:\\homeworkJava\\Programing.txt";
                printQuestions(programingFilePath);
                break;
            case 2:
                var mathFilePath = "D:\\homeworkJava\\Math.txt";
                printQuestions(mathFilePath);
                break;
            case 3:
                var historyFilePath = "D:\\homeworkJava\\History.txt";
                printQuestions(historyFilePath);
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + chosenNumber);
        }
    }
}