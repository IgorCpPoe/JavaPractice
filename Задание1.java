package Main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Задание1
{
    private static final int MAX_LIVES = 6;
    private static final List<String> WORDS = Arrays.asList("ПЕРЕМЕННАЯ", "ЦИКЛ", "ФУНКЦИЯ", "МАССИВ", "КЛАСС", "РЕКУРСИЯ");

    public static void main(String[] args) 
    {
        String wordToGuess = getRandomWord();
        char[] guessedWord = new char[wordToGuess.length()];
        Arrays.fill(guessedWord, '_');
        int lives = MAX_LIVES;
        List<Character> guessedLetters = new ArrayList<>();

        Scanner scanner = new Scanner(System.in);
        System.out.println("Добро пожаловать в игру Виселица!");

        while (lives > 0 && new String(guessedWord).contains("_")) 
        {
            System.out.print("\nТекущее слово: ");
            System.out.println(guessedWord);
            System.out.println("Оставшиеся жизни: " + lives);
            System.out.print("Введите букву: ");
            char guess = scanner.nextLine().toUpperCase().charAt(0);

            if (guessedLetters.contains(guess)) 
            {
                System.out.println("Вы уже вводили эту букву. Попробуйте другую.");
                continue;
            }

            guessedLetters.add(guess);
            if (wordToGuess.contains(String.valueOf(guess)))
            {
                updateGuessedWord(guessedWord, wordToGuess, guess);
            } 
            else 
            {
                lives--;
                System.out.println("Буква " + guess + " отсутствует. Потеряна одна жизнь.");
            }
        }

        if (lives > 0) 
        {
            System.out.println("\nПоздравляем! Вы угадали слово: " + wordToGuess);
        } 
        else 
        {
            System.out.println("\nВы проиграли! Загаданное слово было: " + wordToGuess);
        }

        scanner.close();
    }

    private static String getRandomWord()
    {
        Random random = new Random();
        return WORDS.get(random.nextInt(WORDS.size()));
    }

    private static void updateGuessedWord(char[] guessedWord, String wordToGuess, char guess) 
    {
        for (int i = 0; i < wordToGuess.length(); i++) {
            if (wordToGuess.charAt(i) == guess) 
            {
            	
                guessedWord[i] = guess;
            }
        }
    }
}
