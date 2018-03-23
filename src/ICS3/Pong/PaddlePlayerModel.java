package ICS3.Pong;

public class PaddlePlayerModel {
    int y, dy;

    public int getPosition() {
        return this.y;
    }
    public void setPosition(int y) {
        this.y = y;
    }
    public int getDirection() {
        return this.dy;
    }
    public void setDirection(int y) {
        this.dy = dy;
    }
}
