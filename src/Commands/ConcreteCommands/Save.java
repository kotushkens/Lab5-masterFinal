package Commands.ConcreteCommands;

import Commands.Command;
import Commands.CommandReceiver;

/**
 * Команда для сохранения.
 */
public class Save extends Command {
    private final CommandReceiver commandReceiver;

    public Save(CommandReceiver commandReceiver) {
        this.commandReceiver = commandReceiver;
    }

    @Override
    protected void execute(String[] args) {
        if (args.length > 1) {
            System.out.println("Введен ненужный аргумент. Команда приведена к базовой команде save.");
        }
        commandReceiver.save();
    }

    @Override
    protected void writeInfo() {
        System.out.println("Команда save – сохранить коллекцию в файл.");
    }
}
