package com.example.dashboard1;

import java.io.*;
import java.lang.ProcessBuilder;
import com.example.dashboard1.LogParser.*;

public class LogReader {

    public static void readLogFile(String filePath) throws IOException {

        BufferedReader br = new BufferedReader(new FileReader(new File("/Users/fatima-zahra/Desktop/Shell:Unix/mine/fic")));
        String logLine = br.readLine();

        // Au début on va lire tout le fichier et traiter ligne par ligne
        while((logLine=br.readLine())!=null)
        {
            LogRecord logRecord=LogParser.parseLog(logLine);
            LogRecordController.addLogRecord(logRecord);
        }

        // Puis on va traiter les lignes qui sont envoyées par Apache par au moment de l'ouverture de l'application en temps réel vi la commande tail -f

        while(true){
            String cmd = "tail -f "+ filePath;
            Process process = Runtime.getRuntime().exec(cmd);

            // Read the output from the command
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String newLogLine;
            while((newLogLine = reader.readLine()) != null) {
                // Do something with the output
                System.out.println(newLogLine);
                LogRecord logRecord=LogParser.parseLog(newLogLine);
                LogRecordController.addLogRecord(logRecord);
            }
            reader.close();

        }
    }
    public static void main(String args[]) throws IOException {

        readLogFile("/Users/fatima-zahra/Desktop/Shell:Unix/mine/fic");
    }


}
