package ICS3.Pong.Render;

        import javax.swing.*;
        import java.awt.*;
        import java.awt.image.BufferedImage;

public class DrawView extends JPanel {
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g); // Paint parent's background
        setBackground(Color.BLACK); // Set background color for this JPanel
        redraw(g, new Dimension(this.getSize()));
    }

    public static void redraw(Graphics g, Dimension d) {
        switch (view.getViewId) {
            case 0:
                Game.Ball.BallView.draw(g, d);
                Game.Paddle.PaddleView.draw(g, d);
                Game.DebugView.draw(g, d);
                ICS3.Pong.Score.ScoreView.draw(g, d);


                BufferedImage cursorImg = new BufferedImage(16, 16, BufferedImage.TYPE_INT_ARGB);
                Cursor blankCursor = Toolkit.getDefaultToolkit().createCustomCursor(cursorImg, new Point(0, 0), "nocursor");
                g.setCursor(blankCursor);

                break;

        }
    }
}
