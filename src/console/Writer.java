package console;

import java.nio.file.FileSystems;

public class Writer {
	private final String name = "MySell";
	private final String promptSuffix = ">";
	private String promptPrefix;
	
	public String getPromptPrefix() {
		return promptPrefix;
	}

	public void setPromptPrefix(String promptPrefix) {
		this.promptPrefix = promptPrefix;
	}

	public String getPrompt() {
		return promptPrefix+this.promptSuffix;
	}
	
	public Writer() {
		super();
		this.promptPrefix = "$";
	}
	
	public void go() {
		System.out.print("["+this.name+"] " + this.promptPrefix + this.promptSuffix);
	}

	public void changePrompt(String command) {
		command = command.trim();
		if(command.equals("reset")) {
			this.promptPrefix = "$";
		}else if(command.equals("$cwd")) {
			this.promptPrefix = System.getProperties().getProperty("user.dir");
		}else {
			this.promptPrefix = command;
		}
	}
	
	
	
	
	
	
}
