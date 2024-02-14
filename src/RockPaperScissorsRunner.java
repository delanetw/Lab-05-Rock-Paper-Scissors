import javax.swing.*;
import java.awt.*;

public class RockPaperScissorsRunner
{
    public static void main(String[] args)
    {
        double dHeight = Toolkit.getDefaultToolkit().getScreenSize().getHeight();
        double dWidth = Toolkit.getDefaultToolkit().getScreenSize().getWidth();

        int height = ((int) (dHeight * .90));
        int width = ((int) (dWidth * .75));

        JFrame frame = new RockPaperScissorsFrame();
        frame.setSize(width, height);
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (int) ((dimension.getWidth() - frame.getWidth()) / 2);
        int y = (int) ((dimension.getHeight() - frame.getHeight()) / 2);
        frame.setLocation(x, y);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}