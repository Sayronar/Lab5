package utility;

import data.Address;
import data.Coordinates;
import data.Location;
import data.OrganizationType;
import exceptions.IncorrectInputInScriptException;
import exceptions.MustBeNotEmptyException;
import exceptions.NotInDeclaredLimitsException;
import run.Application;

import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 * Asks a user a organization's value.
 */
public class OrganizationAsker {
    private final Long MIN_EMPLOYEES = 1L;
    private final int MIN_TURNOVER = 1;

    private Scanner userScanner;
    private boolean fileMode;

    public OrganizationAsker(Scanner userScanner) {
        this.userScanner = userScanner;
        fileMode = false;
    }

    /**
     * Sets a scanner to scan user input.
     * @param userScanner Scanner to set.
     */
    public void setUserScanner(Scanner userScanner) {
        this.userScanner = userScanner;
    }

    /**
     * @return Scanner, which uses for user input.
     */
    public Scanner getUserScanner() {
        return userScanner;
    }

    /**
     * Sets organization asker mode to 'File Mode'.
     */
    public void setFileMode() {
        fileMode = true;
    }

    /**
     * Sets organization asker mode to 'User Mode'.
     */
    public void setUserMode() {
        fileMode = false;
    }

    public String askName() throws IncorrectInputInScriptException {
        String name;
        while (true) {
            try {
                Console.println("Введите название организации:");
                Console.print(Application.PS2);
                name = userScanner.nextLine().trim();
                if (fileMode) Console.println(name);
                if (name.equals("")) throw new MustBeNotEmptyException();
                break;
            } catch (NoSuchElementException exception) {
                Console.printerror("Название организации не распознано!");
                if (fileMode) throw new IncorrectInputInScriptException();
            } catch (MustBeNotEmptyException exception) {
                Console.printerror("Название организации не может быть пустым!");
                if (fileMode) throw new IncorrectInputInScriptException();
            } catch (IllegalStateException exception) {
                Console.printerror("Непредвиденная ошибка!");
                System.exit(0);
            }
        }
        return name;
    }

    public long askCoordinatesX() throws IncorrectInputInScriptException {
        String strX;
        long x;
        while (true) {
            try {
                Console.println("Введите координату X:");
                Console.print(Application.PS2);
                strX = userScanner.nextLine().trim();
                if (fileMode) Console.println(strX);
                x = Long.parseLong(strX);
                break;
            } catch (NoSuchElementException exception) {
                Console.printerror("Координата X не распознана!");
                if (fileMode) throw new IncorrectInputInScriptException();
            } catch (NumberFormatException exception) {
                Console.printerror("Координата X должна быть представлена числом!");
                if (fileMode) throw new IncorrectInputInScriptException();
            } catch (NullPointerException | IllegalStateException exception) {
                Console.printerror("Непредвиденная ошибка!");
                System.exit(0);
            }
        }
        return x;
    }

    public Integer askCoordinatesY() throws IncorrectInputInScriptException {
        String strY;
        Integer y;
        while (true) {
            try {
                Console.println("Введите координату Y:");
                Console.print(Application.PS2);
                strY = userScanner.nextLine().trim();
                if (fileMode) Console.println(strY);
                y = Integer.parseInt(strY);
                break;
            } catch (NoSuchElementException exception) {
                Console.printerror("Координата Y не распознана!");
                if (fileMode) throw new IncorrectInputInScriptException();
            } catch (NumberFormatException exception) {
                Console.printerror("Координата Y должна быть представлена числом!");
                if (fileMode) throw new IncorrectInputInScriptException();
            } catch (NullPointerException | IllegalStateException exception) {
                Console.printerror("Непредвиденная ошибка!");
                System.exit(0);
            }
        }
        return y;
    }

    public Coordinates askCoordinates() throws IncorrectInputInScriptException {
        long x;
        Integer y;
        x = askCoordinatesX();
        y = askCoordinatesY();
        return new Coordinates(x, y);
    }

    public int askTurnover() throws IncorrectInputInScriptException {
        String strTurnover;
        int turnover;
        while (true) {
            try {
                Console.println("Введите годовой оборот:");
                Console.print(Application.PS2);
                strTurnover = userScanner.nextLine().trim();
                if (fileMode) Console.println(strTurnover);
                turnover = Integer.parseInt(strTurnover);
                if (turnover < MIN_TURNOVER) throw new NotInDeclaredLimitsException();
                break;
            } catch (NoSuchElementException exception) {
                Console.printerror("Годовой оборот не распознан!");
                if (fileMode) throw new IncorrectInputInScriptException();
            } catch (NotInDeclaredLimitsException exception) {
                Console.printerror("Годовой оборот должен быть больше нуля!");
                if (fileMode) throw new IncorrectInputInScriptException();
            } catch (NumberFormatException exception) {
                Console.printerror("Годовой оборот должен быть представлен числом!");
                if (fileMode) throw new IncorrectInputInScriptException();
            } catch (NullPointerException | IllegalStateException exception) {
                Console.printerror("Непредвиденная ошибка!");
                System.exit(0);
            }
        }
        return turnover;
    }

    public String askFullName() throws IncorrectInputInScriptException {
        String fullName;
        while (true) {
            try {
                Console.println("Введите полное название компании:");
                Console.print(Application.PS2);
                fullName = userScanner.nextLine().trim();
                if (fileMode) Console.println(fullName);
                if (fullName.equals("")) throw new MustBeNotEmptyException();
                break;
            } catch (NoSuchElementException exception) {
                Console.printerror("Полное название компании не распознано!");
                if (fileMode) throw new IncorrectInputInScriptException();
            } catch (MustBeNotEmptyException exception) {
                Console.printerror("Полное название компании не может быть пустым!");
                if (fileMode) throw new IncorrectInputInScriptException();
            } catch (IllegalStateException exception) {
                Console.printerror("Непредвиденная ошибка!");
                System.exit(0);
            }
        }
        return fullName;
    }

    public Long askEmployeesCount() throws IncorrectInputInScriptException {
        String strEmployeesCount;
        Long employeesCount;
        while (true) {
            try {
                Console.println("Введите количество сотрудниковY:");
                Console.print(Application.PS2);
                strEmployeesCount = userScanner.nextLine().trim();
                if (fileMode) Console.println(strEmployeesCount);
                employeesCount = Long.parseLong(strEmployeesCount);
                if (employeesCount < MIN_EMPLOYEES) throw new NotInDeclaredLimitsException();
                break;
            } catch (NoSuchElementException exception) {
                Console.printerror("Количество сотрудников не распознано!");
                if (fileMode) throw new IncorrectInputInScriptException();
            } catch (NotInDeclaredLimitsException exception) {
                Console.printerror("Количество сотрудников должно быть больше нуля!");
                if (fileMode) throw new IncorrectInputInScriptException();
            } catch (NumberFormatException exception) {
                Console.printerror("Количество сотрудников должно быть представлено числом!");
                if (fileMode) throw new IncorrectInputInScriptException();
            } catch (NullPointerException | IllegalStateException exception) {
                Console.printerror("Непредвиденная ошибка!");
                System.exit(0);
            }
        }
        return employeesCount;
    }

    public OrganizationType askType() throws IncorrectInputInScriptException {
        String strType;
        OrganizationType type;
        while (true) {
            try {
                Console.println("Список типов организаций - " + OrganizationType.nameList());
                Console.println("Введите тип:");
                Console.print(Application.PS2);
                strType = userScanner.nextLine().trim();
                if (fileMode) Console.println(strType);
                type = OrganizationType.valueOf(strType.toUpperCase());
                break;
            } catch (NoSuchElementException exception) {
                Console.printerror("Тип не распознан!");
                if (fileMode) throw new IncorrectInputInScriptException();
            } catch (IllegalArgumentException exception) {
                Console.printerror("Типа нет в списке!");
                if (fileMode) throw new IncorrectInputInScriptException();
            } catch (IllegalStateException exception) {
                Console.printerror("Непредвиденная ошибка!");
                System.exit(0);
            }
        }
        return type;
    }

    public String askStreet() throws IncorrectInputInScriptException {
        String StreetName;
        while (true) {
            try {
                Console.println("Введите улицу:");
                Console.print(Application.PS2);
                StreetName = userScanner.nextLine().trim();
                if (fileMode) Console.println(StreetName);
                if (StreetName.equals("")) throw new MustBeNotEmptyException();
                break;
            } catch (NoSuchElementException exception) {
                Console.printerror("Улица не распознана!");
                if (fileMode) throw new IncorrectInputInScriptException();
            } catch (MustBeNotEmptyException exception) {
                Console.printerror("Улица не может быть пустой!");
                if (fileMode) throw new IncorrectInputInScriptException();
            } catch (IllegalStateException exception) {
                Console.printerror("Непредвиденная ошибка!");
                System.exit(0);
            }
        }
        return StreetName;
    }

    public Address askAddress() throws IncorrectInputInScriptException {
        String street;
        Location town;
        street = askStreet();
        town = askLocation();
        return new Address(street, town);
    }

    public int askLocationX() throws IncorrectInputInScriptException {
        String strX;
        int x;
        while (true) {
            try {
                Console.println("Введите координату X:");
                Console.print(Application.PS2);
                strX = userScanner.nextLine().trim();
                if (fileMode) Console.println(strX);
                x = Integer.parseInt(strX);
                break;
            } catch (NoSuchElementException exception) {
                Console.printerror("Координата X не распознана!");
                if (fileMode) throw new IncorrectInputInScriptException();
            } catch (NumberFormatException exception) {
                Console.printerror("Координата X должна быть представлена числом!");
                if (fileMode) throw new IncorrectInputInScriptException();
            } catch (NullPointerException | IllegalStateException exception) {
                Console.printerror("Непредвиденная ошибка!");
                System.exit(0);
            }
        }
        return x;
    }

    public Float askLocationY() throws IncorrectInputInScriptException {
        String strY;
        Float y;
        while (true) {
            try {
                Console.println("Введите координату Y:");
                Console.print(Application.PS2);
                strY = userScanner.nextLine().trim();
                if (fileMode) Console.println(strY);
                y = Float.parseFloat(strY);
                break;
            } catch (NoSuchElementException exception) {
                Console.printerror("Координата Y не распознана!");
                if (fileMode) throw new IncorrectInputInScriptException();
            } catch (NumberFormatException exception) {
                Console.printerror("Координата Y должна быть представлена числом!");
                if (fileMode) throw new IncorrectInputInScriptException();
            } catch (NullPointerException | IllegalStateException exception) {
                Console.printerror("Непредвиденная ошибка!");
                System.exit(0);
            }
        }
        return y;
    }


    public long askLocationZ() throws IncorrectInputInScriptException {
        String strZ;
        long z;
        while (true) {
            try {
                Console.println("Введите координату Z:");
                Console.print(Application.PS2);
                strZ = userScanner.nextLine().trim();
                if (fileMode) Console.println(strZ);
                z = Long.parseLong(strZ);
                break;
            } catch (NoSuchElementException exception) {
                Console.printerror("Координата Z не распознана!");
                if (fileMode) throw new IncorrectInputInScriptException();
            } catch (NumberFormatException exception) {
                Console.printerror("Координата Z должна быть представлена числом!");
                if (fileMode) throw new IncorrectInputInScriptException();
            } catch (NullPointerException | IllegalStateException exception) {
                Console.printerror("Непредвиденная ошибка!");
                System.exit(0);
            }
        }
        return z;
    }

    public Location askLocation() throws IncorrectInputInScriptException {
        int x;
        Float y; //Поле не может быть null
        long z;
        x = askLocationX();
        y = askLocationY();
        z = askLocationZ();
        return new Location(x, y, z);
    }

    /**
     * Asks a user a question.
     * @return Answer (true/false).
     * @param question A question.
     * @throws IncorrectInputInScriptException If script is running and something goes wrong.
     */
    public boolean askQuestion(String question) throws IncorrectInputInScriptException {
        String finalQuestion = question + " (+/-):";
        String answer;
        while (true) {
            try {
                Console.println(finalQuestion);
                Console.print(Application.PS2);
                answer = userScanner.nextLine().trim();
                if (fileMode) Console.println(answer);
                if (!answer.equals("+") && !answer.equals("-")) throw new NotInDeclaredLimitsException();
                break;
            } catch (NoSuchElementException exception) {
                Console.printerror("Ответ не распознан!");
                if (fileMode) throw new IncorrectInputInScriptException();
            } catch (NotInDeclaredLimitsException exception) {
                Console.printerror("Ответ должен быть представлен знаками '+' или '-'!");
                if (fileMode) throw new IncorrectInputInScriptException();
            } catch (IllegalStateException exception) {
                Console.printerror("Непредвиденная ошибка!");
                System.exit(0);
            }
        }
        return (answer.equals("+")) ? true : false;
    }

    @Override
    public String toString() {
        return "OrganizationAsker (вспомогательный класс для запросов пользователю)";
    }
}
