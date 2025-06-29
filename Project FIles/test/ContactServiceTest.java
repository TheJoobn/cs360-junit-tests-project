//Author: Jaden B. Knutson

package test;
//------------------------------------------------------------------
import mainPackage.Contact;
import mainPackage.ContactService;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
//------------------------------------------------------------------
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.TestMethodOrder;
//=======================================================================================================    
//=======================================================================================================    
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class ContactServiceTest {
//=======================================================================================================    
    private ContactService contactService;
    
    //------------------------------------------------------------------
    @BeforeEach
    @Order(1)
    void setUp() {
        contactService = new ContactService();
    	// Test Output message
        System.out.println("1. Setup");
    } // END

    //------------------------------------------------------------------
    // Test adding a single contact
    @Test
    @Order(2)
    void testAddContact() {
        Contact contact = new Contact("10101", "Jaden", "Knutson", "7016665555", "121 Music Lane");
    	// Test Output message
        System.out.println("2. After add contact: " + contact);
        System.out.println(); // Blank line
        // Assertion - add contact test
        assertDoesNotThrow(() -> contactService.addContact(contact));
    } // END TEST

    //------------------------------------------------------------------
    // Test adding multiple contacts
    @Test
    @Order(3)
    void testAddMultipleContacts() {
        Contact contact1 = new Contact("10101", "Jaden", "Knutson", "7016665555", "121 Music Lane");
        Contact contact2 = new Contact("20202", "RICKY", "BOBBY", "7017778888", "101 Speedway Drive");
    	// Test Output message
        System.out.println("3. After add contact 1: " + contact1);
        System.out.println("3. After add contact 2: " + contact2);
        System.out.println(); // Blank line
        // Assertions - add multiple contact test
        assertDoesNotThrow(() -> contactService.addContact(contact1));
        assertDoesNotThrow(() -> contactService.addContact(contact2));
    } // END TEST

    //------------------------------------------------------------------
    // Test adding duplicate contact ID
    @Test
    @Order(4)
    void testAddDuplicateContact() {
        // Create and display the first contact
        Contact contact1 = new Contact("10101", "Jaden", "Knutson", "7016665555", "121 Music Lane");
        System.out.println("4. Adding first contact: " + contact1); // Test Output message
        
        // Create and display the duplicate contact
        Contact contact2 = new Contact("10101", "RICKY", "BOBBY", "7017778888", "101 Speedway Drive");
        System.out.println("4. Attempting to add duplicate contact: " + contact2); // Test Output message

        // Add first contact and confirm success
        contactService.addContact(contact1);
        System.out.println("4. First contact added successfully."); // Test Output message
        
        // Assertion - add duplicate test
        // Attempt adding duplicate, confirm the exception is thrown
        assertThrows(IllegalArgumentException.class, () -> {
            contactService.addContact(contact2);
        });
        // Test Output messages
        System.out.println("4. Duplicate contact was not added as expected.");
        System.out.println(); // Blank line for readability
        
    } // END TEST

    //------------------------------------------------------------------
    // Test deleting a contact
    @Test
    @Order(5)
    void testDeleteContact() {
        Contact contact = new Contact("10101", "Jaden", "Knutson", "7016665555", "121 Music Lane");
        contactService.addContact(contact);
        System.out.println("5. Before delete contact: " + contact); // Test Output message

        // Assertion - Delete contact test
        assertDoesNotThrow(() -> contactService.deleteContact("10101"));
        System.out.println("5. Contact deleted successfully."); // Test Output message
        
        // Assertion - Delete contact test
        assertThrows(IllegalArgumentException.class, () -> contactService.deleteContact("10101"));
        // Test Output messages
        System.out.println("5. Confirmed contact no longer exists in the service.");
        System.out.println(); // Blank line 
    }
    

    //------------------------------------------------------------------
    // Test updating a contact
    @Test
    @Order(6)
    void testUpdateContact() {
        Contact contact = new Contact("10101", "Jaden", "Knutson", "7016665555", "121 Music Lane");
        contactService.addContact(contact);
        System.out.println("6. Before update contact: " + contact); // Test Output message
        
        contactService.updateContact("10101", "RICKY", "BOBBY", "7017778888", "101 Speedway Drive");
        System.out.println("6. After update contact: " + contact); // Test Output message
        
        System.out.println(); // Blank line
        
        // Assertions for update contact test
        assertEquals("RICKY", contact.getFirstName());
        assertEquals("BOBBY", contact.getLastName());
        assertEquals("7017778888", contact.getPhone());
        assertEquals("101 Speedway Drive", contact.getAddress());
    } // END TEST

    //------------------------------------------------------------------
    // Test updating a non-existing contact
    @Test
    @Order(7)
    void testUpdateNonExistingContact() {
        
    	// Assertion for non existent contact test
    	assertThrows(IllegalArgumentException.class, () -> 
            contactService.updateContact("99999", "Ricky", "Bobby", "7017778888", "101 Speedway Drive")
        );
        System.out.println("7. Cannot update non existant contact."); // Test Output message
    } // END TEST
//=======================================================================================================    
} // END CLASS
//=======================================================================================================    
//=======================================================================================================    
