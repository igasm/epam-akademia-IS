package console;

import java.io.File;
import java.nio.file.Path;
import java.util.ArrayList;

public class DirManager extends CommandExecutor{
	private Path currentDir;

	public DirManager(Path currentDir) {
		super();
		this.currentDir = currentDir;
	}
	
	private ArrayList<String> listFiles(){
		ArrayList<String> files = new ArrayList<String>();
		File file = new File(currentDir.toString());
		String[] filesTab = file.list();
		for(String f : filesTab) {
			files.add(f);
		}
		return files;
	}

	@Override
	public void execute() {
		for(String s : listFiles()) {
			System.out.println(s);
		}
		this.increaseRightCommands();
	}
	
	
	
}
