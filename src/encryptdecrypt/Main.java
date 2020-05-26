package encryptdecrypt;

import encryptdecrypt.decryption.Decrypter;
import encryptdecrypt.decryption.ShiftDecryption;
import encryptdecrypt.decryption.UnicodeDecryption;
import encryptdecrypt.encryption.Encrypter;
import encryptdecrypt.encryption.ShiftEncryption;
import encryptdecrypt.encryption.UnicodeEncryption;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static boolean isRunning = true;
    public static Mode currentMode = Mode.ENCRYPT;
    public static Type currentType = Type.SHIFT;
    public static int key = 0;
    public static Map<String, String> dataInAndOut = new HashMap<>();
    public static String data;

    public static void main(String[] args) {
        int numberOfArgs = args.length;
        int index = 0;
        while (isRunning && index < numberOfArgs) {
            int nextIndex = index + 1;
            switch (args[index]) {
                case "-mode":
                    if ("enc".equals(args[nextIndex])) {
                        currentMode = Mode.ENCRYPT;
                    } else if ("dec".equals(args[nextIndex])) {
                        currentMode = Mode.DECRYPT;
                    } else {
                        System.out.println("Error: invalid mode.");
                        isRunning = false;
                    }
                    index += 1;
                    break;
                case "-key":
                    try {
                        key = Integer.parseInt(args[nextIndex]);
                    } catch (NumberFormatException e) {
                        System.out.println("Error: number format exception occurs.");
                        isRunning = false;
                    }
                    index += 1;
                    break;
                case "-alg":
                    if ("shift".equals(args[nextIndex])) {
                        currentType = Type.SHIFT;
                    } else if ("unicode".equals(args[nextIndex])) {
                        currentType = Type.UNICODE;
                    } else {
                        System.out.println("Error: invalid algorithm.");
                        isRunning = false;
                    }
                    index += 1;
                    break;
                case "-data":
                    if (args[nextIndex] != null) {
                        dataInAndOut.put("data", args[nextIndex]);
                    } else {
                        System.out.println("Error: invalid data.");
                        isRunning = false;
                    }
                    index += 1;
                    break;
                case "-in":
                    if (args[nextIndex] != null) {
                        dataInAndOut.put("in", readMessageFromFileName(args[nextIndex]));
                    } else {
                        System.out.println("Error: invalid import file.");
                        isRunning = false;
                    }
                    index += 1;
                    break;
                case "-out":
                    if (args[nextIndex] != null) {
                        dataInAndOut.put("out", args[nextIndex]);
                    } else {
                        System.out.println("Error: invalid export file.");
                        isRunning = false;
                    }
                    index += 1;
                    break;
                default:
                    index += 1;
                    break;
            }
        }

        if (dataInAndOut.containsKey("data")) {
            data = dataInAndOut.get("data");
        } else data = dataInAndOut.getOrDefault("in", "");

        if (isRunning) {
            programRuns(currentMode, currentType);
        }
    }

    public static void programRuns(Mode mode, Type type) {
        String message;
        if (mode == Mode.ENCRYPT) {
            Encrypter encrypter = new Encrypter();
            if (type == Type.SHIFT) {
                encrypter.setMethod(new ShiftEncryption());
            } else {
                encrypter.setMethod(new UnicodeEncryption());
            }
            message = encrypter.encryptString(data, key);
        } else {
            Decrypter decrypter = new Decrypter();
            if (type == Type.SHIFT) {
                decrypter.setMethod(new ShiftDecryption());
            } else {
                decrypter.setMethod(new UnicodeDecryption());
            }
            message = decrypter.decryptString(data, key);
        }
        System.out.println(message);

        if (dataInAndOut.containsKey("out")) {
            saveToFileName(dataInAndOut.get("out"), message);
        }
    }

    public static String readMessageFromFileName(String filePath) {
        File importFile = new File("./" + filePath);
        String messageFromFile = null;
        try (Scanner fileInput = new Scanner(importFile)) {
            messageFromFile = fileInput.nextLine();
        } catch (FileNotFoundException e) {
            System.out.println("Error: file not found.");
            isRunning = false;
        }
        return messageFromFile;
    }

    public static void saveToFileName(String filePath, String message) {
        File exportFile = new File("./" + filePath);
        try (FileWriter writer = new FileWriter(exportFile)) {
            writer.write(message);
        } catch (IOException e) {
            System.out.println("Error: an IO exception occurs.");
        }
    }
}
