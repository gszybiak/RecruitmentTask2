package com.example.recruitmenttask2.tasks;

import java.io.*;

public class ReplaceEverySecondController {
    public static void replaceEverySecond(String inputPath, String outPath) {
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(inputPath));
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(outPath));

            String line;
            int brCount = 0;

            while ((line = bufferedReader.readLine()) != null) {
                int index = -1;

                while ((index = line.indexOf("<br>", index + 1)) != -1) {
                    brCount++;

                    line = (brCount % 2 == 0) ? (line.substring(0, index) + "</br></br>" + line.substring(index + 4)) : line;
                }

                bufferedWriter.write(line);
                bufferedWriter.newLine();
            }
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
