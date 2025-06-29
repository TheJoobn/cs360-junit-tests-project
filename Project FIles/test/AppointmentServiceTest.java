/*
Author: Jaden B. Knutson

Test cases must verify:
	1.Adding an appointment:
		The appointment is stored correctly.
		Retrieving the appointment returns the expected object.
	
	2.Adding a duplicate appointment ID:
		Throws an exception when trying to add an appointment with an existing ID.
	
	3.Deleting an appointment:
		Removes the appointment successfully.
		Retrieving the deleted appointment returns null.
	
	4.Deleting a non-existent appointment:
		Throws an exception when trying to delete an appointment that does not exist.
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
import mainPackage.AppointmentService;
//=======================================================================================================    
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class AppointmentServiceTest {
//=======================================================================================================    

    // Test adding a valid Appointment
	//1.Adding an appointment:
		//The appointment is stored correctly.
		//Retrieving the appointment returns the expected object.
    @Test
    @Order(1)
    void testAddValidAppointment() {
        AppointmentService service = new AppointmentService();
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DAY_OF_YEAR, 1);
        Date futureDate = cal.getTime();

        Appointment appointment = new Appointment("J11223", futureDate, "Dentist visit");
        service.addAppointment(appointment);

        // Assertions
        assertEquals(appointment, service.getAppointment("J11223"));

        System.out.println("\n1.  Adding Valid Appointment Test Passed: " + appointment);
        System.out.println(); // Blank line
    } // END TEST
    
    //=======================================================================================================
    // Test adding a duplicate Appointment ID
	//2.Adding a duplicate appointment ID:
		//Throws exception when trying to add an appointment with an already existing ID.
    @Test
    @Order(2)
    void testAddDuplicateAppointmentID() {
        AppointmentService service = new AppointmentService();
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DAY_OF_YEAR, 1);
        Date futureDate = cal.getTime();

        Appointment appointment1 = new Appointment("J11223", futureDate, "First visit");
        Appointment appointment2 = new Appointment("J11223", futureDate, "Duplicate visit");

        service.addAppointment(appointment1);

        // Assertions
        assertThrows(IllegalArgumentException.class, () -> service.addAppointment(appointment2));

        System.out.println("2.  Duplicate Appointment ID Test Passed");
    } // END TEST

    //------------------------------------------------------------------
    // Test deleting an appointment
	//3.Deleting an appointment:
		//Removes the appointment successfully.
		//Retrieving the deleted appointment returns null.
    @Test
    @Order(3)
    void testDeleteAppointment() {
        AppointmentService service = new AppointmentService();
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DAY_OF_YEAR, 1);
        Date futureDate = cal.getTime();

        Appointment appointment = new Appointment("J11223", futureDate, "Checkup");
        service.addAppointment(appointment);
        service.deleteAppointment("J11223");

        // Assertions
        assertNull(service.getAppointment("J11223"));

        System.out.println("3.  Delete Appointment Test Passed");
    } // END TEST

    //------------------------------------------------------------------
    // Test deleting a non-existent appointment
	//4.Deleting a non-existent appointment:
		//Throws exception when trying to delete a non existing appointment.
    @Test
    @Order(4)
    void testDeleteNonexistentAppointment() {
        AppointmentService service = new AppointmentService();

        // Assertions
        assertThrows(IllegalArgumentException.class, () -> service.deleteAppointment("A99999"));

        System.out.println("4.  Delete Nonexistent Appointment Test Passed");
    } // END TEST
//=======================================================================================================    
} // END CLASS
//=======================================================================================================
