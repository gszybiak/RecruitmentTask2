package com.example.recruitmenttask2.tasks;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class ReadAndCount {

    public static Map<String, Integer> loadDataFromFile(String nameFile) {
        Map<String, Integer> occurrencesMap = new HashMap<>();
        InputStream inputStream = ReadAndCount.class.getClassLoader().getResourceAsStream(nameFile);

        if (inputStream != null) {
            try(BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream)))  {
                String line;
                while ((line = bufferedReader.readLine()) != null) {
                    String trimmedLine = line.trim();
                    occurrencesMap.put(trimmedLine, occurrencesMap.getOrDefault(trimmedLine, 0) + 1);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return occurrencesMap;
    }

    public static void printItems(Map<String, Integer> occurrencesMap) {
        System.out.println("Items and their occurences:");
        occurrencesMap.entrySet().stream().forEach(entry -> System.out.println(entry.getKey() + ": " + entry.getValue()));
    }

    public static void printItemsOrderByOccurences(Map<String, Integer> occurrencesMap) {
        System.out.println("Items and their occurences sorted:");
        occurrencesMap.entrySet().stream()
                .sorted(Map.Entry.comparingByValue())
                .forEach(entry -> System.out.println(entry.getKey() + ": " + entry.getValue()));
    }
}
