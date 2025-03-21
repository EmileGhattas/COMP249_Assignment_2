//
// Assignment 2
// Question:
// Written by: Emile Ghattas (id: 40282552) and Ryan Khaled (id: 40307741)
//

/**
 * a custom checked exception that is thrown when an employee's hourly wage
 * is below the legal minimum of $15.75.
 */
public class MinimumWageException extends Exception {

    /**
     * creates a new MinimumWageException with a custom message.
     *
     * @param message the detail message for this exception
     */
    public MinimumWageException(String message) {
        super(message);
    }
}
