package ICS3.Pong;

public class PlayerModel {
    ScoreModel Score = new ScoreModel();
    PaddlePlayerModel Paddle = new PaddlePlayerModel();

    public PaddlePlayerModel getPaddlePlayer() {
        return Paddle;
    }
    public ScoreModel getScore() {
        return Score;
    }
}
