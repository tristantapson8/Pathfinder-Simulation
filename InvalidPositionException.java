// Tristan Tapson
// 001319964
// NOTE!: package was used for all classes, called robot

package robot;

// @brief InvalidPositionException class
// @details raises an exception if the element is already present in a list
@SuppressWarnings("serial")
public class InvalidPositionException extends Exception {

	// @brief InvalidPositionException method
	// @details message is displayed if the exception is thrown
	// @param message the string message to be displayed
	public InvalidPositionException(String message) {
	    super(message); 
	}
}
