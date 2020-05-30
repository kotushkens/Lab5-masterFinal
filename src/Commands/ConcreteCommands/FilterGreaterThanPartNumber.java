package Commands.ConcreteCommands;

import Commands.Command;
import Commands.CommandReceiver;

/**
 * Команда для вывода элементов, значение поля partNumber которых больше заданного
 */

public class FilterGreaterThanPartNumber extends Command {
        private final CommandReceiver commandReceiver;

    public FilterGreaterThanPartNumber(CommandReceiver commandReceiver) {
        this.commandReceiver = commandReceiver;
    }

        @Override
        protected void execute(String[] args) {
        if (args.length > 2) {
            System.out.println("Введен ненужный аргумент. Команда приведена к базовой команде filter_greater_than_part_number %part_number%.");
        }
        commandReceiver.filter_greater_than_part_number(args[1]);
    }

        @Override
        protected void writeInfo() {
        System.out.println("Команда filter_greater_than_part_number - вывести элементы, значение поля partNumber которых больше заданного");
    }

}
