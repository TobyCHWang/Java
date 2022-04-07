package manager;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class WordTracker {
	
	public WordTracker() throws IOException {
		Scanner input = new Scanner(System.in);
		System.out.println("Enter file location: ");
		String fileLoc = input.nextLine();
		loadFile(fileLoc);
	}

	private void loadFile(String fileLoc) throws IOException {
		File file = new File(fileLoc);
		BufferedReader fin = new BufferedReader(new FileReader(file));
		String line;

		while ((line = fin.readLine()) != null) {
            System.out.println(line);
        }
		
	}

}
