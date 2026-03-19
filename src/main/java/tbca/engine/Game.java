package tbca.engine;

import tbca.ui.Ui;

public class Game {
    private static Game gameInstance;
    private GameDifficulty difficulty;
    private Ui ui;

    private Game() {
        //this.ui = new Ui();
    }

    // only one game should exist at a time so singleton. can change
    public static Game getGameInstance() {
        if (gameInstance == null) {
            gameInstance = new Game();
        }
        return gameInstance;
    }

    public void start() {
        this.ui.displayMenu();
        this.setDifficulty(ui.promptDifficulty());
        // ...
    }

    public void setDifficulty(GameDifficulty difficulty) {
        this.difficulty = difficulty;
    }

    public void reset() {
        Game.gameInstance = new Game();
    }
}
