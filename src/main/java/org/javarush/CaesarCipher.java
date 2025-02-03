package org.javarush;

import org.javarush.files.FileService;
import java.io.IOException;
public class CaesarCipher {
    public void encryptFile(String filePath, int key, FileService fileService) {
        try {
            String content = fileService.readFile(filePath);
            String encryptedContent = encrypt(content, key);
            fileService.writeFile(filePath.replace(".txt", "[ENCRYPTED].txt"), encryptedContent);
            System.out.println("Файл зашифровано.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void decryptFile(String filePath, int key, FileService fileService) {
        try {
            String content = fileService.readFile(filePath);
            String decryptedContent = decrypt(content, key);
            fileService.writeFile(filePath.replace(".txt", "[DECRYPTED].txt"), decryptedContent);
            System.out.println("Файл розшифровано.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void bruteForce(String filePath, FileService fileService) {
        try {
            String content = fileService.readFile(filePath);
            for (int key = 1; key <= 25; key++) {
                String decryptedContent = decrypt(content, key);
                fileService.writeFile(filePath.replace(".txt", "[DECRYPTED]_" + key + ".txt"), decryptedContent);
                System.out.println("Брутфорс: ключ " + key);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private String encrypt(String text, int key) {
        StringBuilder encrypted = new StringBuilder();
        for (char c : text.toCharArray()) {
            if (Character.isLetter(c)) {
                char base = Character.isLowerCase(c) ? 'a' : 'A';
                encrypted.append((char) ((c - base + key) % 26 + base));
            } else {
                encrypted.append(c);
            }
        }
        return encrypted.toString();
    }
    private String decrypt(String text, int key) {
        StringBuilder decrypted = new StringBuilder();
        for (char c : text.toCharArray()) {
            if (Character.isLetter(c)) {
                char base = Character.isLowerCase(c) ? 'a' : 'A';
                decrypted.append((char) ((c - base - key + 26) % 26 + base));
            } else {
                decrypted.append(c);
            }
        }
        return decrypted.toString();
    }
}