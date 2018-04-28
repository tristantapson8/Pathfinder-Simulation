// Tristan Tapson
// 001319964
// NOTE!: package was used for all classes, called robot

package robot;

// @brief InvalidPointException class
// @details raises an exception if the point is not within constants constraints
@SuppressWarnings("serial")
public class InvalidPointException extends Exception {

	// @brief InvalidPointException method
	// @details message is displayed if the exception is thrown
	// @param message the string message to be displayed
	public InvalidPointException(String message) {
	    super(message); 
	}
}
