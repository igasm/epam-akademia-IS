package console;

import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

public class Shell {
	Writer writer;
	boolean working;
	int inputs;
	DirManager dirManager;
	
	public Shell() {
		this.writer = new Writer();
		this.working = true;
		this.inputs = 0;
		this.dirManager = new DirManager(FileSystems.getDefault().getPath(System.getProperties().getProperty("user.dir")));
	}
	
	public void go() {
		Scanner scanner = new Scanner(System.in);
		
		while(working) {
			writer.go();
			String userInput = scanner.nextLine();
			parseInput(userInput);
		}
		
		scanner.close();
	}
	
	public void parseInput(String input) {
		this.inputs++;
		
		if(input.contains("prompt")) {
			String[] tab = input.split(" ");
			if(tab.length>1) {
				writer.changePrompt(tab[1]);
			}
		}else if(input.trim().equals("exit")) {
			working = false;
		}else if(input.trim().equals("statistics")){
			this.showStatitics();
		}else if(input.equals("dir")) {
			printer(dirManager.listFiles());
		}else {
			System.out.println(UnknownCommandHandler.handle(input));
		}
		
	}
	
	public void showStatitics() {
		System.out.println("[statistics] : " + (inputs - UnknownCommandHandler.getCommandCount()) + " : " + UnknownCommandHandler.getCommandCount()); 
	}
	
	public void printer(ArrayList<String> list) {
		for(String s : list) {
			System.out.println(s);
		}
	}
		
}
