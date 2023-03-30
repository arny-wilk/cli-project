package registertocsvfile;

import java.util.List;

public interface CSVParserForArray {
    public abstract String escapeSpecialCharacters(String data);
    public abstract String convertToCSV(String[] object);
    public abstract void writeToCsvFile(List<String[]> stringArray);
}
