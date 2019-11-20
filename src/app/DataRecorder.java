package app;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import javax.swing.JOptionPane;
import java.io.FileReader;


class DataRecorder{

    static void recordNewEntry(int start, int end)throws Exception{
        File batteryData = new File("src\\data\\BatteryData.txt");
        if(!batteryData.exists()){
            if(!batteryData.createNewFile()){
                JOptionPane.showMessageDialog(null, "Data file unable to be created, battery statistics not recorded.");
            }
            else{
                FileWriter fw = new FileWriter(batteryData);
                fw.write(start-end+"d"+" "+end+"e\n");
                fw.close();
            }
        }
        else{
            BufferedReader reader = new BufferedReader(new FileReader("src\\data\\BatteryData.txt"));
            String[] oldData = new String[35];
            int lineCount = 0;
            String line;

            while((line = reader.readLine()) != null && lineCount <= 30){
                oldData[lineCount] = line;
                lineCount++;
            }
            if(lineCount == 30){
                    File batteryDataNew = new File("src\\data\\BatteryData.txt");
                    FileWriter fw = new FileWriter(batteryDataNew);
                    System.out.println("Point 3");// Hits
                    for(int i = 1; i < 30; i++){
                        fw.write(oldData[i] + "\n");
                    }
                    fw.write(start-end+"d"+" "+end+"e\n");
                    fw.close();
                    reader.close();
            }
            else{
                FileWriter fw = new FileWriter(batteryData, true);
                fw.write(start-end+"d"+" "+end+"e\n");
                fw.close();
            }
        }
    }
}