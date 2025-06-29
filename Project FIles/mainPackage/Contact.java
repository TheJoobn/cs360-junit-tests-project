//Author: Jaden B. Knutson

package mainPackage;

//=======================================================================================================	
//=======================================================================================================	
public class Contact {
//=======================================================================================================	
	//Use private fields for contactID, firstName, lastName, phone, and address.
	//Make contactID final since it is immutable.
	private final String contactID;		// Must not be null, max 10 characters.
	private String firstName; 			// Must not be null, max 10 characters.
	private String lastName; 			// Must not be null, max 10 characters.
	private String phone; 				// Must not be null, exactly 10 digits.
	private String address; 			// Must not be null, max 30 characters.
//=======================================================================================================		
//CONSTRUCTOR
	public Contact(String contactID, String firstName, String lastName, String phone, String address) {
	
		// Contact ID - Must not be null, max 10 characters.
		if (contactID == null || contactID.length() > 10) {
			throw new IllegalArgumentException("Invalid Contact ID!");
		}
		this.contactID = contactID;
		
		//------------------------------------------------------------------
		// First Name - Must not be null, max 10 characters.
		if (firstName == null || firstName.length() > 10) {
			throw new IllegalArgumentException("Invalid First Name!");
		}
		this.firstName = firstName;
		
		//------------------------------------------------------------------
		// Last Name - Must not be null, max 10 characters.
		if (lastName == null || lastName.length() > 10) {
			throw new IllegalArgumentException("Invalid Last Name!");
		}
		this.lastName = lastName;
		
		//------------------------------------------------------------------
		// Phone number - Must not be null, exactly 10 digits.
		if (phone == null || phone.length() != 10) {
			throw new IllegalArgumentException("Invalid Phone Number!");
		}
		this.phone = phone;
		
		//------------------------------------------------------------------
		// Address - Must not be null, max 30 characters.
		if (address == null || address.length() > 30) {
			throw new IllegalArgumentException("Invalid Address!");
		}
		this.address = address;
		
	} // END Contact Validation
//=======================================================================================================	
//GETTERS
	
	// Get Contact ID
	public String getContactID() {
		return contactID;
	} // END GET
	
	//------------------------------------------------------------------
	// Get First Name
	public String getFirstName() {
		return firstName;
	} // END GET
	
	//------------------------------------------------------------------
	// Get Last Name
	public String getLastName() {
		return lastName;	
	} // END GET
	
	//------------------------------------------------------------------
	// Get Phone Number
	public String getPhone() {
		return phone;
	} // END GET
	
	//------------------------------------------------------------------
	// Get Address
	public String getAddress() {
		return address;
	} // END GET
	
//=======================================================================================================	
//SETTERS
	
	// Set First Name
	public void setFirstName(String firstName) {
		// Must not be null, max 10 characters.
		if (firstName == null || firstName.length() > 10) {
			throw new IllegalArgumentException("Invalid First Name!");
		}
		this.firstName = firstName;
	} // END SET
	
	//------------------------------------------------------------------
	// Set Last Name
	public void setLastName(String lastName) {
		// Must not be null, max 10 characters.
		if (lastName == null || lastName.length() > 10) {
			throw new IllegalArgumentException("Invalid Last Name!");
		}
		this.lastName = lastName;
	} // END SET
	
	//------------------------------------------------------------------
	// Set Phone
	public void setPhone(String phone) {
		// Must not be null, exactly 10 digits.
		if (phone == null || phone.length() != 10) {
			throw new IllegalArgumentException("Invalid Phone Number!");
		}
		this.phone = phone;
	} // END SET
	
	//------------------------------------------------------------------
	// Set Address
	public void setAddress(String address) {
		//Must not be null, max 30 characters.
		if (address == null || address.length() > 30) {
			throw new IllegalArgumentException("Invalid Address!");
		}
		this.address = address;
	} // END SET
	
	
//=======================================================================================================	
	@Override
	// String contact info tester
	public String toString() {
	    return "Contact{" +
	            "contactID='" + contactID + '\'' +
	            ", firstName='" + firstName + '\'' +
	            ", lastName='" + lastName + '\'' +
	            ", phone='" + phone + '\'' +
	            ", address='" + address + '\'' +
	            '}';
	} // END toString

//=======================================================================================================	
	// Quick Contact Test
	/*
	public static void main(String[] args) {
		try {
			Contact contact = new Contact ("ID:8675309", "Jaden", "Knutson", "1234567890", "121 Music Lane");
			
			System.out.println(contact.getContactID());
			System.out.println(contact.getFirstName());
			System.out.println(contact.getLastName());
			System.out.println(contact.getPhone());
			System.out.println(contact.getAddress());
			
			contact.setFirstName("J");
			contact.setLastName("K");
			contact.setPhone("8888888888");
			contact.setAddress("888 Video Lane");
			
			System.out.println(" ");
			System.out.println(contact.getContactID());
			System.out.println(contact.getFirstName());
			System.out.println(contact.getLastName());
			System.out.println(contact.getPhone());
			System.out.println(contact.getAddress());
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}*/
	
//=======================================================================================================	
} // END CLASS
//=======================================================================================================	
//=======================================================================================================	


