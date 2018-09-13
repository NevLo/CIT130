
package quotes;

import java.util.ArrayList;

public class QuoteList {
    private static ArrayList<String> quotes = new ArrayList<String>();
	
	
	
	public QuoteList(){
		quotes.add("Luke, I am your father");
		quotes.add("It puts the lotion on its skin, or it gets the hose again");
		quotes.add("Vote for pedro!");
		quotes.add("Frankly my dear, I dont give a damn ");
		quotes.add("May the force be with you");
		quotes.add("Ive got a bad feeling about this");
		quotes.add("Beam me Scotty!");
		quotes.add("You can't handle the truth!");
		quotes.add("Say \"Hello\" to my little friend!");
		quotes.add("HEREEES JOHNNNNNNNY");
		
	}
	public ArrayList<String> getQuotes(){
		return quotes;
	}
}
