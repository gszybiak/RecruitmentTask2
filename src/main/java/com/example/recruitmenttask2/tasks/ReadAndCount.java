package com.example.recruitmenttask2.tasks;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class ReadAndCount {

    public static Map<String, Integer> loadDataFromFile(String path) {
        Map<String, Integer> occurrencesMap = new HashMap<>();
        try{
            FileReader fileReader = new FileReader(path);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String trimmedLine = line.trim();
                occurrencesMap.put(trimmedLine, occurrencesMap.getOrDefault(trimmedLine, 0) + 1);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            return occurrencesMap;
        }
    }

    public static void printStringsAndOccurences(Map<String, Integer> occurrencesMap) {
        System.out.println("Stringi i ich ilości występowania w pliku:");
        for (Map.Entry<String, Integer> entry : occurrencesMap.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }

    public static void printStringsAndOccurencesInAscendingOrderOfOccurences(Map<String, Integer> occurrencesMap) {
        System.out.println("Posortowane rosnąco:");
        occurrencesMap.entrySet().stream()
                .sorted(Map.Entry.<String, Integer>comparingByValue())
                .forEach(entry -> System.out.println(entry.getKey() + ": " + entry.getValue()));
    }
}
