package yahtzee;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class GameTest {
	private Game game;
	@Before
	public void setUp() throws Exception {
		this.game = new Game();
		game.start();
	}

	@Test
	public void testExecuteScore() {
		fail("Not yet implemented");
		
	}

}
