// Tristan Tapson
// 001319964
// NOTE!: package was used for all classes, called robot

package robot;

// @brief InvalidRegionException class
// @details raises an exception if the region is not within constants constraints
@SuppressWarnings("serial")
public class InvalidRegionException extends Exception {
	
	// @brief InvalidRegionException method
	// @details message is displayed if the exception is thrown
	// @param message the string message to be displayed
	public InvalidRegionException(String message) {
	    super(message); 
	}
}
