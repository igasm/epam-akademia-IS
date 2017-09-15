package console;

public class StatisticsExecutor extends CommandExecutor {
	
	@Override
	public void execute() {
		System.out.println("[statistics] : " + CommandExecutor.getRightCommands() + " : " + CommandExecutor.getWrongCommands());
		CommandExecutor.increaseRightCommands();
	}

}
