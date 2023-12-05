package command;

public class ModulCommand implements Command {

	@Override
	public float calc(int i, int j) {

		return (float)i % (float)j;
	}
}
