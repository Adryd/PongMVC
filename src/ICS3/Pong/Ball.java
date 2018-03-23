package ICS3.Pong;

import java.awt.*;


public class BallController {

    


    public void reposition() {
        // Create these variables to shorten the following if statements

        int wW = Pong.getWindowDimensions().width;
        int wH = Pong.getWindowDimensions().height;
        int pW = Pong.Paddle.getWidth();
        int pS = Pong.Paddle.getHeight();
        int p1 = Pong.Players[0].getPaddlePlayer().getPosition();
        int p2 = Pong.Players[1].getPaddlePlayer().getPosition();

        /*
         * CHECKS:
         * 1. Check if ball escapes boundaries
         * 2. Check if ball should bounce on walls
         * 3. Check if ball is touching paddle
         */

        // Check 1: Check for escaped boundaries

        // If the Y coordinate of the ball is less than one (accounting for the ball's radius)
        // Set the ball to the top of the screen (0) and add the radius of the ball so it's in bounds (r)
        if (y - r < -1) {
            y = r + 1;
        }
        // If the Y coordinate of the ball is greater than the window's height plus one (accounting for the
        // ball's radius), Set the ball to the bottom of the screen (and subtract radius so it stays in bounds)
        if (y + r > wH + 1) {
            y = wH - r - 1;
        }

        // If the x coordinate of the ball is less than 0 or greater than the window's width (accounting for radius),
        // we reset the ball, as it is now off screen.
        if (x + r < -1) {
            Pong.Players[0].getScore().addMisses(1);
            Pong.Players[1].getScore().addWins(1)
        }
        if (x - r > wW + 1) {
            Pong.Players[1].getScore().addMisses(1);
            Pong.Players[0].getScore().addWins(1);
        }
        if (x + r < -1 || x - r > wW + 1) {
            //Pong.init(windowDimensions);
        }

        // Check 2: Bounce on walls

        // If the ball's y coordinate is less than zero or greater than the width (still accounting for the radius).
        // We reverse the y direction
        if (y - r <= 0 || y + r >= wH) {
            dy = -dy;
        }

        // Check 3: Bounce on paddles

        // If ball's X coordinate is equal to the paddles width (since we're adding the paddle's width to zero),
        // and the ball's Y coordinate is greater than the Y coordinate of top edge of the paddle (account for radius),
        // and if the ball's Y coordinate is less than the Y coordinate of the bottom edge of the paddle (account for radius)
        if (x - r == pW && y > p1 - pS - r && y < p1 + pS + r) {
            dx = -dx;
            Pong.Players[0].getScore().addBounces(1);
        }
        // If ball's X coordinate is equal to the window's width minus the paddle's width,
        // and the ball's Y coordinate is greater than the Y coordinate of top edge of the paddle (account for radius),
        // and if the ball's Y coordinate is less than the Y coordinate of the bottom edge of the paddle (account for radius)
        if (x + r == wW - pW && y > p2 - pS - r && y < p2 + pS + r) {
            dx = -dx;
            Pong.Players[0].getScore().addBounces(1);
        }

        // Once all the checks are completed we can adjust the position of the ball.
        Pong.Ball.setCoordinates(new Point(x, y));
        Pong.Ball.setDirection(new Point(dx, dy));
    }

}
