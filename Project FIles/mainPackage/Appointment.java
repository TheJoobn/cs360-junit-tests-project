/*
Author: Jaden B. Knutson

The Appointment object must have:
	
	2.A unique appointment ID:
		Cannot be longer than 10 characters.
		Cannot be null.
		Cannot be updated.
	
	3.A required appointment Date field:
		Cannot be null.
		Cannot be in the past.
	
	4.A required description field:
		Cannot be null.
		Cannot be longer than 50 characters.
 */

package mainPackage;
//------------------------------------------------------------------
import java.util.Date;
//=======================================================================================================    
// APPOINTMENT CLASS
//=======================================================================================================    
public class Appointment {
//=======================================================================================================    

    // Fields
    private final String appointmentId;
    private final Date appointmentDate;
    private final String description;
//------------------------------------------------------------------

    // Constructor
    public Appointment(String appointmentId, Date appointmentDate, String description) {
    
//------------------------------------------------------------------
    //2.Validate unique appointment ID:
		//Cannot be longer than 10 characters.
		//Cannot be null.
		//Cannot be updated.
        if (appointmentId == null || appointmentId.length() > 10) {
            throw new IllegalArgumentException("Error: Invalid appointment ID");
        }
//------------------------------------------------------------------       
	//3.Validate appointment date 
		//Cannot be null.
		//Cannot be in the past.
        if (appointmentDate == null || appointmentDate.before(new Date())) {
            throw new IllegalArgumentException("Error: Invalid appointment date");
        }
//------------------------------------------------------------------       
	//4.Validate description
		//Cannot be null.
		//Cannot be longer than 50 characters.
        if (description == null || description.length() > 50) {
            throw new IllegalArgumentException("Error: Invalid description");
        }
//------------------------------------------------------------------     
//------------------------------------------------------------------  
    // Assign values - ID, Date, Description
        this.appointmentId = appointmentId;
        this.appointmentDate = new Date(appointmentDate.getTime()); 
        this.description = description;
    }

//=======================================================================================================    
    // Getters
    public String getAppointmentId() {
        return appointmentId;
    }

    public Date getAppointmentDate() {
        return new Date(appointmentDate.getTime()); 
    }

    public String getDescription() {
        return description;
    }

//=======================================================================================================    
} // END CLASS
//=======================================================================================================
