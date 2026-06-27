import java.util.*;

class AuthenticationFailedException extends Exception {
    public AuthenticationFailedException(String message) {
        super(message);
    }
}

class HotelRegistrationsDataSource extends TouristDataSource {

    public HotelRegistrationsDataSource() {
        super("Kathmandu Hotels Registrations");
    }

    @Override
    List<String> fetchData() throws DataSourceAccessException {

        // Simulate a random authentication failure (~20% of the time)
        if (sourceName.contains("Hotels") && Math.random() < 0.2) {
            AuthenticationFailedException specificError = new AuthenticationFailedException(
                "Hotel API authentication failed! Did someone forget the password again?");

            throw new DataSourceAccessException(
                "Failed to fetch data from " + sourceName, specificError);
        }

        List<String> data = new ArrayList<>();
        data.add("Hotel: Yak & Yeti, Guest: Ram Thapa, NP");
        data.add("Hotel: Annapurna, Guest: Alice Smith, AU");
        data.add("Hotel: Yak & Yeti, Guest: Ram Thapa, NP");
        return data;
    }

    public static void main(String[] args) {

        HotelRegistrationsDataSource hotelSource = new HotelRegistrationsDataSource();

        for (int i = 1; i <= 5; i++) {
            System.out.println("Attempt " + i + ": Fetching data from " + hotelSource.sourceName + "...");

            try {
                List<String> data = hotelSource.fetchData();
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
