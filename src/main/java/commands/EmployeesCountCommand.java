package commands;

import exceptions.CollectionIsEmptyException;
import exceptions.WrongAmountOfElementsException;
import utility.CollectionManager;
import utility.Console;

public class EmployeesCountCommand extends AbstractCommand {
    private CollectionManager collectionManager;

    public EmployeesCountCommand(CollectionManager collectionManager) {
        super("count_by_employees_count", "вывести количество элементов, значение поля employeesCount которых равно заданному");
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
            String filteredInfo = String.valueOf(collectionManager.countByEmployeesCount(employeesCount));
            if (!filteredInfo.isEmpty()) {
                Console.println(filteredInfo);
                return true;
            } else Console.println("В коллекции нет организаций с равным заданному количеству сотрудников!");
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