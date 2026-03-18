package tbca.engine;

public class Game {
    private static Game gameInstance;

    private Game() {}

    public static Game getGameInstance() {
        if (gameInstance == null) {
            gameInstance = new Game();
        }
        return gameInstance;
    }

    public void start() {

    }

    public void reset() {

    }
}
