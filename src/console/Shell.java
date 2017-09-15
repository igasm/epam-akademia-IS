package console;

import java.nio.file.FileSystems;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Shell {
	Writer writer;
	boolean working;
	int inputs;
	HashMap<String, CommandExecutor> params;
	
	public Shell() {
		this.writer = new Writer();
		this.working = true;
		this.inputs = 0;
		
		params = new HashMap<String, CommandExecutor>();
		params.put("statistics", new StatisticsExecutor());
		params.put("dir", new DirManager(FileSystems.getDefault().getPath(System.getProperties().getProperty("user.dir"))));
		params.put("exit", new ExitExecutor());
	}
	
	public void go() {
		Scanner scanner = new Scanner(System.in);
		
		while(CommandExecutor.isWorking()) {
			writer.go();
			String userInput = scanner.nextLine();
			parseInput(userInput);
		}
		
		scanner.close();
	}
	
	public void parseInput(String input) {
		this.inputs++;
		String[] tab = input.split(" ");
		String key = null;
		if(tab.length>0) {
			key = tab[0];
		}
		if(params.containsKey(key)) {
			params.get(key).execute();
		}
		else {
			if(input.contains("prompt")) {
				if(tab.length>1) {
					writer.changePrompt(tab[1]);
				}
			}else{
				StatisticsExecutor.increaseWrongCommands();
				System.out.println("["+input+"] : unknown command");
			}
		}
		
	}
	
	public void printer(ArrayList<String> list) {
		for(String s : list) {
			System.out.println(s);
		}
	}
		
}
