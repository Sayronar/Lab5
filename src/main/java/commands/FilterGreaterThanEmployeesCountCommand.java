package commands;

import exceptions.CollectionIsEmptyException;
import exceptions.WrongAmountOfElementsException;
import utility.CollectionManager;
import utility.Console;

public class FilterGreaterThanEmployeesCountCommand extends AbstractCommand {
    private CollectionManager collectionManager;

    public FilterGreaterThanEmployeesCountCommand(CollectionManager collectionManager) {
        super("filter_greater_than_employees_count", "вывести элементы, значение поля employeesCount которых больше заданного");
        this.collectionManager = collectionManager;
    }

    /**
     * Executes the command.
     * @return Command exit status.
     */
    @Override
    public boolean execute(String argument) {
        try {
            if (argument.isEmpty()) throw new WrongAmountOfElementsException();
            if (collectionManager.collectionSize() == 0) throw new CollectionIsEmptyException();
            Long employeesCount = Long.parseLong(argument);
            String filteredInfo = collectionManager.employeesCountFilteredInfo(employeesCount);
            if (!filteredInfo.isEmpty()) {
                Console.println(filteredInfo);
                return true;
            } else Console.println("В коллекции нет организаций с количеством сотрудников больше, чем заданное!");
        } catch (WrongAmountOfElementsException exception) {
            Console.println("Использование: '" + getName() + "'");
        } catch (CollectionIsEmptyException exception) {
            Console.printerror("Коллекция пуста!");
        } catch (IllegalArgumentException exception) {
            Console.printerror("Организации нет в списке!");
        }
        return false;
    }
}