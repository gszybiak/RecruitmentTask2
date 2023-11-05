package com.example.recruitmenttask2.controllers;

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
    public void readAndCount(@RequestParam String path) {
        Map<String, Integer> occurrencesMap = loadDataFromFile(path);
        printStringsAndOccurences(occurrencesMap);
    }

    @PostMapping("/readAndCountInAscending")
    @ResponseBody
    public void readAndCountInAscending(@RequestParam String path) {
        Map<String, Integer> occurrencesMap = loadDataFromFile(path);
        printStringsAndOccurencesInAscendingOrderOfOccurences(occurrencesMap);
    }
}
