package Start;

import java.io.*;



public interface Saveable {
	public void save(String file);
	public static void write_to_file(String fileName, String text) {
		try {
			FileWriter file = new FileWriter(fileName);
			file.write(text);
			file.close();
		} catch(IOException e) {
			System.out.println("Error in sabing youre data");
		}
	}
}