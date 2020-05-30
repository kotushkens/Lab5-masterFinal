package Commands.ConcreteCommands;

import Commands.Command;
import Commands.CommandReceiver;

/**
 * Команда для вывода первого элемента коллекции.
 */
public class Head extends Command {
    private final CommandReceiver commandReceiver;

    public Head (CommandReceiver commandReceiver) {
        this.commandReceiver = commandReceiver;
    }

    @Override
    protected void execute(String[] args) {
        if (args.length > 1) {
            System.out.println("Введен ненужный аргумент. Команда приведена к базовой команде head.");
        }
        commandReceiver.head();
    }

    @Override
    protected void writeInfo() {
        System.out.println("Команда head – вывести первый элемент коллекции.");
    }
}
