
public class Tasks {
    // Private member variables
    private int priority;    // Stores the priority of the task
    private String Action;   // Stores the action/description of the task
    
    // Constructor to initialize the task with a priority and an action
    public Tasks(int aP, String aA) {
        this.setPriority(aP);  // Set the priority using setter
        this.setAction(aA);    // Set the action using setter
    }
    
    // Getter method for priority
    public int getPriority() {
        return priority;
    }
    
    // Setter method for priority
    public void setPriority(int priority) {
        this.priority = priority;
    }
    
    // Getter method for action
    public String getAction() {
        return Action;
    }
    
    // Setter method for action
    public void setAction(String action) {
        Action = action;
    }
    
    // Overriding toString() to return a custom string representation of a task
    public String toString() {
        return "Priority " + this.getPriority() + " Task: " + this.getAction();
    }
    
    // Custom equals method to compare two Tasks objects
    public boolean equals(Tasks other) {
        return this.getPriority() == other.getPriority() && this.getAction().equals(other.getAction());
    }
}
