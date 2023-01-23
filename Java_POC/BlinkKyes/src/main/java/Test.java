import java.awt.*;
import java.awt.event.KeyEvent;
import java.sql.Timestamp;

public class Test {
    public static void main(String[] args) {
        try {

            int sleepTime = 10000;
            Timestamp endTime = Timestamp.valueOf("2023-01-12 22:23:43.692");
            Robot robot = new Robot();
            while (true) {
//                Timestamp currentTime = new Timestamp((System.currentTimeMillis()));
//                System.out.println(currentTime);
//                if (currentTime.after(endTime))
//                    System.exit(0);
                robot.keyPress(KeyEvent.VK_CONTROL);
                robot.keyRelease(KeyEvent.VK_CONTROL);


                robot.delay(sleepTime);
                robot.mouseMove(1200,20);
                robot.delay(sleepTime);
                robot.mouseMove(1200,5);
            }
        } catch (AWTException e) {
            e.printStackTrace();
        }
    }
}
