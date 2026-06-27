class SameLocationException extends InvalidRouteException {
    public SameLocationException(String message) {
        super(message);
    }
}

class KathmanduTrafficValidator implements RouteValidator {

    @Override
    public boolean isValidCommuteRoute(String origin, String destination, double distanceKm)
            throws InvalidRouteException, SameLocationException {

        if (origin.equalsIgnoreCase(destination)) {
            throw new SameLocationException(
                "Origin and destination cannot be the same! Are you just spinning in circles, Damodar?");
        }

        if (distanceKm < 0.1 || distanceKm > 30) {
            throw new InvalidRouteException(
                "Distance " + distanceKm + "km is unrealistic for Kathmandu commute!");
        }

        return true;
    }

    public static void main(String[] args) {

        KathmanduTrafficValidator validator = new KathmanduTrafficValidator();

        Object[][] testCases = {
            {"Thamel", "Patan", 8.0},
            {"Baneshwor", "Baneshwor", 5.0},
            {"Kalanki", "Balaju", 0.05},
            {"Bhaktapur", "Nagarkot", 35.0}
        };

        for (Object[] test : testCases) {
            String origin = (String) test[0];
            String destination = (String) test[1];
            double distance = (double) test[2];

            System.out.println("Checking route: " + origin + " -> " + destination + " (" + distance + " km)");

            try {
                boolean result = validator.isValidCommuteRoute(origin, destination, distance);
                System.out.println("Result: Valid route! (" + result + ")");

            } catch (SameLocationException e) {
                System.out.println("Same Location Error: " + e.getMessage());

            } catch (InvalidRouteException e) {
                System.out.println("Invalid Route Error: " + e.getMessage());
            }

            System.out.println("------------------------------------------");
        }
    }
}
