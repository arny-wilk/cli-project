package registertocsvfile;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class RegisterDataToCSVFile implements ByteParser, ConverToList, CSVParserForArray {

    private String fileName;

    public RegisterDataToCSVFile(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public byte[] parseArrayToByteArray(Object[] array) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream)) {
            objectOutputStream.writeObject(array);
            objectOutputStream.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return byteArrayOutputStream.toByteArray();
    }

    @Override
    public String[] parseByteArrayToStringArray(byte[] array) {
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(array);
        try (ObjectInputStream objectInputStream = new ObjectInputStream(byteArrayInputStream)) {
            return (String[]) objectInputStream.readObject();
        } catch (ClassNotFoundException | IOException e) {
            e.printStackTrace();
        }
        return (String[]) Optional.empty().orElse(new String[0]);
    }
    
    @Override
    public String escapeSpecialCharacters(String data) {
        String escapedData = data.replaceAll("\\R", " ");
        if (data.contains(",") || data.contains("\"") || data.contains("'")) {
            data = data.replace("\"", "\"\"");
            escapedData = "\"" + data + "\"";
        }
        return escapedData;
    }
    
    @Override
    public String convertToCSV(String[] object) {
        return Stream.of(object)
                .map(this::escapeSpecialCharacters)
                .collect(Collectors.joining(","));
    }

    @Override
    public void convertStringArrayToList(String[] stringArray) {
        List<String[]> usersList = new ArrayList<>();
        usersList.add(stringArray);
    }

    @Override
    public void writeToCsvFile(List<String[]> list) {
        try (FileWriter csvOutputFile = new FileWriter(fileName)) {
            PrintWriter pw = new PrintWriter(csvOutputFile);
            list.stream().map(this::convertToCSV).forEach(pw::println);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
