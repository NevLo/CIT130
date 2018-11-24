package GameManager;
import Character.Character;
@SuppressWarnings("unused")
public class GameManager {
	private static boolean alive;
	private static int points;
	private static Character mainCharacter;
	
	
	
	
	public static void end() {
		alive = false;
	}

	public static void setPlayer(Character character) {
		mainCharacter = character;	
	}

}
