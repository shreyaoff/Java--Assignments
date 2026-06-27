class GPSNavigationModule implements NavigationService {

    @Override
    public void navigate(String startPoint, String endPoint, RouteValidator validator) throws NavigationFailedException {

        System.out.println("Attempting to navigate from " + startPoint + " to " + endPoint + "...");

        // Simulated GPS signal loss at a known traffic spot
        if (startPoint.equalsIgnoreCase("Kalanki")) {
            throw new NavigationFailedException(
                "GPS signal lost near Kalanki! Welcome to Kathmandu traffic!");
        }

        try {
            double distance = simulatedDistance(startPoint, endPoint);
            validator.isValidCommuteRoute(startPoint, endPoint, distance);

        } catch (InvalidRouteException e) {
            // Wrap the validation error inside NavigationFailedException
            // (also catches SameLocationException since it's a subtype)
            throw new NavigationFailedException("Route validation failed!", e);
        }

        System.out.println("Navigation successful! Estimated time: 20 minutes (or 2 hours depending on traffic).");
    }

    private double simulatedDistance(String start, String end) {
        return 5.0;
    }

    public static void main(String[] args) {

        GPSNavigationModule gps = new GPSNavigationModule();
        RouteValidator validator = new KathmanduTrafficValidator();

        String[][] testRoutes = {
            {"Thamel", "Patan"},
            {"Baneshwor", "Baneshwor"},
            {"Kalanki", "Balaju"}
        };

        for (String[] route : testRoutes) {
            String start = route[0];
            String end = route[1];

            try {
                gps.navigate(start, end, validator);

            } catch (NavigationFailedException e) {
                System.out.println("Navigation Failed: " + e.getMessage());

                Throwable cause = e.getCause();
                if (cause != null) {
                    System.out.println("   Underlying cause: " + cause.getClass().getSimpleName() +
                            " - " + cause.getMessage());
                } else {
                    System.out.println("   No underlying cause (e.g. GPS signal loss issue).");
                }
            }

            System.out.println("------------------------------------------");
        }
    }
}
