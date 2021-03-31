// Cody Milne

package Main;

import java.util.Scanner;

public class KeyboardInput {
	// Fields
	private Scanner keyb;
	
	// Constructor
	public KeyboardInput(){
		keyb = new Scanner(System.in);
	}
	
	// Methods
	public String getKeyboardLine(){
		return keyb.nextLine();
	}
	
	/* Call this method before you exit the program! Do NOT close the scanner object inside of getKeyboardLine method! */
	public void closeKeyboard(){
		keyb.close();
	}
}
