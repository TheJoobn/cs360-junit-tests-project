//Author: Jaden B. Knutson

// Test for TaskService Class
package test;
import mainPackage.TaskService;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.TestMethodOrder;
//=======================================================================================================    
//=======================================================================================================    
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class TaskServiceTest {
//=======================================================================================================    
    private TaskService taskService;
    
    //------------------------------------------------------------------
    // Setup before each test
    @BeforeEach
    @Order(1)
    void setUp() {
        taskService = new TaskService();
    	// Test Output message
        System.out.println("1. Setup Complete - TaskService Initialized");
    } // END SETUP

    //------------------------------------------------------------------
    // Test adding a single task
    @Test
    @Order(2)
    void testAddTask() {
        taskService.addTask("12333", "Test Task", "This is a test for task.");
        System.out.println("2. Task Added: 12333 - Test Task");
        System.out.println(); // Blank line

        // Assertion - Verify task addition
        assertNotNull(taskService.getTask("12333"));
    } // END TEST

    //------------------------------------------------------------------
    // Test adding duplicate task ID
    @Test
    @Order(3)
    void testAddDuplicateTaskId() {
        taskService.addTask("12333", "Task One", "Description One for Task One");
        System.out.println("3. Added Task One: 12333");

        // Attempt adding duplicate task
        assertThrows(IllegalArgumentException.class, () -> taskService.addTask("12333", "Task Two", "Description Two for Task Two"));

        System.out.println("3. Duplicate Task ID Rejected");
        System.out.println(); // Blank line
    } // END TEST

    //------------------------------------------------------------------
    // Test deleting a task
    @Test
    @Order(4)
    void testDeleteTask() {
        taskService.addTask("12333", "Task to Delete", "Delete this task.");
        System.out.println("4. Task Added for Deletion: 12333");

        taskService.deleteTask("12333");
        System.out.println("4. Task Deleted: 12333");

        // Assertion - Verify task deletion
        assertNull(taskService.getTask("12333"));
        System.out.println(); // Blank line
    } // END TEST

    //------------------------------------------------------------------
    // Test deleting a non-existent task
    @Test
    @Order(5)
    void testDeleteNonExistentTask() {
        System.out.println("5. Attempting to Delete Non-Existent Task");
        
        assertThrows(IllegalArgumentException.class, () -> taskService.deleteTask("99999"));

        System.out.println("5. Non-Existent Task Deletion Correctly Rejected");
        System.out.println(); // Blank line
    } // END TEST

    //------------------------------------------------------------------
    // Test updating a task name
    @Test
    @Order(6)
    void testUpdateTaskName() {
        taskService.addTask("12333", "Old Name", "Some description");
        System.out.println("6. Task Added with Old Name: 12333");

        taskService.updateTaskName("12333", "New Name");
        System.out.println("6. Task Name Updated: New Name");

        // Assertion - Verify update
        assertEquals("New Name", taskService.getTask("12333").getName());
        System.out.println(); // Blank line
    } // END TEST

    //------------------------------------------------------------------
    // Test updating a task description
    @Test
    @Order(7)
    void testUpdateTaskDescription() {
        taskService.addTask("12333", "Some Task", "Old description");
        System.out.println("7. Task Added with Old Description: 12333");

        taskService.updateTaskDescription("12333", "New description");
        System.out.println("7. Task Description Updated: New description");

        // Assertion - Verify update
        assertEquals("New description", taskService.getTask("12333").getDescription());
        System.out.println(); // Blank line
    } // END TEST

    //------------------------------------------------------------------
    // Test updating a non-existent task
    @Test
    @Order(8)
    void testUpdateNonExistentTask() {
        System.out.println("8. Attempting to Update Non-Existent Task");

        assertThrows(IllegalArgumentException.class, () -> taskService.updateTaskName("99999", "New Name"));
        assertThrows(IllegalArgumentException.class, () -> taskService.updateTaskDescription("99999", "New Description"));

        System.out.println("8. Non-Existent Task Update Correctly Rejected");
        System.out.println(); // Blank line
    } // END TEST
//=======================================================================================================    
} // END CLASS
//=======================================================================================================    
//================================================================================================