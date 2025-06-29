//Author: Jaden B. Knutson

//Requirements:
	//The task object shall have a required unique task ID String that cannot be longer than 10 characters. 
	//The task ID shall not be null and shall not be updatable.
	
	//The task object shall have a required name String field that cannot be longer than 20 characters. 
	//The name field shall not be null.
	
	//The task object shall have a required description String field that cannot be longer than 50 characters. 
	//The description field shall not be null.

//=======================================================================================================
package mainPackage;
//=======================================================================================================	
//=======================================================================================================	
public class Task {
//=======================================================================================================	
	private final String taskId;
	private String name;
	private String description;

	//------------------------------------------------------------------
	// Constructor - Validates inputs before initializing Task object.
	public Task(String taskId, String name, String description) {
		if (taskId == null || taskId.length() > 10) {
			throw new IllegalArgumentException("Task ID must not be null / at most 10 characters.");
		}
		if (name == null || name.length() > 20) {
			throw new IllegalArgumentException("Name must not be null / at most 20 characters.");
		}
		if (description == null || description.length() > 50) {
			throw new IllegalArgumentException("Description must not be null / at most 50 characters.");
		}
		this.taskId = taskId;
		this.name = name;
		this.description = description;
	} // END CONSTRUCTOR

	//------------------------------------------------------------------
	// Getters - Retrieve task details.
	public String getTaskId() {
		return taskId;
	} // END GET TASK ID

	public String getName() {
		return name;
	} // END GET NAME

	public String getDescription() {
		return description;
	} // END GET DESCRIPTION

	//------------------------------------------------------------------
	// Setters - Update allowed fields (Name, Description).
	public void setName(String name) {
		if (name == null || name.length() > 20) {
			throw new IllegalArgumentException("Name mmust not be null / at most 20 characters.");
		}
		this.name = name;
	} // END SET NAME

	public void setDescription(String description) {
		if (description == null || description.length() > 50) {
			throw new IllegalArgumentException("Description must not be null / at most 50 characters.");
		}
		this.description = description;
	} // END SET DESCRIPTION
//=======================================================================================================	
} // END CLASS
//=======================================================================================================	
//=========================================================================