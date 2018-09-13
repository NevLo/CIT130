/*
name: Christian Pilley
desc: Prints out a quote.
 */
package quotes;
import java.util.Random;

public class Quotes {

   
    public static void main(String[] args) {
        Random random = new Random();
        QuoteList q = new QuoteList();	
        System.out.println(q.getQuotes()
                .get(random.nextInt(q.getQuotes().size())));
    }
    
}
