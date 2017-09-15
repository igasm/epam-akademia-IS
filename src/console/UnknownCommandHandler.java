package console;

public class UnknownCommandHandler {
	static int commandCount;
	
	public static int getCommandCount() {
		return commandCount;
	}

	public static String handle(String command) {
		String message = "["+command+"] : unknown command";
		commandCount++;
		return message;
	}
	
	
}
