import javax.swing.*;
import java.awt.*;

public class Frame extends JFrame {
    Panel ppanel;
    final static int GAME_HEIGHT = 635;
    final static int GAME_WIDTH = 615;

    Frame() {
        ppanel = new Panel();

        this.setPreferredSize(new Dimension(GAME_WIDTH,GAME_HEIGHT));
        this.getContentPane().add(ppanel);
        this.add(ppanel);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Aim Trainer");
        this.setVisible(true);
        this.pack();
        this.setResizable(false);
        this.setLocationRelativeTo(null);

        TrainerStart();
    }

    public void TrainerStart() {
        ppanel.TilesGenerator();
    }
}