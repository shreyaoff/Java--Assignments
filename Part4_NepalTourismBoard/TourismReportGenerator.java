import java.util.*;

class TourismReportGenerator {

    static void generateOverallReport(List<TouristDataSource> dataSources, DataProcessor processor) {

        System.out.println("Generating overall tourism report...");

        for (TouristDataSource dataSource : dataSources) {

            try {
                List<String> rawData = dataSource.fetchData();

                try {
                    List<String> processedData = processor.process(rawData);
                    System.out.println("Processed data from " + dataSource.sourceName + ": " + processedData);

                } catch (DataProcessingException e) {
                    System.out.println("Error processing data from " + dataSource.sourceName +
                            ": " + e.getMessage() + ". Skipping this data.");
                }

            } catch (DataSourceAccessException e) {
                System.out.println("Could not fetch data from " + dataSource.sourceName +
                        ": " + e.getMessage() + ". Skipping this source.");

                Throwable cause = e.getCause();
                if (cause != null) {
                    System.out.println("Reason: " + cause.getMessage());
                }

                continue;

            } finally {
                System.out.println("Data handling from " + dataSource.sourceName + " completed.");
            }

            System.out.println("------------------------------------------");
        }
    }

    public static void main(String[] args) {

        List<TouristDataSource> dataSources = new ArrayList<>();
        dataSources.add(new AirportArrivalsDataSource());
        dataSources.add(new HotelRegistrationsDataSource());
        dataSources.add(new AirportArrivalsDataSource());
        dataSources.add(new HotelRegistrationsDataSource());

        DataProcessor processor = new UniqueVisitorCounter();

        System.out.println("***** Nepal Tourism Board - Report Generator *****\n");

        TourismReportGenerator.generateOverallReport(dataSources, processor);

        System.out.println("\n***** Report Generation Finished *****");
    }
}
