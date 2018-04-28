// Tristan Tapson
// 001319964
// NOTE!: package was used for all classes, called robot

package robot;

// @brief FullSequenceException class
// @details raises an exception if list size goes over MAX_SIZE
@SuppressWarnings("serial")
public class FullSequenceException extends Exception {

	// @brief FullSequenceException method
	// @details message is displayed if the exception is thrown
	// @param message the string message to be displayed
	public FullSequenceException(String message) {
        super(message);
    }
}
