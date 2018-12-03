package GameManager;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class LevelManager {
	private static Level[] levels;
	private static int numLevels;
	
	public static Level getStoryAtIndex(int index) {
		return levels[index];
	}
	public static void init() {
		Scanner levelInput = null;
		File fileInput = new File("");
		try {
			levelInput = new Scanner(fileInput);
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
			return;
		}
		for(int i = 0; i < numLevels; i++) {
			levels[i] = Level.newLevel(levelInput.next());
		}
		levelInput.close();
	}
}
