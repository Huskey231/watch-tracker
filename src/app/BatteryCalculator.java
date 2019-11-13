package app;

import javax.swing.JOptionPane;

public class BatteryCalculator {

    public int calcDayLife(int startLife, int endLife){
        try{
            if(startLife <= endLife){
                JOptionPane.showMessageDialog(null, "Battery life cannot have increased during the day");
                return -1;
            }
            else{
                return startLife - endLife;
            }
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e+"error occurred.");
            return 0;
        }
    }

    public double calcPredictedLife(int dayLife){
        try{
            if(dayLife <= 0){
                JOptionPane.showMessageDialog(null, "Battery life can not increase during the day.");
                return -1;
            }
            else{
                return 100.0/dayLife;
            }
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e+"error occurred.");
            return 0;
        }
    }
}