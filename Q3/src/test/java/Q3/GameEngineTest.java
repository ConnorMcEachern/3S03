package Q3;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import java.util.*;

public class GameEngineTest {

    @Test
    public void testPlayerInits() {
        List<CatanAgent> agents = new ArrayList();

        agents.add(mock(CatanAgent.class));
        agents.add(mock(CatanAgent.class));
        agents.add(mock(CatanAgent.class));

        GameState state = new GameState();

        CatanGame game = new CatanGame(agents, state);

        verify(agents.get(0)).init(0);
        verify(agents.get(1)).init(1);
        verify(agents.get(2)).init(2);
    }

    @Test
    public void checkPlayerOrder() {
        List<CatanAgent> agents = new ArrayList();

        agents.add(mock(CatanAgent.class));
        agents.add(mock(CatanAgent.class));
        agents.add(mock(CatanAgent.class));
        agents.add(mock(CatanAgent.class));

        GameState state = new GameState();

        CatanGame game = new CatanGame(agents, state);

        assertEquals(0, game.getCurrentPlayer());
        game.playTurn();
        assertEquals(1, game.getCurrentPlayer());
        game.playTurn();
        assertEquals(2, game.getCurrentPlayer());
        game.playTurn();
        assertEquals(3, game.getCurrentPlayer());
        game.playTurn();
        assertEquals(0, game.getCurrentPlayer());
    }
}