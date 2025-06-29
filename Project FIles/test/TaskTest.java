//Author: Jaden B. Knutson

// Test for Task Class
package test;
import mainPackage.Task;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.TestMethodOrder;
//=======================================================================================================    
//=======================================================================================================    
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class TaskTest {
//=======================================================================================================    

    //------------------------------------------------------------------
    // Test valid task creation
    @Test
    @Order(1)
    void testValidTaskCreation() {
        Task task = new Task("12333", "Test Task", "valid description.");
    	// Test Output message
        System.out.println("1. Task Created: " + task);
        System.out.println(); // Blank line
        
        // Assertions - Verify valid task creation
        assertEquals("12333", task.getTaskId());
        assertEquals("Test Task", task.getName());
        assertEquals("valid description.", task.getDescription());
    } // END TEST

    //------------------------------------------------------------------
    // Test invalid task ID
    @Test
    @Order(2)
    void testInvalidTaskId() {
        System.out.println("2. Testing invalid task ID cases.");
        
        assertThrows(IllegalArgumentException.class, () -> new Task(null, "Valid Name", "Valid Description"));
        assertThrows(IllegalArgumentException.class, () -> new Task("12345678901", "Valid Name", "Valid Description"));

        System.out.println("2. Invalid task IDs were correctly rejected.");
        System.out.println(); // Blank line
    } // END TEST

    //------------------------------------------------------------------
    // Test invalid name
    @Test
    @Order(3)
    void testInvalidName() {
        System.out.println("3. Testing invalid name.");

        assertThrows(IllegalArgumentException.class, () -> new Task("12333", null, "Valid Description"));
        assertThrows(IllegalArgumentException.class, () -> new Task("12333", "This name is way too long for the limit", "Valid Description"));

        System.out.println("3. Invalid names were correctly rejected.");
        System.out.println(); // Blank line
    } // END TEST

    //------------------------------------------------------------------
    // Test invalid description
    @Test
    @Order(4)
    void testInvalidDescription() {
        System.out.println("4. Testing invalid description cases.");
        
        assertThrows(IllegalArgumentException.class, () -> new Task("12333", "Valid Name", null));
        assertThrows(IllegalArgumentException.class, () -> new Task("12333", "Valid Name", "This description is way too long to be accepted because it exceeds fifty characters."));

        System.out.println("4. Invalid descriptions were correctly rejected.");
        System.out.println(); // Blank line
    } // END TEST

    //------------------------------------------------------------------
    // Test updating task name and description
    @Test
    @Order(5)
    void testUpdateNameAndDescription() {
        Task task = new Task("12333", "Initial Name", "Initial Description");
        System.out.println("5. Before update: " + task);
        
        task.setName("Updated Name");
        task.setDescription("Updated Description");

        System.out.println("5. After update: " + task);
        System.out.println(); // Blank line

        // Assertions - Verify updates
        assertEquals("Updated Name", task.getName());
        assertEquals("Updated Description", task.getDescription());
    } // END TEST
//=======================================================================================================    
} // END CLASS
//=======================================================================================================    
//=======================================================================================================    
