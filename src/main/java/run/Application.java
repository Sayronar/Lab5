package run;

import commands.*;
import utility.*;

import java.util.Scanner;

public class Application {
    public static final String PS1 = "$ ";
    public static final String PS2 = "> ";

    public static void main(String[] args) {
        try (Scanner userScanner = new Scanner(System.in)) {
            final String envVariable = "LAB5";
            OrganizationAsker organizationAsker = new OrganizationAsker(userScanner);
            FileManager fileManager = new FileManager(envVariable);
            CollectionManager collectionManager = new CollectionManager(fileManager);
            //collectionManager.loadCollection();
            CommandManager commandManager = new CommandManager(
                    new HelpCommand(),
                    new InfoCommand(collectionManager),
                    new ShowCommand(collectionManager),
                    new AddCommand(collectionManager, organizationAsker),
                    new UpdateIdCommand(collectionManager, organizationAsker),
                    new RemoveByIdCommand(collectionManager),
                    new ClearCommand(collectionManager),
                    new SaveCommand(collectionManager),
                    new ExitCommand(),
                    new ExecuteScriptCommand(),
                    new RemoveGreaterCommand(collectionManager, organizationAsker),
                    new RemoveLowerCommand(collectionManager, organizationAsker),
                    new HistoryCommand(),
                    new EmployeesCountCommand(collectionManager),
                    new FilterContainsNameCommand(collectionManager),
                    new FilterGreaterThanEmployeesCountCommand(collectionManager)
            );
            Console console = new Console(commandManager, userScanner, organizationAsker);

            console.interactiveMode();
        }
    }
}
