
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
    public void init() {
        PlayerModel[] Players = new PlayerModel[2];
        BallModel Ball = new BallModel();
        PaddleModel Paddle = new PaddleModel();
        SettingsModel Settings = new SettingsModel();

        for (int i = 0; i < 2; i++) {
            Players[i] = new PlayerModel();
        }
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

            Ball.BallView.draw(g, d);
            Paddle.PaddleView.draw(g, d);
            DebugView.draw(g, d);
            Score.ScoreView.draw(g, d);
        }
    }
}