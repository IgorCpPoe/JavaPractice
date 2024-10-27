package Main;

import java.util.Scanner;

public class Задание2 
{

    private static final double RUB_TO_USD = 0.010;
    private static final double RUB_TO_EUR = 0.009;
    private static final double RUB_TO_GBP = 0.0079;
    private static final double RUB_TO_JPY = 1.57;
    private static final double RUB_TO_CNY = 0.074;

    public static void main(String[] args) 
    {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите сумму в RUB для конвертации:");
        double amountInRUB = scanner.nextDouble();

        System.out.println("\nВыберите валюту для конвертации:");
        System.out.println("1 - USD (Доллар США)");
        System.out.println("2 - EUR (Евро)");
        System.out.println("3 - GBP (Фунт стерлингов)");
        System.out.println("4 - JPY (Японская иена)");
        System.out.println("5 - CNY (Китайский юань)");

        int choice = scanner.nextInt();

        switch (choice)
        {
            case 1:
                System.out.printf("Сумма в USD: %.2f\n", convert(amountInRUB, RUB_TO_USD));
                break;
            case 2:
                System.out.printf("Сумма в EUR: %.2f\n", convert(amountInRUB, RUB_TO_EUR));
                break;
            case 3:
                System.out.printf("Сумма в GBP: %.2f\n", convert(amountInRUB, RUB_TO_GBP));
                break;
            case 4:
                System.out.printf("Сумма в JPY: %.2f\n", convert(amountInRUB, RUB_TO_JPY));
                break;
            case 5:
                System.out.printf("Сумма в CNY: %.2f\n", convert(amountInRUB, RUB_TO_CNY));
                break;
            default:
                System.out.println("Неверный выбор. Попробуйте снова.");
        }

        scanner.close();
    }

    private static double convert(double amount, double exchangeRate) 
    {
        return amount * exchangeRate;
    }
}
