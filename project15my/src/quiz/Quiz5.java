package quiz;

import java.io.File;
import java.io.FileWriter;

public class Quiz5 {

	public static void main(String[] args) {
		File dir1 = new File("C:\\atemp");
		findDir(dir1);
		System.out.println("=== 프로그램이 정상 종료됩니다. ===");
	}
	
	public static void findDir(File dir) {
		File file = new File("C:\\atemp\\quiz5.txt");
		File[] files = dir.listFiles();
		
		try {
			for (int i = 0; i < files.length; i++) {
				if (files[i].isDirectory()) {
					File newdir = files[i];
					System.out.println("새로운 하위 디렉터리 " + newdir + "을 찾았습니다.");
					findDir(newdir);
					
				} else {
					for (int j = 0; j < files.length; j++) {	
						FileWriter fw = new FileWriter(file, true);
						fw.write(files[j].getAbsolutePath() + "\n");
						fw.flush();
					}
				}  
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		
	}
}

