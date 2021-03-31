// Cody Milne

package Main;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class FileWrite {
	// Fields
	private ArrayList<String> writeBuffer;
	private String filename;
	
	// Constructor
	public FileWrite(String filename){
		this.filename = filename;			// Save filename for later
		writeBuffer = new ArrayList<>();
	}
	
	//Methods
	public void writeLine(String newLine){
		// Add the newLine to the writeBuffer...
		writeBuffer.add(newLine);
	}
	
	public void saveFile(){
		FileWriter writer;
		try {
			//create a FileWriter object to write lines to the file
			writer = new FileWriter(filename, true);
			BufferedWriter buffer = new BufferedWriter(writer);
			//Save all of the lines in the writeBuffer to the file
			for (String line: writeBuffer) {
				buffer.write("\n" + line);
			}
			writeBuffer.clear();
			//close writer
			buffer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// This method writes contents to the output file after deleting all previous content
	 
	public void delete(){
		FileWriter writer = null;
		try {
			//create a FileWriter object to write lines to the file
			writer = new FileWriter(filename);
			BufferedWriter buffer = new BufferedWriter(writer);
			//Save all of the lines in the writeBuffer to the file
			for (String line: writeBuffer) {
				buffer.write(line + "\n");
			}
			writeBuffer.clear();
			//close writer
			buffer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
