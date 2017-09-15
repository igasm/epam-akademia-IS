package console;

public class ExitExecutor extends CommandExecutor {

	@Override
	public void execute() {
		this.setWorking(false);
	}

}
