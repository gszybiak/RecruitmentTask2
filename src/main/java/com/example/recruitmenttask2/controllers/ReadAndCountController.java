package com.example.recruitmenttask2.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

import static com.example.recruitmenttask2.tasks.ReadAndCount.*;

@Controller
public class ReadAndCountController {
    @PostMapping("/readAndCount")
    @ResponseBody
    public void readAndCount(@RequestParam String nameFile) {
        Map<String, Integer> occurrencesMap = loadDataFromFile(nameFile);
        printItems(occurrencesMap);
    }

    @PostMapping("/readAndCountInAscending")
    @ResponseBody
    public void readAndCountInAscending(@RequestParam String nameFile) {
        Map<String, Integer> occurrencesMap = loadDataFromFile(nameFile);
        printItemsOrderByOccurences(occurrencesMap);
    }
}
