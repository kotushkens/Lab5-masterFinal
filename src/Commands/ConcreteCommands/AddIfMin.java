package Commands.ConcreteCommands;

import BasicClasses.Product;
import Commands.Command;
import Commands.CommandReceiver;

/**
 * Конкретная команда удаления объектов, которые меньше заданного.
 */


public class AddIfMin extends Command {
    private final CommandReceiver commandReceiver;

    public AddIfMin(CommandReceiver commandReceiver) {
        this.commandReceiver = commandReceiver;
    }

    @Override
    protected void execute(String[] args) {
        if (args.length > 1) {
            System.out.println("Введен ненужный аргумент. Команда приведена к базовой команде add_if_min.");
        }
        commandReceiver.add_if_min();
    }

    @Override
    protected void writeInfo() {
        System.out.println("Команда add_if_min - добавить новый элемент в коллекцию, если его значение меньше, чем у наименьшего элемента этой коллекции.");
    }
}

