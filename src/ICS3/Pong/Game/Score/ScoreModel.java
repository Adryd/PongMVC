package ICS3.Pong;

public class ScoreModel {
    int bounces, misses, wins;

    public int getBounces() {
        return this.bounces;
    }
    public void addBounces(int i) {
        this.bounces += i;
    }
    public void setBounces(int i) {
        this.bounces = i;
    }

    public int getMisses() {
        return this.misses;
    }
    public void addMisses(int i) {
        this.misses += i;
    }
    public void setMisses(int i) {
        this.misses = i;
    }

    public int getWins() {
        return this.wins;
    }
    public void addWins(int i) {
        this.wins += i;
    }
    public void setWins(int i) {
        this.wins = i;
    }
}
