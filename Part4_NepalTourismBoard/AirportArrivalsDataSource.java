import java.util.*;

class ConnectionLostException extends Exception {
    public ConnectionLostException(String message) {
        super(message);
    }
}

class AirportArrivalsDataSource extends TouristDataSource {

    public AirportArrivalsDataSource() {
        super("Tribhuvan Airport Arrivals");
    }

    @Override
    List<String> fetchData() throws DataSourceAccessException {

        if (sourceName.contains("Tribhuvan") && Math.random() < 0.3) {
            ConnectionLostException specificError = new ConnectionLostException(
                "Airport data connection lost! Maybe a pigeon sat on the antenna?");

            throw new DataSourceAccessException(
                "Failed to fetch data from " + sourceName, specificError);
        }

        List<String> data = new ArrayList<>();
        data.add("Visitor: John Doe, USA");
        data.add("Visitor: Emily White, UK");
        data.add("Visitor: John Doe, USA");
        return data;
    }

    public static void main(String[] args) {

        AirportArrivalsDataSource airportSource = new AirportArrivalsDataSource();

        for (int i = 1; i <= 5; i++) {
            System.out.println("Attempt " + i + ": Fetching data from " + airportSource.sourceName + "...");

            try {
                List<String> data = airportSource.fetchData();
                System.out.println("Success! Data received: " + data);

            } catch (DataSourceAccessException e) {
                System.out.println("Error: " + e.getMessage());

                Throwable cause = e.getCause();
                if (cause != null) {
                    System.out.println("   Reason: " + cause.getMessage());
                }
            }

            System.out.println("------------------------------------------");
        }
    }
}
