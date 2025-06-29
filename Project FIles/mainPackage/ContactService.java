//Author: Jaden B. Knutson

package mainPackage;
//------------------------------------------------------------------
import java.util.HashMap;
import java.util.Map;
//=======================================================================================================	
//=======================================================================================================	
public class ContactService {
//=======================================================================================================	
	private final Map<String, Contact> contacts = new HashMap<>();
	
	//------------------------------------------------------------------
	// Validates contactID is unique before adding the contact.
	public void addContact(Contact contact) {
		if(contacts.containsKey(contact.getContactID())) {
			throw new IllegalArgumentException("Contact ID Already Exists!");
		}
		// Add the Contact object to the HashMap.
		contacts.put(contact.getContactID(), contact);
	} // END ADD CONTACT
	
	//------------------------------------------------------------------
	// Deletes contact by their contactID
	public void deleteContact(String contactID) {
		if(!contacts.containsKey(contactID)) {
			throw new IllegalArgumentException("Contact ID Not Found!");
		}
		contacts.remove(contactID);
	} // END DELETE CONTACT
	
	//------------------------------------------------------------------
	// Validate that the contactID exists in the HashMap and then updates contact information fields.
	public void updateContact(String contactID, String firstName, String lastName, String phone, String address) {
		if (!contacts.containsKey(contactID)) {
			throw new IllegalArgumentException("Contact ID Not Found!");
		}
		
		Contact contact = contacts.get(contactID);
		if (firstName != null) contact.setFirstName(firstName);
		if (lastName != null) contact.setLastName(lastName);
		if (phone != null) contact.setPhone(phone);
		if (address != null) contact.setAddress(address);
	} // END UPDATE CONTACT
//=======================================================================================================	
} // END CLASS
//=======================================================================================================	
//=======================================================================================================	


