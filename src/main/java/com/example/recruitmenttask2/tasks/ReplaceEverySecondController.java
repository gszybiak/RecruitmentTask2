package com.example.recruitmenttask2.tasks;

import java.io.*;

public class ReplaceEverySecondController {
    public static void replaceEverySecond(String inputFile, String outputFile) {
        try {
            InputStream inputStream = ReplaceEverySecondController.class.getClassLoader().getResourceAsStream(inputFile);
            OutputStream outputStream = new FileOutputStream(outputFile);

            if (inputStream != null) {
                try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
                     BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(outputStream))) {

                    String line;
                    int brCount = 0;

                    while ((line = bufferedReader.readLine()) != null) {
                        int index = -1;

                        while ((index = line.indexOf("<br>", index + 1)) != -1) {
                            brCount++;

                            line = (brCount % 2 == 0) ? (line.substring(0, index) + "</br></br>" + line.substring(index + 4)) : line;
                        }

                        writer.write(line);
                        writer.newLine();
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
