import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

public class GuessNumber {
    Scanner scanner = new Scanner(System.in);
    Random random = new Random();
    String userCommand;
    int userNumber;
    int min;
    int max;
    int randomValue;
    int numOfAttempts;
    int attempt = 0;


    public void hello () throws IOException {
        System.out.println("Привет, я хочу поиграть с тобой!\n" +
                "Я загадаю число, От-/ и До-/ выбираешь сам.\n" +
                "И выберешь себе количество попыток\n" +
                "Начнем!\n");

        System.out.println("Выбери минимальное число:");
        min = scanner.nextInt();
        if (min < 1) {
            System.out.println("Давай начнем хотя бы с 1");
            min = scanner.nextInt();
        }

        System.out.println("Выбери максимальное число:");
        max = scanner.nextInt();
        if (max > 200) {
            System.out.println("Не так много, 200 достаточно");
            max = scanner.nextInt();
        }
        if (max < min) {
            System.out.println("Серьезно? Попробуй сделать минимальное число меньше максимального?");
            max = scanner.nextInt();
        }

        System.out.println("Выбери количество попыток:");
        numOfAttempts = scanner.nextInt();
        if (numOfAttempts <= 1) {
            System.out.println("Давай начнем хотя бы с 1");
            numOfAttempts = scanner.nextInt();
        }
        if (numOfAttempts >= 15) {
            System.out.println("Не так много, 15 достаточно");
            numOfAttempts = scanner.nextInt();
        }
}


    public void guessNumber () throws IOException {
        randomValue = random.nextInt((max - min) + min);
        System.out.println("Вводи своё число:");
        userNumber = scanner.nextInt();

        while (attempt < numOfAttempts) {
            try {
                String answerStr = scanner.nextLine();
                if (answerStr.equalsIgnoreCase("Выход")) {
                    exit();
                } else if (randomValue > userNumber) {
                    System.out.println("Мое число побольше твоего будет ;)");
                } else if (randomValue < userNumber) {
                    System.out.println("Мое число поменьше твоего будет ;)");
                } else {
                    System.out.println("Поздравляю, ты победил!");
                    System.exit(0);
                }
                attempt++;
            } catch (NumberFormatException e) {
                System.out.println("Число необходимо вводить в рамках заданных параметров!");
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
            if (attempt >= numOfAttempts) {
                System.out.println("Твои попытки закончились. Ты проиграл :(");
            }
        }
    }


    public void exit() throws IOException {
        System.out.println("Уже сдался? Да или Нет?");
        userCommand = scanner.nextLine();
        switch (userCommand) {
            case "Да":
                System.out.println("Хе-хе-хе");
                System.exit(0);
                break;
            case "Нет":
                System.out.println("Начнем заново!");
                hello();
                break;
            default:
                System.out.println("Моя игра, мои правила!");
                exit();
                break;
        }
    }
}

