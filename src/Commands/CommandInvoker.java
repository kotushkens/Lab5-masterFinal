package Commands;

import BasicClasses.Organization;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

/**
 * Выполяет команды. Хранит зарегистрированные команды и список последних вызванных команд.
 */
public class CommandInvoker {
    private final HashMap<String, Command> commandMap = new HashMap<>();

    private static ArrayList<String> commandHistoryList = new ArrayList<String>();

    public void register(String commandName, Command command) {
        commandMap.put(commandName, command);
    }

    public void executeCommand(String[] commandName) {
        try {
            if (commandName.length > 0) {
                commandHistoryList.add(commandName[0]);
                Command command = commandMap.get(commandName[0]);
                command.execute(commandName);
            } else { System.out.println("Вы не ввели команду."); }
        } catch (IllegalStateException | NullPointerException ex) {
            System.out.println("Не существует команды " + commandName[0] + ". Для справки используйте – help");
        }
    }


    public static ArrayList<String> getCommandHistoryList() {
        return commandHistoryList;
    }


    HashMap<String, Command> getCommandMap() {
        return commandMap;
    }
}
