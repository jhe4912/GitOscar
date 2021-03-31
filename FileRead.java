// Cody Milne

package Main;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class FileRead {
	// Fields
	private ArrayList<String> lines;
	
	// Constructor
	public FileRead(String filename){
		lines = new ArrayList<>();
		try {
			//Open the filename
			Scanner fileScanner = new Scanner(new File(filename));
			//read data in the files into the lines arraylist
			while (fileScanner.hasNextLine()) {
				lines.add(fileScanner.nextLine());
			}
			//close file
			fileScanner.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	// Methods
	public int getNumberOfLines(){
		return lines.size();
	}
	
	public String getLine(int index){
		return lines.get(index);
	}
}
