package utility;

import data.Organization;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.*;
import java.util.Collection;
import java.util.TreeSet;

/**

 Operates the file for saving/loading collection.
 */
public class FileManager {
    private String envVariable;

    public FileManager(String envVariable) {
        this.envVariable = envVariable;
    }

    /**

     Writes collection to a file.
     @param collection Collection to write.
     */
    public void writeCollection(Collection<?> collection) {
        if (System.getenv().get(envVariable) != null) {
            try (BufferedOutputStream collectionFileOutputStream = new BufferedOutputStream(new FileOutputStream(new File(System.getenv().get(envVariable))))) {
                JAXBContext jaxbContext = JAXBContext.newInstance(collection.getClass());
                Marshaller marshaller = jaxbContext.createMarshaller();
                marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
                marshaller.marshal(collection, collectionFileOutputStream);
                Console.println("Коллекция успешно сохранена в файл!");
            } catch (IOException | JAXBException exception) {
                Console.printerror("Загрузочный файл является директорией/не может быть открыт!");
            }
        } else Console.printerror("Системная переменная с загрузочным файлом не найдена!");
    }
    /**

     Reads collection from a file.
     @return Readed collection.
     */
    public TreeSet<Organization> readCollection() {
        if (System.getenv().get(envVariable) != null) {
            try (BufferedReader collectionFileReader = new BufferedReader(new FileReader(new File(System.getenv().get(envVariable))))) {
                JAXBContext jaxbContext = JAXBContext.newInstance(TreeSet.class, Organization.class);
                Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
                return (TreeSet<Organization>) unmarshaller.unmarshal(collectionFileReader);
            } catch (FileNotFoundException exception) {
                Console.printerror("Загрузочный файл не найден!");
            } catch (JAXBException exception) {
                Console.printerror("В загрузочном файле не обнаружена необходимая коллекция!");
            } catch (IOException exception) {
                Console.printerror("Ошибка чтения загрузочного файла!");
            }
        } else Console.printerror("Системная переменная с загрузочным файлом не найдена!");
        return new TreeSet<Organization>();
    }
    @Override
    public String toString() {
        String string = "FileManager (класс для работы с загрузочным файлом)";
        return string;
    }
}
