package Commands.ConcreteCommands;

import Commands.Command;
import Commands.CommandReceiver;

/**
 * Команда для вывода по заданному PartNumber.
 */

public class FilterContainsPartNumber extends Command {
    private final CommandReceiver commandReceiver;

    public FilterContainsPartNumber(CommandReceiver commandReceiver) {
        this.commandReceiver = commandReceiver;
    }

    @Override
    protected void execute(String[] args) {
        if (args.length > 2) {
            System.out.println("Введен ненужный аргумент. Команда приведена к базовой команде filter_contains_part_number.");
        }
        commandReceiver.filter_contains_part_number(args[1]);
    }

    @Override
    protected void writeInfo() {
        System.out.println("Команда filter_contains_part_number  – вывести элементы, значение поля partNumber которых содержит заданную подстроку.");
    }
}
