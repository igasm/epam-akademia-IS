package console;

public abstract class CommandExecutor {
	private static int rightCommands;
	private static int wrongCommands;
	private static boolean working = true;
	
	public static boolean isWorking() {
		return working;
	}

	protected static void setWorking(boolean working) {
		CommandExecutor.working = working;
	}

	public static int getRightCommands() {
		return rightCommands;
	}

	public static int getWrongCommands() {
		return wrongCommands;
	}

	public abstract void execute();
	
	public static void increaseRightCommands() {
		rightCommands++;
	}
	
	public static void increaseWrongCommands() {
		wrongCommands++;
	}
}
