package app;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.util.LinkedList;
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
            LinkedList<String> oldData = new LinkedList<String>();
            String line;

            while((line = reader.readLine()) != null){
                oldData.add(line);
            }
            if(oldData.size() == 30){
                File batteryDataNew = new File("src\\data\\BatteryData.txt");
                FileWriter fw = new FileWriter(batteryDataNew);
                oldData.remove();
                for(String data : oldData){
                    fw.write(data + "\n");
                }
                fw.write(start-end+"d"+" "+end+"e\n");
                fw.close();
                reader.close();
            }
            else if(oldData.size() > 30){
                JOptionPane.showMessageDialog(null, "Data error exists in file. Purging old data and \ncreating new file with entered data.", "Data Error", JOptionPane.WARNING_MESSAGE);
                File batteryDataNew = new File("src\\data\\BatteryData.txt");
                FileWriter fw = new FileWriter(batteryDataNew);
                fw.write(start-end+"d"+" "+end+"e\n");
                fw.close();
            }
            else{
                FileWriter fw = new FileWriter(batteryData, true);
                fw.write(start-end+"d"+" "+end+"e\n");
                fw.close();
            }
        }
    }
}