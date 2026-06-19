import java.beans.PropertyVetoException;

public class BeanTester {
    public static void main(String[] args) {
        StudentBean student = new StudentBean();

        // 1. Listen for standard Bound Property changes
        student.addPropertyChangeListener(evt -> {
            System.out.println("[Bound Event] Property '" + evt.getPropertyName() + 
                               "' changed from " + evt.getOldValue() + " to " + evt.getNewValue());
        });

        // 2. Listen for Constrained Property changes (and set rules)
        student.addVetoableChangeListener(evt -> {
            if ("age".equals(evt.getPropertyName())) {
                int newAge = (Integer) evt.getNewValue();
                if (newAge < 18) {
                    System.out.println("[Veto Event] REJECTED: Age " + newAge + " is too young!");
                    // Throwing this exception stops the setter method in the Bean from completing
                    throw new PropertyVetoException("Age must be 18 or older", evt);
                } else {
                    System.out.println("[Veto Event] ACCEPTED: Age " + newAge + " is valid.");
                }
            }
        });

        // --- Execute Tests ---
        System.out.println("--- Testing Bound Property ---");
        student.setCourseName("Data Structures");

        System.out.println("\n--- Testing Constrained Property (Valid) ---");
        try {
            student.setAge(20); 
            System.out.println("Current Student Age: " + student.getAge());
        } catch (PropertyVetoException e) {
            System.out.println("Error: " + e.getMessage());
        }

        System.out.println("\n--- Testing Constrained Property (Invalid) ---");
        try {
            student.setAge(16); // This will trigger the VetoException
            System.out.println("Current Student Age: " + student.getAge());
        } catch (PropertyVetoException e) {
            System.out.println("Exception Caught: " + e.getMessage());
            System.out.println("Current Student Age remains: " + student.getAge());
        }
    }
}