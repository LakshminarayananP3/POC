
import java.awt.*;
import java.awt.TrayIcon.MessageType;
import java.util.Timer;
import java.util.TimerTask;

public class BlinkEyes extends TimerTask {
    public static void main(String[] args) throws Exception {
        Timer t = new Timer();
        BlinkEyes td = new BlinkEyes();
        t.scheduleAtFixedRate(td, 0, 1800000);
    }

    @Override
    public void run() {
        //Obtain only one instance of the SystemTray object
        SystemTray tray = SystemTray.getSystemTray();

        //If the icon is a file
        Image image = Toolkit.getDefaultToolkit().createImage("icon.png");
        //Alternative (if the icon is on the classpath):
        //Image image = Toolkit.getDefaultToolkit().createImage(getClass().getResource("icon.png"));

        TrayIcon trayIcon = new TrayIcon(image, "Tray Demo");
        //Let the system resize the image if needed
        trayIcon.setImageAutoSize(true);
        //Set tooltip text for the tray icon
        trayIcon.setToolTip("System tray icon demo");
        try {
            tray.add(trayIcon);
        } catch (AWTException e) {
            e.printStackTrace();
        }

        trayIcon.displayMessage("Blink Eyes", "1. Blink your eyes for 20 Seconds\n2. Look far at 20 feet distance\n3. Do above for 20 Seconds", MessageType.INFO);
    }
}