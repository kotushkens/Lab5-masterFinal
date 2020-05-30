package Commands.ConcreteCommands;

import Commands.Command;
import Commands.CommandReceiver;

/**
 *     Команда для вывода нескольких последних команд (без их аргументов).
 */

public class History extends Command {
        private final CommandReceiver commandReceiver;
        private static int bound;

        public History (CommandReceiver commandReceiver) {
            this.commandReceiver = commandReceiver;
        }

        @Override
        protected void execute(String[] args) {
            if (args.length > 1) {
                System.out.println("Введен не нужный аргумент. Команда приведена к базовой команде history.");
            }
            commandReceiver.history();
        }
    @Override
    protected void writeInfo() {
        System.out.println("Команда history - вывести последние 9 команд (без их аргументов).");
    }



}
