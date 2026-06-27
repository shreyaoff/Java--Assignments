import java.util.*;

class DataProcessingException extends Exception {
    public DataProcessingException(String message) {
        super(message);
    }
}

interface DataProcessor {
    List<String> process(List<String> rawData) throws DataProcessingException;
}
