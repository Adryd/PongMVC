package ICS3.Pong;

public class PongModel {
    PlayerModel[] Players = new PlayerModel[2];
    BallModel Ball = new BallModel();
    PaddleModel Paddle = new PaddleModel();
    SettingsModel Settings = new SettingsModel();



    public void Initialize() {
        for (int i = 0; i < 2; i++) {
            Players[i] = new PlayerModel();
        }
    }

}
