package console;

import java.util.Scanner;

public class Shell {
	Writer writer;
	boolean working;
	int inputs;
	
	public Shell() {
		this.writer = new Writer();
		this.working = true;
		this.inputs = 0;
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
			
		}else {
			UnknownCommandHandler.handle(input);
		}
		
	}
	
	public void showStatitics() {
		System.out.println("[statistics] : " + (inputs - UnknownCommandHandler.getCommandCount()) + " : " + UnknownCommandHandler.getCommandCount()); 
	}
		
}
