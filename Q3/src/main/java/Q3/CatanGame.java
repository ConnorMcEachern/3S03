package Q3;

import java.util.List;

public class CatanGame {

    private final List<CatanAgent> agents;
    private GameState gameState;
    private int currentPlayer = 0;

    public CatanGame(List<CatanAgent> agents, GameState gameState) {
        this.gameState = gameState;
        this.agents = agents;

        for (int i = 0; i < agents.size(); i++) {
            agents.get(i).init(i);
        }
    }

    public int getCurrentPlayer() {
        return currentPlayer;
    }

    public void playTurn() {
        currentPlayer = (currentPlayer + 1) % agents.size();
    }
}
