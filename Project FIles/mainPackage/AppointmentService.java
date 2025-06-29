/*
Author: Jaden B. Knutson

The AppointmentService must:
	
	1.Store appointments in an in-memory data structure (no database required).
	
	2.Add appointments:
		Each appointment must have a unique ID.
		If an appointment with the same ID already exists, an exception must be thrown.
	
	3.Delete appointments:
		Must remove the appointment using the appointment ID.
		If the ID does not exist, an exception must be thrown.
 */

package mainPackage;
//------------------------------------------------------------------
import java.util.HashMap;
import java.util.Map;
//=======================================================================================================    
// APPOINTMENT SERVICE CLASS
//=======================================================================================================    
public class AppointmentService {
//=======================================================================================================    

//1. Data structure to store appointments
    private final Map<String, Appointment> appointments = new HashMap<>();

//------------------------------------------------------------------
//2.Add appointments:
	//Each appointment must have a unique ID.
	//If an appointment with the same ID already exists, an exception must be thrown.
    public void addAppointment(Appointment appointment) {
        if (appointments.containsKey(appointment.getAppointmentId())) {
            throw new IllegalArgumentException("Error: Appointment ID already exists");
        }
        appointments.put(appointment.getAppointmentId(), appointment);
    }

//------------------------------------------------------------------
//3.Delete appointments:
	//Must remove the appointment using the appointment ID.
	//If the ID does not exist, an exception must be thrown.
    public void deleteAppointment(String appointmentId) {
        if (!appointments.containsKey(appointmentId)) {
            throw new IllegalArgumentException("Error: Appointment ID not found");
        }
        appointments.remove(appointmentId);
    }

//------------------------------------------------------------------
//4.Method: Retrieve Appointment
    public Appointment getAppointment(String appointmentId) {
        return appointments.get(appointmentId);
    }

//=======================================================================================================    
} // END CLASS
//=======================================================================================================

