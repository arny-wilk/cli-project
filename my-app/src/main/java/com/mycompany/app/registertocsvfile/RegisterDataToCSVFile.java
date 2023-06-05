package registertocsvfile;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Serializable;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class RegisterDataToCSVFile implements CSVParserForArray, Serializable {

    private File fileName;

    public RegisterDataToCSVFile(String namePath) {
        this.fileName = new File(getClass().getClassLoader().getResource(namePath).getPath());
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
    public String convertToCSV(String[] stringArray) {
        return Stream.of(stringArray)
                .map(this::escapeSpecialCharacters)
                .collect(Collectors.joining(","));
    }

    @Override
    public void writeToCsvFile(List<String[]> arrayList) {
        try (FileWriter csvOutputFile = new FileWriter(fileName);
                PrintWriter pw = new PrintWriter(csvOutputFile);) {
            arrayList.stream().map(this::convertToCSV).forEach(pw::println);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public File getFileName() {
        return fileName;
    }

    public void setFileName(File fileName) {
        this.fileName = fileName;
    }
}
