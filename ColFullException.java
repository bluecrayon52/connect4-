/*  
 * Author: Nathaniel Clay Arnold
 * Program 2 - C4
 * CSC230-02 Spring 2016
 */

package mygame;
 
// custom exception class that extends RuntimeException for full columns 

public class ColFullException extends RuntimeException {

    public ColFullException() {
        super();
    }

    public ColFullException(String message) {
        super(message);
    }
}
