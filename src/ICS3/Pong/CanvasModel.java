package ICS3.Pong;

public class CanvasModel {

        canvas = new DrawCanvas(); // Construct the drawing canvas
        canvas.setPreferredSize(new Dimension(CANVAS_PREFERRED_WIDTH, CANVAS_PREFERRED_HEIGHT));

        // Set the Drawing JPanel as the JFrame's content-pane
        Container cp = getContentPane();
        cp.add(canvas);
}
