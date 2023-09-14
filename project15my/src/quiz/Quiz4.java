package quiz;

import java.io.File;
import java.io.FileWriter;

public class Quiz4 {

	public static void main(String[] args) {
		File file = new File("C:\\atemp\\quiz4.txt");
		File dir = new File("C:\\atemp");
		
		File[] files = dir.listFiles();
		
		try {
			file.createNewFile();
			
			
			for (int i = 0; i < files.length; i++) {	
				FileWriter fw = new FileWriter(file, true);
				fw.write(files[i].getAbsolutePath() + "\n");
				fw.flush();
			}
			
			
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
