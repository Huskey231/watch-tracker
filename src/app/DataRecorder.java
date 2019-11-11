package app;

import java.io.File;
import java.io.FileWriter;
import javax.swing.JOptionPane;


class DataRecorder{

    static void recordNewEntry(int start, int end)throws Exception{
        File batteryData = new File("src\\Data\\BatteryData.txt");
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
            FileWriter fw = new FileWriter(batteryData, true);
            fw.write(start-end+"d"+" "+end+"e\n");
            fw.close();
        }
    }
}