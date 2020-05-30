package Commands;

import BasicClasses.Product;
import Collection.CollectionManager;
import Collection.CollectionUtils;
import Commands.Utils.Creaters.ElementCreator;
import Commands.Utils.JSON.ParserJson;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;


import static Commands.ConcreteCommands.ExecuteScript.getPath;


/**
 * Описывает основную логику команд, при надобности делегирует ее консольному менеджеру.
 */
public class CommandReceiver {
    private final CommandInvoker commandInvoker;
    private Product product;

    public CommandReceiver(CommandInvoker commandInvoker) {
        this.commandInvoker = commandInvoker;
    }

    public void help() {
        commandInvoker.getCommandMap().forEach((name, command) -> command.writeInfo());
    }

    public void info() { // добавить класс
        CollectionManager.getInfo();
    }

    public void show() {
        CollectionManager.show();
    }

    public void add() {
        CollectionManager.add(ElementCreator.createProduct());
        System.out.println("Элемент добавлен в коллекцию.");
    }

    /**
     * @param ID - апдейт элемента по ID.
     */
    public void update(String ID) {
        Integer productId;
        try {
            productId = Integer.parseInt(ID);
            if (CollectionUtils.checkExist(productId)) {
                CollectionManager.update(ElementCreator.createProduct(), productId);
            } else {
                System.out.println("Элемента с таким ID нет в коллекции.");
            }
        } catch (NumberFormatException e) {
            System.out.println("Команда не выполнена. Вы ввели некорректный аргумент.");
        }
    }

    /**
     * @param ID - удаление по ID.
     */


    public void remove_by_id(String ID) {
        Integer productId;
        try {
            productId = Integer.parseInt(ID);
            CollectionManager.remove_by_id(productId);
        } catch (NumberFormatException e) {
            System.out.println("Команда не выполнена. Вы ввели некорректный аргумент.");
        }
    }

    public void clear() {
        CollectionManager.clear();
        System.out.println("Коллекция успешно очищена.");
    }

    public void exit() {
        System.out.println("Завершение работы программы.");
        System.exit(0);
    }

    public void head() {
        CollectionManager.head();
    }


    public void filter_contains_part_number(String partNumber) {
        CollectionManager.filter_contains_part_number(partNumber);
    }

    public void filter_greater_than_part_number(String partNumber) {
        CollectionManager.filter_greater_than_part_number(partNumber);
    }

    public void add_if_min() {
        CollectionManager.add_if_min(ElementCreator.createProduct());
    }

    public void history() {
        System.out.println("Последние вызванные команды (до 9): ");
        try {
            for (int i = 0; i < 9; i++) {
                System.out.println(commandInvoker.getCommandHistoryList().get(i));
            }
        } catch (IndexOutOfBoundsException e) {
            System.out.println("За время работы было вызвано менее 9 команд");
        }
    }


            /**
             *
             * @param path - Путь до файла, который будем считывать.
             */

            public void executeScript(String path) {
                String line;
                String command;
                ArrayList<String> parameters = new ArrayList<>();
                try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new BufferedInputStream(new FileInputStream(path)), StandardCharsets.UTF_8))) {
                    while ((line = bufferedReader.readLine()) != null) {
                        if (line.split(" ")[0].matches("add|update|")) {
                            command = line;
                            for (int i = 0; i < 15; i++) {
                                if (line != null) {
                                    line = bufferedReader.readLine();
                                    parameters.add(line);
                                } else {
                                    System.out.println("Не хватает параметров для создания объекта.");
                                    break;
                                }
                            }
                            Product product = ElementCreator.createScriptProduct(parameters);
                            switch (command.split(" ")[0]) {
                                case "add":
                                    CollectionManager.add(product);
                                    break;
                                case "update":
                                    CollectionManager.update(product, Integer.parseInt(command.split(" ")[1]));
                            }
                        } else if (line.split(" ")[0].equals("execute_script")
                                && line.split(" ")[1].equals(getPath())) {
                            System.out.println("Пресечена попытка рекурсивного вызова скрипта.");
                        } else {
                            commandInvoker.executeCommand(line.split(" "));
                        }
                    }
                } catch (IOException e) {
                    System.out.println("Ошибка! " + e.getMessage());
                }
            }

            /**
             * Сохранение коллекции
             */
           public void save() {
                ParserJson.collectionToJson();
            }
        }