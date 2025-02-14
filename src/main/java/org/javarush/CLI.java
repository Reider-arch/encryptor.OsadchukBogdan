package org.javarush;

import org.javarush.files.FileService;
import java.util.Scanner;
public class CLI {
    private CaesarCipher cipher = new CaesarCipher();
    private FileService fileService = new FileService();
    private Scanner scanner = new Scanner(System.in);
    public void start() {
        System.out.println("Ласкаво просимо до CLI!");
        while (true) {
            System.out.println("\nВиберіть команду:");
            System.out.println("1. ENCRYPT");
            System.out.println("2. DECRYPT");
            System.out.println("3. BRUTE_FORCE");
            System.out.println("4. Вихід");
            String command = scanner.nextLine().trim().toUpperCase();
            if (command.equals("4")) {
                System.out.println("Вихід з програми...");
                break;
            }

            switch (command) {
                case "1":
                    encrypt();
                    break;
                case "2":
                    decrypt();
                    break;
                case "3":
                    bruteForce();
                    break;
                default:
                    System.out.println("Невідома команда. Спробуйте ще раз.");
                    break;
            }
        }
    }
    private void encrypt() {
        System.out.print("Введіть шлях до файлу для шифрування: ");
        String filePath = scanner.nextLine();
        System.out.print("Введіть ключ шифрування (ціле число): ");
        int key = Integer.parseInt(scanner.nextLine());
        cipher.encryptFile(filePath, key, fileService);
    }
    private void decrypt() {
        System.out.print("Введіть шлях до файлу для дешифрування: ");
        String filePath = scanner.nextLine();
        System.out.print("Введіть ключ дешифрування (ціле число): ");
        int key = Integer.parseInt(scanner.nextLine());
        cipher.decryptFile(filePath, key, fileService);
    }
    private void bruteForce() {
        System.out.print("Введіть шлях до файлу для брутфорсу: ");
        String filePath = scanner.nextLine();
        cipher.bruteForce(filePath, fileService);
    }
}
