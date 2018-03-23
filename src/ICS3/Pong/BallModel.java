package ICS3.Pong;

import java.awt.*;

public class BallModel {
    int x, y, dx, dy;
    int radius;

    public Point getCoordinates() {
        return new Point(this.x, this.y);
    }
    public Point getDirection () {
        return new Point(this.dx, this.dy);
    }
    public int getRadius () {
        return this.radius;
    }

    public void setCoordinates(Point Coordinates) {
        this.x = Coordinates.x;
        this.y = Coordinates.y;
    }
    public void setDirection(Point Direction) {
        this.dx = Direction.x;
        this.dy = Direction.y;
    }
    public void setRadius(int radius) {
        this.radius = radius;
    }
}
