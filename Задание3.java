package Main;

import java.util.Random;
import java.util.Scanner;

public class Задание3 
{

    private static final String ZAGLAV = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String STROCHN = "abcdefghijklmnopqrstuvwxyz";
    private static final String CIFRI = "0123456789";
    private static final String SPECIAL = "!@#$%^&*()-_=+<>?";
    private static final String ALL_CHARACTERS = ZAGLAV + STROCHN + CIFRI + SPECIAL;

    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите желаемую длину пароля (от 8 до 12 символов):");
        int passwordLength = scanner.nextInt();
        if (passwordLength < 8 || passwordLength > 12)
        {
            System.out.println("Ошибка: Длина пароля должна быть от 8 до 12 символов.");
        } 
        else 
        {
            String password = generatePassword(passwordLength);
            System.out.println("Сгенерированный пароль: " + password);
        }
        
        scanner.close();
    }

    private static String generatePassword(int length) 
    {
        Random random = new Random();
        StringBuilder password = new StringBuilder();

        password.append(ZAGLAV.charAt(random.nextInt(ZAGLAV.length())));
        password.append(STROCHN.charAt(random.nextInt(STROCHN.length())));
        password.append(CIFRI.charAt(random.nextInt(CIFRI.length())));
        password.append(SPECIAL.charAt(random.nextInt(SPECIAL.length())));

        for (int i = 4; i < length; i++)
        {
            password.append(ALL_CHARACTERS.charAt(random.nextInt(ALL_CHARACTERS.length())));
        }
        
        return shuffleString(password.toString());
    }

    private static String shuffleString(String input) 
    {
        char[] characters = input.toCharArray();
        Random random = new Random();
        for (int i = 0; i < characters.length; i++) 
        {
            int randomIndex = random.nextInt(characters.length);
            
            char temp = characters[i];
            characters[i] = characters[randomIndex];
            characters[randomIndex] = temp;
        }
        return new String(characters);
    }
}
