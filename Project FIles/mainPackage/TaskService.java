//Author: Jaden B. Knutson

//Requirements: 
// 1. The task service shall be able to add tasks with a unique ID.
// 2. The task service shall be able to delete tasks per task ID.
// 3. The task service shall be able to update task fields per task ID. 
// 4. The following fields are updatable:
		//Name
		//Description


package mainPackage;
//=======================================================================================================	
import java.util.HashMap;
import java.util.Map;
//=======================================================================================================	
//=======================================================================================================	
public class TaskService {
//=======================================================================================================	
	private final Map<String, Task> taskMap = new HashMap<>();

	//------------------------------------------------------------------
	// Constructor - Initialize TaskService with an empty HashMap.
	public TaskService() {
		System.out.println("TaskService initialized."); // Debug Output
	} // END CONSTRUCTOR

	//------------------------------------------------------------------
	// Validates task ID is unique before adding new task.
	public void addTask(String taskId, String name, String description) {
		if (taskMap.containsKey(taskId)) {
			throw new IllegalArgumentException("Task ID Already Exists!");
		}
		// Create and store new Task object.
		Task newTask = new Task(taskId, name, description);
		taskMap.put(taskId, newTask);
		System.out.println("   Task Added: " + newTask); // Debug Output
	} // END ADD TASK

	//------------------------------------------------------------------
	// Deletes a task using its task ID.
	public void deleteTask(String taskId) {
		if (!taskMap.containsKey(taskId)) {
			throw new IllegalArgumentException("Task ID Not Found!");
		}
		taskMap.remove(taskId);
		System.out.println("   Task Deleted: " + taskId); // Debug Output
	} // END DELETE TASK

	//------------------------------------------------------------------
	// Updates task name if task ID exists.
	public void updateTaskName(String taskId, String newName) {
		if (!taskMap.containsKey(taskId)) {
			throw new IllegalArgumentException("Task ID Not Found!");
		}
		taskMap.get(taskId).setName(newName);
		System.out.println("   Task Name Updated: " + newName); // Debug Output
	} // END UPDATE TASK NAME

	//------------------------------------------------------------------
	// Updates task description if task ID exists.
	public void updateTaskDescription(String taskId, String newDescription) {
		if (!taskMap.containsKey(taskId)) {
			throw new IllegalArgumentException("Task ID Not Found!");
		}
		taskMap.get(taskId).setDescription(newDescription);
		System.out.println("   Task Description Updated: " + newDescription); // Debug Output
	} // END UPDATE TASK DESCRIPTION

	//------------------------------------------------------------------
	// Retrieves task by task ID.
	public Task getTask(String taskId) {
		return taskMap.get(taskId);
	} // END GET TASK
//=======================================================================================================	
} // END CLASS
//=======================================================================================================	
//=======================================================================================================	