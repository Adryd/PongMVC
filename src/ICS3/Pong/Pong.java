
package ICS3.Pong;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;


// A Swing application extends javax.swing.JFrame
public class Pong extends JFrame implements Runnable, KeyListener, MouseMotionListener {
    // Define constants


    public void mouseMoved(MouseEvent e) {
        e.getPoint();
    }
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyChar()) {
            case 'a':
                break;
            case 's':
                break;
            case 'k':
                break;
            case 'j':
                break;
        }
    }
    public void keyReleased(KeyEvent e) {
        switch (e.getKeyChar()) {
            case 'a':
                break;
            case 's':
                break;
            case 'k':
                break;
            case 'j':
                break;
        }
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

        // make a new thread from this class
        Thread th = new Thread(this);
        th.start();

    }

    public void run() {
        while (true) {
            canvas.repaint();
            try {
                Thread.sleep(5);
            } catch (InterruptedException e) {
                // do nothing
            }
        }
    }
}
