package invaders;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class GameState implements Subject {
    private List<Observer> observers;
    private int score;
    private Duration gameTime = Duration.ZERO;

    public GameState() {
        observers = new ArrayList<>();
        score = 0;
        gameTime = Duration.ofMinutes(0);
    }

    @Override
    public void registerObserver(Observer o) {
        observers.add(o);
    }

    @Override
    public void removeObserver(Observer o) {
        observers.remove(o);
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update();
        }
    }

    public int getScore() {
        return score;
    }

    public void increaseScore(int points) {
        this.score += points;
        notifyObservers();
    }

    public Duration getGameTime() {
        return gameTime;
    }

    public void setGameTime(Duration gameTime) {
        this.gameTime = gameTime;
        notifyObservers();
    }

    public void incrementGameTime(Duration delta) {
        this.gameTime = this.gameTime.plus(delta);
        notifyObservers();
    }
}

