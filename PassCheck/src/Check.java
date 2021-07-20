import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Check {

	public static void main(String[] args) {
		
		boolean found = false;
		
		try {
		System.out.println("Please enter your possible password: ");
		Scanner input = new Scanner(System.in);
		String password = input.nextLine();
		
		
		File dirPath = new File(".\\WordLists\\");
		File WordListArray[] = dirPath.listFiles();
		ArrayList<File> filesList = new ArrayList<File>();
		for (File f: WordListArray) {
			filesList.add(f);
		}
		for (File f : filesList) {
			Scanner Reader = new Scanner(f);
			while (Reader.hasNextLine()) {
				String out = Reader.nextLine();
				if (out.equals(password)) {	
					found = true;
					System.out.println("\"" + password + "\"" + " matches an entry on " + "\"" + f.getName() + "\"");
				}
			}
			Reader.close();
		}	
		if (found == false) 
			System.out.println("No matches were found");
		System.out.println("Process complete");
		input.close();
	} catch (FileNotFoundException e) {
		System.out.println("An error occured.");
		e.printStackTrace();
	}

}
}
