package console;

public class UnknownCommandHandler {
	static int commandCount;
	
	public static int getCommandCount() {
		return commandCount;
	}

	public static void handle(String command) {
		System.out.println("["+command+"] : unknown command");
		commandCount++;
	}
	
	
}
