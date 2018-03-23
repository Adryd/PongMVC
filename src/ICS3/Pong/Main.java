package ICS3.Pong;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        // Run the GUI codes on the Event-Dispatching thread for thread safety
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Pong(); // Let the constructor do the job
            }
        });
    }
}
