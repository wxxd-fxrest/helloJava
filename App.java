import javax.swing.JOptionPane;

import org.opentutorials.iot.DimmingLights;
import org.opentutorials.iot.Elevator;
import org.opentutorials.iot.Security;
import org.opentutorials.iot.Lighting;

public class App {
    public static void main(String[] args) {
        for (String arg : args) {
            System.out.println(arg); // 아규먼트 출력
        }

        String id = JOptionPane.showInputDialog("Enter a ID");
        String bright = JOptionPane.showInputDialog(null, "Enter a Bright Level");

        // Elevator call 
        Elevator myElevator = new Elevator(id);
        myElevator.callForUp(1); 

        // Security off
        Security mySecurity = new Security(id);
        mySecurity.off();

        // Light on 
        Lighting hallLamp = new Lighting(id + " / Hall Lamp");
        hallLamp.on();

        DimmingLights moodLamp = new DimmingLights(id + " moodLamp");
        moodLamp.setBright(Double.parseDouble(bright));
        moodLamp.on();
    }
}