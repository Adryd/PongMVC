
package ICS3.Pong;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;


// A Swing application extends javax.swing.JFrame
public class Pong extends JFrame implements Runnable, KeyListener, MouseMotionListener {
    // Define constants

    public static PlayerModel[] Players = new PlayerModel[2];
    public static BallModel Ball = new BallModel();
    public static PaddleModel Paddle = new PaddleModel();
    public static SettingsModel Settings = new SettingsModel();

    private void init() {
        for (int i = 0; i < 2; i++) {
            Players[i] = new PlayerModel();
        }
        BallController.init(Ball)
    }

    // Pass Inputs to an input controller
    public void mouseMoved(MouseEvent e) {
        InputController.mouseMoved(e);
    }

    public void keyPressed(KeyEvent e) {
        InputController.keyPress(e);
    }

    public void keyReleased(KeyEvent e) {
        InputController.keyRelease(e);
    }


    // Constructor to set up the GUI components and event handlers
    public Pong() {
        DrawView canvas = new DrawView(); // Construct the drawing canvas
        canvas.setPreferredSize(new Dimension(640, 480));

        // Set the Drawing JPanel as the JFrame's content-pane
        public Container cp = getContentPane();
        cp.add(canvas);

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE); // Handle the CLOSE button
        pack(); // Either pack() the components; or setSize()
        setTitle("Pong"); // "super" JFrame sets the title
        setVisible(true); // "super" JFrame show

        BufferedImage cursorImg = new BufferedImage(16, 16, BufferedImage.TYPE_INT_ARGB);
        Cursor blankCursor = Toolkit.getDefaultToolkit().createCustomCursor(cursorImg, new Point(0, 0), "nocursor");
        canvas.setCursor(blankCursor);

        // make a new thread from this class
        Thread th = new Thread(this);
        th.start();

        init();

    }

    public void run() {
        while (true) {
            repaint();
            try {
                Thread.sleep(5);
            } catch (InterruptedException e) {
                // do nothing
            }
        }
    }

    public class DrawView extends JPanel {
        @Override
        public void paintComponent(Graphics g) {
            Dimension d = this.getSize();
            super.paintComponent(g); // Paint parent's background
            setBackground(Color.BLACK); // Set background color for this JPanel

            BallView.draw(g, d);
            PaddleView.draw(g, d);
            DebugView.draw(g, d);
            ScoreView.draw(g, d);
        }
    }
}