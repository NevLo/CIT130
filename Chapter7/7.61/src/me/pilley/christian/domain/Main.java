
package me.pilley.christian.domain;

/**
 * @author Christian Pilley
 *
 */
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Domain d1 = new Domain("KoalasToTheMax");
		Domain d2 = new Domain();
		d2.setDomain("thatsthefinger");
		
		System.out.println("d1");
		System.out.println(d1);
		System.out.println("\nd2.toString()");
		System.out.println(d2.toString());
		System.out.println();
		System.out.println("d1.createAddress()");
		System.out.println(d1.createAddress());
		System.out.println();
		System.out.println("d1.equals(d2)");
		System.out.println(d1.equals(d2) ? "Same Domain" : "Different Domain");
		System.out.println("\nd1.equals(d2)");
		System.out.println(d1.equals(d1) ? "Same Domain" : "Different Domain");
	}

}
