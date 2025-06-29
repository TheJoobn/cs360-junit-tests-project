//Author: Jaden B. Knutson

package test;
//------------------------------------------------------------------
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import mainPackage.Contact;
//------------------------------------------------------------------
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.TestMethodOrder;
//=======================================================================================================    
//=======================================================================================================    
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class ContactTest {
//=======================================================================================================    
    // Test valid Contact creation
    @Test
    @Order(1)
    void testValidContactCreation() {
        Contact contact = new Contact("10101", "Jaden", "Knutson", "7016665555", "121 Music Lane");
       
        // Test Output messages
        System.out.println(); // Blank line
        System.out.println("1.  Testing valid contact creation...");
        
    	// Assertions
        assertEquals("10101", contact.getContactID());
        //System.out.println("Contact ID is valid: " + contact.getContactID());
        
        assertEquals("Jaden", contact.getFirstName());
        //System.out.println("First name is valid: " + contact.getFirstName());
        
        assertEquals("Knutson", contact.getLastName());
        //System.out.println("Last name is valid: " + contact.getLastName());
        
        assertEquals("7016665555", contact.getPhone());
        //System.out.println("Phone number is valid: " + contact.getPhone());
        
        assertEquals("121 Music Lane", contact.getAddress());
        //System.out.println("Address is valid: " + contact.getAddress());
        
        // Test Output messages
        System.out.println("1.  CONTACT CREATION TEST: " + contact);
        System.out.println(); // Blank line
        
    } // END TEST
    
    //=======================================================================================================	
    // Test invalid Contact ID
    @Test
    @Order(2)
    void testInvalidContactID() {
    	// Assertions
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact(null, "Jaden", "Knutson", "7016665555", "121 Music Lane");
        });
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("12345678901", "Jaden", "Knutson", "7016665555", "121 Music Lane");
        });
        
    	// Test Output message
        System.out.println("2.  Invalid Contact ID Test");
    } // END TEST
    
    //------------------------------------------------------------------
    // Test invalid First Name
    @Test
    @Order(3)
    void testInvalidFirstName() {
    	// Assertions
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("10101", null, "Knutson", "7016665555", "121 Music Lane");
        });
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("10101", "VeryLongFirstName", "Knutson", "7016665555", "121 Music Lane");
        });
        
    	// Test Output message
        System.out.println("3.  Invalid First Name Test");
    } // END TEST
    
    //------------------------------------------------------------------
    // Test invalid Last Name
    @Test
    @Order(4)
    void testInvalidLastName() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("10101", "Jaden", null, "7016665555", "121 Music Lane");
        });
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("10101", "Jaden", "VeryLongLastName", "7016665555", "121 Music Lane");
        });
        
    	// Test Output message
        System.out.println("4.  Invalid Last Name Test");
    } // END TEST
    
    //------------------------------------------------------------------
    // Test invalid Phone Number
    @Test
    @Order(5)
    void testInvalidPhone() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("10101", "Jaden", "Knutson", null, "121 Music Lane");
        });
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("10101", "Jaden", "Knutson", "123", "121 Music Lane");
        });
        
    	// Test Output message
        System.out.println("5.  Invalid Phone Number Test"); 
    } // END TEST
    
    //------------------------------------------------------------------
    // Test invalid Address
    @Test
    @Order(6)
    void testInvalidAddress() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("10101", "Jaden", "Knutson", "7016665555", null);
        });
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("10101", "Jaden", "Knutson", "7016665555", "This address is way too long to be valid");
        });
        
    	// Test Output messages
        System.out.println("6.  Invalid Address Test");
        System.out.println(); // Blank line
    } // END TEST
    
//=======================================================================================================	
    // Test First Name Setter
    @Test
    @Order(7)
    void testSetFirstName() {
        Contact contact = new Contact("10101", "Jaden", "Knutson", "7016665555", "121 Music Lane");
        //-----------------------------------
        contact.setFirstName("RICKY");

        System.out.println("7.  After first name update: " + contact); // Test Output message
        //-----------------------------------
       
        // Assertion
        assertEquals("RICKY", contact.getFirstName());
        assertThrows(IllegalArgumentException.class, () -> {
            contact.setFirstName(null);
        });
        assertThrows(IllegalArgumentException.class, () -> {
            contact.setFirstName("VeryLongFirstNameTEST");
        });
    } // END TEST
    
    //------------------------------------------------------------------
    // Test Last Name Setter
    @Test
    @Order(8)
    void testSetLastName() {
        Contact contact = new Contact("10101", "Jaden", "Knutson", "7016665555", "121 Music Lane");
        //-----------------------------------
        contact.setLastName("BOBBY");

        System.out.println("8.  After last name update: " + contact); // Test Output message
        //-----------------------------------
        // Assertion
        assertEquals("BOBBY", contact.getLastName());
        assertThrows(IllegalArgumentException.class, () -> {
            contact.setLastName(null);
        });
        assertThrows(IllegalArgumentException.class, () -> {
            contact.setLastName("VeryLongLastNameTEST");
        });
    } // END TEST
    
    //------------------------------------------------------------------
    // Test Phone Setter
    @Test
    @Order(9)
    void testSetPhone() {
        Contact contact = new Contact("10101", "Jaden", "Knutson", "7016665555", "121 Music Lane");
        //-----------------------------------
        contact.setPhone("7012223333");
    	// Test Output message
        System.out.println("9.  After phone update: " + contact);
        //-----------------------------------
        // Assertions
        assertEquals("7012223333", contact.getPhone());
        assertThrows(IllegalArgumentException.class, () -> {
            contact.setPhone(null);
        });
        assertThrows(IllegalArgumentException.class, () -> {
            contact.setPhone("123");
        });
    } // END TEST
    
    //------------------------------------------------------------------
    // Test Address Setter
    @Test
    @Order(10)
    void testSetAddress() {
        Contact contact = new Contact("10101", "Jaden", "Knutson", "7016665555", "121 Music Lane");
        //-----------------------------------
        contact.setAddress("101 Speedway Drive");
    	// Test Output message
        System.out.println("10. After address update: " + contact);
        //-----------------------------------
        // Assertions
        assertEquals("101 Speedway Drive", contact.getAddress());
        assertThrows(IllegalArgumentException.class, () -> {
            contact.setAddress(null);
        });
        assertThrows(IllegalArgumentException.class, () -> {
            contact.setAddress("Super Long Address Test Example");
        });
    } // END TEST
//=======================================================================================================    
} // END CLASS
//=======================================================================================================    
//=======================================================================================================    
