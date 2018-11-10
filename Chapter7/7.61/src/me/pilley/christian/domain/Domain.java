
package me.pilley.christian.domain;

/**
 * @author Christian Pilley
 *
 */
public class Domain {
	private String domain;
	/**Default Constructor to create a new Domain
	 * 
	 */
	public Domain() {}
	/**Overloaded constructor to create a new Domain
	 * 
	 * @param domain
	 */
	public Domain(String domain) {
		this.domain = domain;
	}
	/**Gets the domain variable
	 * 
	 * @return String
	 */
	public String getDomain() {
		return domain;
	}
	/**Sets the domain variable
	 * 
	 * @param domain
	 */
	public void setDomain(String domain) {
		this.domain = domain;
	}
	
	/**Overriding .toString()
	 * 
	 */
	@Override
	public String toString() {
		return domain;
	}
	/**Overriding .equals()
	 * 
	 */
	@Override
	public boolean equals(Object obj) {
		return obj instanceof Domain && ((Domain)obj).domain == domain;
	}
	/**
	 * 
	 * @return string
	 */
	public String createAddress() {
		return "www." + domain + ".com";
	}
}
