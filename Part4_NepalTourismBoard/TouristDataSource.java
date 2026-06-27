import java.util.*;

class DataSourceAccessException extends Exception {

    public DataSourceAccessException(String message) {
        super(message);
    }

    public DataSourceAccessException(String message, Throwable cause) {
        super(message, cause);
    }
}

abstract class TouristDataSource {

    String sourceName;

    public TouristDataSource(String sourceName) {
        this.sourceName = sourceName;
    }

    abstract List<String> fetchData() throws DataSourceAccessException;
}
