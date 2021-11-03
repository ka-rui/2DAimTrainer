import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.Rectangle2D;
import java.util.Random;

public class Panel extends JPanel implements MouseListener {
    JLabel label;
    private final static int GAME_WIDTH = 600;
    final static int TILES = 200;
    private boolean training = false;
    int TilesX;
    int TilesY;
    long Score = 0;
    Random random;
    Timer timer;
    int second;
    Font font1 = new Font("Arial",Font.PLAIN,25);

    Panel() {
        label = new JLabel();
        label.setHorizontalAlignment(JLabel.CENTER);
        label.setVerticalAlignment(JLabel.TOP);
        label.setFont(font1);

        this.add(label);

        random = new Random();
        second = 30;
        countDown();
        timer.start();
    }

    public Rectangle2D rectangle2D;

    public void TilesGenerator() {
        training = true;
        TilesX = random.nextInt((GAME_WIDTH/TILES))*TILES;
        TilesY = random.nextInt((GAME_WIDTH/TILES))*TILES;
    }

    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2d = (Graphics2D) g;
        rectangle2D = new Rectangle2D.Double(TilesX,TilesY,TILES,TILES);
        if (training) {
            g2d.setColor(Color.black);
            g2d.fillRect(TilesX,TilesY,TILES,TILES);
            g2d.fill(rectangle2D);
        } else {
            gameOver();
        }
        clicked();
    }

    public void clicked() {
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                if (rectangle2D.contains(e.getX(),e.getY()) && training) {
                    Score++;
                    TilesGenerator();
                    repaint();
                }
            }
        });
    }

    public void countDown() {
        timer = new Timer(1000, e -> {
            second--;
            label.setText(""+second);
            if (second==0) {
                timer.stop();
                training = false;
            }
        });
    }

    public void gameOver() {
        label.setText("Score: " + Score);
        System.out.println("Score: "+Score);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }
}
