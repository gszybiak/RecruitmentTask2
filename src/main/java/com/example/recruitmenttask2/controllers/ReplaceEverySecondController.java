package com.example.recruitmenttask2.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import static com.example.recruitmenttask2.tasks.ReplaceEverySecondController.replaceEverySecond;

@Controller
public class ReplaceEverySecondController {
    @PostMapping("/replaceEverySecond")
    @ResponseBody
    public void readAndCount(@RequestParam String inputFile, @RequestParam String outputFile) {
        replaceEverySecond(inputFile, outputFile);
    }
}
