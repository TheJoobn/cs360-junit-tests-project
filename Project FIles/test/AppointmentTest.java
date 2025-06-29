/*
Author: Jaden B. Knutson - Sorry for forgetting this last time.

Test cases must verify:
	
	1.Valid Appointment Creation:
		A valid appointment object is successfully created with a valid ID, date, and description.
	
	2. Invalid Appointment ID:
		Throws an exception when:
			The ID is null.
			The ID is longer than 10 characters.
	
	3.Invalid Appointment Date:
		Throws an exception when:
			The date is null.
			The date is in the past.
	
	4.Invalid Description:
		Throws an exception when:
			The description is null.
			The description is longer than 50 characters.
 */

package test;
//------------------------------------------------------------------
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.TestMethodOrder;
import java.util.Date;
import java.util.Calendar;
import mainPackage.Appointment;
//=======================================================================================================    
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class AppointmentTest {
//=======================================================================================================    

//1.Test valid Appointment creation
	//A valid appointment object is created with a valid: ID, date, and description.
    @Test
    @Order(1)
    void testValidAppointmentCreation() {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DAY_OF_YEAR, 1);
        Date futureDate = cal.getTime();

        Appointment appointment = new Appointment("J11223", futureDate, "Doctor visit");

        // Test Output messages
        System.out.println("\n1.  Testing valid appointment creation:");
        
        // Assertions
        assertEquals("J11223", appointment.getAppointmentId());
        assertEquals(futureDate, appointment.getAppointmentDate());
        assertEquals("Doctor visit", appointment.getDescription());

        System.out.println("1.  APPOINTMENT CREATION TEST PASSED: " + appointment);
        System.out.println(); // Blank line
    } // END TEST
    
//=======================================================================================================    
//2.Test invalid Appointment ID
	//Throws an exception when:The ID is null.
	//Throws an exception when: The ID is longer than 10 characters.
    @Test
    @Order(2)
    void testInvalidAppointmentID() {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DAY_OF_YEAR, 1);
        Date futureDate = cal.getTime();

        // Assertions
        assertThrows(IllegalArgumentException.class, () -> new Appointment(null, futureDate, "Checkup"));
        assertThrows(IllegalArgumentException.class, () -> new Appointment("12345678901", futureDate, "Checkup"));

        System.out.println("2.  Invalid Appointment ID Test Passed");
    } // END TEST
    
//------------------------------------------------------------------
//3.Test invalid Appointment Date
	//Throws an exception when: The date is null.
	//Throws an exception when: The date is in the past.
    @Test
    @Order(3)
    void testInvalidAppointmentDate() {
        //Date pastDate = new Date(System.currentTimeMillis() - 86400000); // Yesterday millis test for fun
    	
    	Calendar cal = Calendar.getInstance();
    	cal.add(Calendar.DAY_OF_YEAR, -1); // Move 1 day back
    	Date pastDate = cal.getTime();
    	
        // Assertions
        assertThrows(IllegalArgumentException.class, () -> new Appointment("J11223", pastDate, "Past appointment"));

        System.out.println("3.  Invalid Appointment Date Test Passed");
    } // END TEST
    
//------------------------------------------------------------------
//4.Test invalid Description
	//Throws an exception when: The description is null.
	//Throws an exception when: The description is longer than 50 characters.
    @Test
    @Order(4)
    void testInvalidDescription() {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DAY_OF_YEAR, 1);
        Date futureDate = cal.getTime();
        
        // Assertions
        assertThrows(IllegalArgumentException.class, () -> new Appointment("J11223", futureDate, null));
        assertThrows(IllegalArgumentException.class, () -> new Appointment("J11223", futureDate, "aAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA"));

        System.out.println("4.  Invalid Description Test Passed");
    } // END TEST
//=======================================================================================================    
} // END CLASS
//=======================================================================================================
