package console;

import java.io.File;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Iterator;

public class DirManager {
	private Path currentDir;

	public DirManager(Path currentDir) {
		super();
		this.currentDir = currentDir;
	}
	
	public ArrayList<String> listFiles(){
		ArrayList<String> files = new ArrayList<String>();
		File file = new File(currentDir.toString());
		String[] filesTab = file.list();
		for(String f : filesTab) {
			files.add(f);
		}
		return files;
	}
	
	
	
}
