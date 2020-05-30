import Collection.CollectionManager;
import Commands.CommandInvoker;
import Commands.CommandReceiver;
import Commands.ConcreteCommands.*;

import java.io.IOException;
import java.util.Scanner;

/**
 * Класс управления консолью и регистрацией команд.
 */
class ConsoleManager {
    void startInteractiveMode() throws IOException {
        CommandInvoker commandInvoker = new CommandInvoker();
        CommandReceiver commandReceiver = new CommandReceiver(commandInvoker);
        CollectionManager.initList();

        commandInvoker.register("help", new Help(commandReceiver));
        commandInvoker.register("add", new Add(commandReceiver));
        commandInvoker.register("info", new Info(commandReceiver));
        commandInvoker.register("show", new Show(commandReceiver));
        commandInvoker.register("update", new Update(commandReceiver));
        commandInvoker.register("remove_by_id", new RemoveByID(commandReceiver));
        commandInvoker.register("clear", new Clear(commandReceiver));
        commandInvoker.register("exit", new Exit(commandReceiver));
        commandInvoker.register("head", new Head(commandReceiver));
        commandInvoker.register("execute_script", new ExecuteScript(commandReceiver));
        commandInvoker.register("save", new Save(commandReceiver));
        commandInvoker.register("add_if_min", new AddIfMin(commandReceiver));
        commandInvoker.register("history", new History(commandReceiver));
        commandInvoker.register("filter_contains_part_number", new FilterContainsPartNumber(commandReceiver));
        commandInvoker.register("filter_greater_than_part_number", new FilterGreaterThanPartNumber(commandReceiver));

        try(Scanner scanner = new Scanner(System.in)) {
            while (scanner.hasNextLine()) {
                commandInvoker.executeCommand(scanner.nextLine().trim().split(" "));
            }
        }
    }
}
