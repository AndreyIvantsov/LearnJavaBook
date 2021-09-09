import javax.swing.*;
import javax.sound.midi.*;
import java.awt.*;

class MyDrawPanel extends JPanel implements ControllerEventListener {

    boolean msg = false;

    public void controlChange(ShortMessage event) {
        msg = true;
        repaint();
    }

    @Override
    public void paintComponent(Graphics g) {
        if (msg) {
            Graphics2D g2d = (Graphics2D) g;
            g2d.setColor(rndColor());
            g2d.fillRect(rndCoord(), rndCoord(), rndSize(), rndSize());
            msg = false;
        }
    }

    private Color rndColor() {
        final int MAX_COLOR = 250;
        int r = Rand.rnd(MAX_COLOR + 1);
        int g = Rand.rnd(MAX_COLOR + 1);
        int b = Rand.rnd(MAX_COLOR + 1);
        return new Color(r, g, b);
    }

    private int rndSize() {
        final int MIN_SIZE = 10;
        final int MAX_SIZE = 130;
        return Rand.rnd(MAX_SIZE, MIN_SIZE);
    }

    private int rndCoord() {
        final int MIN_COORD = 10;
        final int MAX_COORD = 50;
        return Rand.rnd(MAX_COORD, MIN_COORD);
    } 
}
